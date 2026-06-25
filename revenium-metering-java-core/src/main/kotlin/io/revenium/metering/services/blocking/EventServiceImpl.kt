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
import io.revenium.metering.models.events.EventCreateParams
import io.revenium.metering.models.events.MeteringResponseResource
import java.util.function.Consumer

/** Event Metering Operations */
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

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EventService.WithRawResponse =
            EventServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<MeteringResponseResource> =
            jsonHandler<MeteringResponseResource>(clientOptions.jsonMapper)

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
            return errorHandler.handle(response).parseable {
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
