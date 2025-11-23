// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.client

import io.revenium.metering.core.ClientOptions
import io.revenium.metering.core.getPackageVersion
import io.revenium.metering.services.blocking.AiService
import io.revenium.metering.services.blocking.AiServiceImpl
import io.revenium.metering.services.blocking.ApiService
import io.revenium.metering.services.blocking.ApiServiceImpl
import io.revenium.metering.services.blocking.EventService
import io.revenium.metering.services.blocking.EventServiceImpl
import java.util.function.Consumer

class ReveniumMeteringClientImpl(private val clientOptions: ClientOptions) :
    ReveniumMeteringClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: ReveniumMeteringClientAsync by lazy {
        ReveniumMeteringClientAsyncImpl(clientOptions)
    }

    private val withRawResponse: ReveniumMeteringClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val events: EventService by lazy { EventServiceImpl(clientOptionsWithUserAgent) }

    private val apis: ApiService by lazy { ApiServiceImpl(clientOptionsWithUserAgent) }

    private val ai: AiService by lazy { AiServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): ReveniumMeteringClientAsync = async

    override fun withRawResponse(): ReveniumMeteringClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ReveniumMeteringClient =
        ReveniumMeteringClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun events(): EventService = events

    override fun apis(): ApiService = apis

    override fun ai(): AiService = ai

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ReveniumMeteringClient.WithRawResponse {

        private val events: EventService.WithRawResponse by lazy {
            EventServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val apis: ApiService.WithRawResponse by lazy {
            ApiServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val ai: AiService.WithRawResponse by lazy {
            AiServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ReveniumMeteringClient.WithRawResponse =
            ReveniumMeteringClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun events(): EventService.WithRawResponse = events

        override fun apis(): ApiService.WithRawResponse = apis

        override fun ai(): AiService.WithRawResponse = ai
    }
}
