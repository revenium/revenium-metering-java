// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.async

import com.revenium_metering.api.core.ClientOptions
import com.revenium_metering.api.core.RequestOptions
import com.revenium_metering.api.core.http.HttpResponseFor
import com.revenium_metering.api.models.apis.ApiMeterRequestParams
import com.revenium_metering.api.models.apis.ApiMeterResponseParams
import com.revenium_metering.api.models.events.MeteringResponseResource
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ApiServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiServiceAsync

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
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v2/apis/requests`, but is otherwise the same as
         * [ApiServiceAsync.meterRequest].
         */
        fun meterRequest(
            params: ApiMeterRequestParams
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>> =
            meterRequest(params, RequestOptions.none())

        /** @see [meterRequest] */
        fun meterRequest(
            params: ApiMeterRequestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>>

        /**
         * Returns a raw HTTP response for `post /v2/apis/responses`, but is otherwise the same as
         * [ApiServiceAsync.meterResponse].
         */
        fun meterResponse(
            params: ApiMeterResponseParams
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>> =
            meterResponse(params, RequestOptions.none())

        /** @see [meterResponse] */
        fun meterResponse(
            params: ApiMeterResponseParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>>
    }
}
