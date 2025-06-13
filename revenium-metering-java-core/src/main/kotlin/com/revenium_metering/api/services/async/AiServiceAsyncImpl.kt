// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.async

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
import com.revenium_metering.api.core.prepareAsync
import com.revenium_metering.api.models.ai.AiCreateCompletionParams
import com.revenium_metering.api.models.events.MeteringResponseResource
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

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AiServiceAsync.WithRawResponse =
            AiServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createCompletionHandler: Handler<MeteringResponseResource> =
            jsonHandler<MeteringResponseResource>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

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
                    response.parseable {
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
