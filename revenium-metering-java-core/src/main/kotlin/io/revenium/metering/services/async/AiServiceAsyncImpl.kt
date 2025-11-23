// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services.async

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
import io.revenium.metering.core.prepareAsync
import io.revenium.metering.models.ai.AiCreateCompletionParams
import io.revenium.metering.models.events.MeteringResponseResource
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class AiServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AiServiceAsync {

    private val withRawResponse: AiServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AiServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AiServiceAsync =
        AiServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun createCompletion(
        params: AiCreateCompletionParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MeteringResponseResource> =
        // post /v2/ai/completions
        withRawResponse().createCompletion(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AiServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AiServiceAsync.WithRawResponse =
            AiServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createCompletionHandler: Handler<MeteringResponseResource> =
            jsonHandler<MeteringResponseResource>(clientOptions.jsonMapper)

        override fun createCompletion(
            params: AiCreateCompletionParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "ai", "completions")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
}
