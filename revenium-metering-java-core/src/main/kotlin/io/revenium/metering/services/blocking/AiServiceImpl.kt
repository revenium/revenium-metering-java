// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services.blocking

import io.revenium.metering.core.ClientOptions
import io.revenium.metering.core.RequestOptions
import io.revenium.metering.core.handlers.errorBodyHandler
import io.revenium.metering.core.handlers.errorHandler
import io.revenium.metering.core.handlers.jsonHandler
import io.revenium.metering.core.http.HttpMethod
import io.revenium.metering.core.http.HttpRequest
import io.revenium.metering.core.http.HttpResponse
import io.revenium.metering.core.http.HttpResponse.Handler
import io.revenium.metering.core.http.HttpResponseFor
import io.revenium.metering.core.http.json
import io.revenium.metering.core.http.parseable
import io.revenium.metering.core.prepare
import io.revenium.metering.models.ai.AiCreateCompletionParams
import io.revenium.metering.models.events.MeteringResponseResource
import java.util.function.Consumer

class AiServiceImpl internal constructor(private val clientOptions: ClientOptions) : AiService {

    private val withRawResponse: AiService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AiService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AiService =
        AiServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun createCompletion(
        params: AiCreateCompletionParams,
        requestOptions: RequestOptions,
    ): MeteringResponseResource =
        // post /v2/ai/completions
        withRawResponse().createCompletion(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AiService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AiService.WithRawResponse =
            AiServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createCompletionHandler: Handler<MeteringResponseResource> =
            jsonHandler<MeteringResponseResource>(clientOptions.jsonMapper)

        override fun createCompletion(
            params: AiCreateCompletionParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MeteringResponseResource> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "ai", "completions")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createCompletionHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
