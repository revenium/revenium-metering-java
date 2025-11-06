// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.revenium_metering.api.core.ClientOptions
import com.revenium_metering.api.core.RequestOptions
import com.revenium_metering.api.core.http.HttpResponseFor
import com.revenium_metering.api.models.events.EventCreateParams
import com.revenium_metering.api.models.events.MeteringResponseResource
import java.util.function.Consumer

interface EventService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService

    /** Meter an event */
    fun create(params: EventCreateParams): MeteringResponseResource =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: EventCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MeteringResponseResource

    /** A view of [EventService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): EventService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v2/events`, but is otherwise the same as
         * [EventService.create].
         */
        @MustBeClosed
        fun create(params: EventCreateParams): HttpResponseFor<MeteringResponseResource> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: EventCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MeteringResponseResource>
    }
}
