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
import com.revenium_metering.api.models.events.EventCreateParams
import com.revenium_metering.api.models.events.MeteringResponseResource
import java.util.function.Consumer

class EventServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    EventService {

    private val withRawResponse: EventService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): EventService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService =
        EventServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: EventCreateParams,
        requestOptions: RequestOptions,
    ): MeteringResponseResource =
        // post /v2/events
        withRawResponse().create(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EventService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EventService.WithRawResponse =
            EventServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<MeteringResponseResource> =
            jsonHandler<MeteringResponseResource>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: EventCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MeteringResponseResource> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v2", "events")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
