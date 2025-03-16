// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.revenium_metering.api.core.RequestOptions
import com.revenium_metering.api.core.http.HttpResponseFor
import com.revenium_metering.api.models.apis.ApiMeterRequestParams
import com.revenium_metering.api.models.apis.ApiMeterResponseParams
import com.revenium_metering.api.models.events.MeteringResponseResource
import java.util.concurrent.CompletableFuture

interface ApiServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Meter an API request */
    fun meterRequest(params: ApiMeterRequestParams): CompletableFuture<MeteringResponseResource> =
        meterRequest(params, RequestOptions.none())

    /** @see [meterRequest] */
    fun meterRequest(
        params: ApiMeterRequestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MeteringResponseResource>

    /** Meter an API response */
    fun meterResponse(params: ApiMeterResponseParams): CompletableFuture<MeteringResponseResource> =
        meterResponse(params, RequestOptions.none())

    /** @see [meterResponse] */
    fun meterResponse(
        params: ApiMeterResponseParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MeteringResponseResource>

    /** A view of [ApiServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v2/apis/requests`, but is otherwise the same as
         * [ApiServiceAsync.meterRequest].
         */
        @MustBeClosed
        fun meterRequest(
            params: ApiMeterRequestParams
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>> =
            meterRequest(params, RequestOptions.none())

        /** @see [meterRequest] */
        @MustBeClosed
        fun meterRequest(
            params: ApiMeterRequestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>>

        /**
         * Returns a raw HTTP response for `post /v2/apis/responses`, but is otherwise the same as
         * [ApiServiceAsync.meterResponse].
         */
        @MustBeClosed
        fun meterResponse(
            params: ApiMeterResponseParams
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>> =
            meterResponse(params, RequestOptions.none())

        /** @see [meterResponse] */
        @MustBeClosed
        fun meterResponse(
            params: ApiMeterResponseParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>>
    }
}
