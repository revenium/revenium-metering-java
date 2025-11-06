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

    /**
     * Submit a generic metering event with a flexible payload structure. Use this endpoint to meter
     * custom events that you wish to track in Revenium. The payload should contain any key-value
     * pairs representing metrics to track or rate for usage-based revenue calculation. The key
     * values sent here will be created as 'metering elements' if they do not already exist, and
     * rated according to pricing definitions for the relevant metering element on a product if they
     * do.
     */
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
