// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.client

import com.revenium_metering.api.core.ClientOptions
import com.revenium_metering.api.core.getPackageVersion
import com.revenium_metering.api.services.async.AiServiceAsync
import com.revenium_metering.api.services.async.AiServiceAsyncImpl
import com.revenium_metering.api.services.async.ApiServiceAsync
import com.revenium_metering.api.services.async.ApiServiceAsyncImpl
import com.revenium_metering.api.services.async.EventServiceAsync
import com.revenium_metering.api.services.async.EventServiceAsyncImpl

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

    override fun events(): EventServiceAsync = events

    override fun apis(): ApiServiceAsync = apis

    override fun ai(): AiServiceAsync = ai

    override fun close() = clientOptions.httpClient.close()

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

        override fun events(): EventServiceAsync.WithRawResponse = events

        override fun apis(): ApiServiceAsync.WithRawResponse = apis

        override fun ai(): AiServiceAsync.WithRawResponse = ai
    }
}
