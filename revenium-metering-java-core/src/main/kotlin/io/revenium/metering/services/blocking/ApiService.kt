// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import io.revenium.metering.core.ClientOptions
import io.revenium.metering.core.RequestOptions
import io.revenium.metering.core.http.HttpResponseFor
import io.revenium.metering.models.apis.ApiMeterRequestParams
import io.revenium.metering.models.apis.ApiMeterResponseParams
import io.revenium.metering.models.events.MeteringResponseResource
import java.util.function.Consumer

interface ApiService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiService

    /** Meter an API request */
    fun meterRequest(params: ApiMeterRequestParams): MeteringResponseResource =
        meterRequest(params, RequestOptions.none())

    /** @see meterRequest */
    fun meterRequest(
        params: ApiMeterRequestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MeteringResponseResource

    /** Meter an API response */
    fun meterResponse(params: ApiMeterResponseParams): MeteringResponseResource =
        meterResponse(params, RequestOptions.none())

    /** @see meterResponse */
    fun meterResponse(
        params: ApiMeterResponseParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MeteringResponseResource

    /** A view of [ApiService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ApiService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v2/apis/requests`, but is otherwise the same as
         * [ApiService.meterRequest].
         */
        @MustBeClosed
        fun meterRequest(params: ApiMeterRequestParams): HttpResponseFor<MeteringResponseResource> =
            meterRequest(params, RequestOptions.none())

        /** @see meterRequest */
        @MustBeClosed
        fun meterRequest(
            params: ApiMeterRequestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MeteringResponseResource>

        /**
         * Returns a raw HTTP response for `post /v2/apis/responses`, but is otherwise the same as
         * [ApiService.meterResponse].
         */
        @MustBeClosed
        fun meterResponse(
            params: ApiMeterResponseParams
        ): HttpResponseFor<MeteringResponseResource> = meterResponse(params, RequestOptions.none())

        /** @see meterResponse */
        @MustBeClosed
        fun meterResponse(
            params: ApiMeterResponseParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MeteringResponseResource>
    }
}
