// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services.async

import io.revenium.metering.core.ClientOptions
import io.revenium.metering.core.RequestOptions
import io.revenium.metering.core.http.HttpResponseFor
import io.revenium.metering.models.events.EventCreateParams
import io.revenium.metering.models.events.MeteringResponseResource
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Event Metering Operations */
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
