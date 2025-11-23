// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.client

import io.revenium.metering.core.ClientOptions
import io.revenium.metering.core.getPackageVersion
import io.revenium.metering.services.async.AiServiceAsync
import io.revenium.metering.services.async.AiServiceAsyncImpl
import io.revenium.metering.services.async.ApiServiceAsync
import io.revenium.metering.services.async.ApiServiceAsyncImpl
import io.revenium.metering.services.async.EventServiceAsync
import io.revenium.metering.services.async.EventServiceAsyncImpl
import java.util.function.Consumer

class ReveniumMeteringClientAsyncImpl(private val clientOptions: ClientOptions) :
    ReveniumMeteringClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: ReveniumMeteringClient by lazy { ReveniumMeteringClientImpl(clientOptions) }

    private val withRawResponse: ReveniumMeteringClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val events: EventServiceAsync by lazy {
        EventServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val apis: ApiServiceAsync by lazy { ApiServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val ai: AiServiceAsync by lazy { AiServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): ReveniumMeteringClient = sync

    override fun withRawResponse(): ReveniumMeteringClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): ReveniumMeteringClientAsync =
        ReveniumMeteringClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun events(): EventServiceAsync = events

    override fun apis(): ApiServiceAsync = apis

    override fun ai(): AiServiceAsync = ai

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ReveniumMeteringClientAsync.WithRawResponse {

        private val events: EventServiceAsync.WithRawResponse by lazy {
            EventServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val apis: ApiServiceAsync.WithRawResponse by lazy {
            ApiServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val ai: AiServiceAsync.WithRawResponse by lazy {
            AiServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ReveniumMeteringClientAsync.WithRawResponse =
            ReveniumMeteringClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun events(): EventServiceAsync.WithRawResponse = events

        override fun apis(): ApiServiceAsync.WithRawResponse = apis

        override fun ai(): AiServiceAsync.WithRawResponse = ai
    }
}
