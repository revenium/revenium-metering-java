// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.revenium_metering.api.core.RequestOptions
import com.revenium_metering.api.core.http.HttpResponseFor
import com.revenium_metering.api.models.events.EventCreateParams
import com.revenium_metering.api.models.events.MeteringResponseResource
import java.util.concurrent.CompletableFuture

interface EventServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

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
         * Returns a raw HTTP response for `post /v2/events`, but is otherwise the same as
         * [EventServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            params: EventCreateParams
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: EventCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>>
    }
}
