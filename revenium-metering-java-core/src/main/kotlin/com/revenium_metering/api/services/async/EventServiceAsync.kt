// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.async

import com.revenium_metering.api.core.ClientOptions
import com.revenium_metering.api.core.RequestOptions
import com.revenium_metering.api.core.http.HttpResponseFor
import com.revenium_metering.api.models.events.EventCreateParams
import com.revenium_metering.api.models.events.MeteringResponseResource
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface EventServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventServiceAsync

    /** Meter an event */
    fun create(params: EventCreateParams): CompletableFuture<MeteringResponseResource> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: EventCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MeteringResponseResource>

    /** A view of [EventServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EventServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v2/events`, but is otherwise the same as
         * [EventServiceAsync.create].
         */
        fun create(
            params: EventCreateParams
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        fun create(
            params: EventCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>>
    }
}
