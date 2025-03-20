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
import com.revenium_metering.api.models.apis.ApiMeterRequestParams
import com.revenium_metering.api.models.apis.ApiMeterResponseParams
import com.revenium_metering.api.models.events.MeteringResponseResource

class ApiServiceImpl internal constructor(private val clientOptions: ClientOptions) : ApiService {

    private val withRawResponse: ApiService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ApiService.WithRawResponse = withRawResponse

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

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val meterRequestHandler: Handler<MeteringResponseResource> =
            jsonHandler<MeteringResponseResource>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun meterRequest(
            params: ApiMeterRequestParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MeteringResponseResource> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v2", "apis", "requests")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
                .withErrorHandler(errorHandler)

        override fun meterResponse(
            params: ApiMeterResponseParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MeteringResponseResource> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v2", "apis", "responses")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
