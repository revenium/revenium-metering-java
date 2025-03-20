// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.blocking

import com.revenium_metering.api.core.ClientOptions
import com.revenium_metering.api.core.JsonValue
import com.revenium_metering.api.core.RequestOptions
import com.revenium_metering.api.core.handlers.errorHandler
import com.revenium_metering.api.core.handlers.jsonHandler
import com.revenium_metering.api.core.handlers.withErrorHandler
import com.revenium_metering.api.core.http.HttpMethod
import com.revenium_metering.api.core.http.HttpRequest
import com.revenium_metering.api.core.http.HttpResponse.Handler
import com.revenium_metering.api.core.http.HttpResponseFor
import com.revenium_metering.api.core.http.json
import com.revenium_metering.api.core.http.parseable
import com.revenium_metering.api.core.prepare
import com.revenium_metering.api.models.ai.AiCreateCompletionParams
import com.revenium_metering.api.models.events.MeteringResponseResource

class AiServiceImpl internal constructor(private val clientOptions: ClientOptions) : AiService {

    private val withRawResponse: AiService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AiService.WithRawResponse = withRawResponse

    override fun createCompletion(
        params: AiCreateCompletionParams,
        requestOptions: RequestOptions,
    ): MeteringResponseResource =
        // post /v2/ai/completions
        withRawResponse().createCompletion(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AiService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createCompletionHandler: Handler<MeteringResponseResource> =
            jsonHandler<MeteringResponseResource>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun createCompletion(
            params: AiCreateCompletionParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MeteringResponseResource> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v2", "ai", "completions")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
