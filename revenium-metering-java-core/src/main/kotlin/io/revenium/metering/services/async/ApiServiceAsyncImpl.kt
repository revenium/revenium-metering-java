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
import io.revenium.metering.models.apis.ApiMeterRequestParams
import io.revenium.metering.models.apis.ApiMeterResponseParams
import io.revenium.metering.models.events.MeteringResponseResource
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ApiServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ApiServiceAsync {

    private val withRawResponse: ApiServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ApiServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiServiceAsync =
        ApiServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun meterRequest(
        params: ApiMeterRequestParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MeteringResponseResource> =
        // post /v2/apis/requests
        withRawResponse().meterRequest(params, requestOptions).thenApply { it.parse() }

    override fun meterResponse(
        params: ApiMeterResponseParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<MeteringResponseResource> =
        // post /v2/apis/responses
        withRawResponse().meterResponse(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ApiServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ApiServiceAsync.WithRawResponse =
            ApiServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val meterRequestHandler: Handler<MeteringResponseResource> =
            jsonHandler<MeteringResponseResource>(clientOptions.jsonMapper)

        override fun meterRequest(
            params: ApiMeterRequestParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "apis", "requests")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { meterRequestHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val meterResponseHandler: Handler<MeteringResponseResource> =
            jsonHandler<MeteringResponseResource>(clientOptions.jsonMapper)

        override fun meterResponse(
            params: ApiMeterResponseParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "apis", "responses")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { meterResponseHandler.handle(it) }
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
