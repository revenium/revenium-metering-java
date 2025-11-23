// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services.async

import io.revenium.metering.core.ClientOptions
import io.revenium.metering.core.RequestOptions
import io.revenium.metering.core.http.HttpResponseFor
import io.revenium.metering.models.events.EventCreateParams
import io.revenium.metering.models.events.MeteringResponseResource
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

    /**
     * Submit a generic metering event with a flexible payload structure. Use this endpoint to meter
     * custom events that you wish to track in Revenium. The payload should contain any key-value
     * pairs representing metrics to track or rate for usage-based revenue calculation. The key
     * values sent here will be created as 'metering elements' if they do not already exist, and
     * rated according to pricing definitions for the relevant metering element on a product if they
     * do.
     */
    fun create(params: EventCreateParams): CompletableFuture<MeteringResponseResource> =
        create(params, RequestOptions.none())

    /** @see create */
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

        /** @see create */
        fun create(
            params: EventCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>>
    }
}
