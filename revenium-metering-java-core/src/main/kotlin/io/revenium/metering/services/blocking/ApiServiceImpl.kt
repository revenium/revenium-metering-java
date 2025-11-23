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
import io.revenium.metering.models.apis.ApiMeterRequestParams
import io.revenium.metering.models.apis.ApiMeterResponseParams
import io.revenium.metering.models.events.MeteringResponseResource
import java.util.function.Consumer

class ApiServiceImpl internal constructor(private val clientOptions: ClientOptions) : ApiService {

    private val withRawResponse: ApiService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ApiService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiService =
        ApiServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun meterRequest(
        params: ApiMeterRequestParams,
        requestOptions: RequestOptions,
    ): MeteringResponseResource =
        // post /v2/apis/requests
        withRawResponse().meterRequest(params, requestOptions).parse()

    override fun meterResponse(
        params: ApiMeterResponseParams,
        requestOptions: RequestOptions,
    ): MeteringResponseResource =
        // post /v2/apis/responses
        withRawResponse().meterResponse(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ApiService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ApiService.WithRawResponse =
            ApiServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val meterRequestHandler: Handler<MeteringResponseResource> =
            jsonHandler<MeteringResponseResource>(clientOptions.jsonMapper)

        override fun meterRequest(
            params: ApiMeterRequestParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MeteringResponseResource> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "apis", "requests")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { meterRequestHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val meterResponseHandler: Handler<MeteringResponseResource> =
            jsonHandler<MeteringResponseResource>(clientOptions.jsonMapper)

        override fun meterResponse(
            params: ApiMeterResponseParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MeteringResponseResource> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "apis", "responses")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
