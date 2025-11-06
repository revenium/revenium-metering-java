// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.revenium_metering.api.core.ClientOptions
import com.revenium_metering.api.core.RequestOptions
import com.revenium_metering.api.core.http.HttpResponseFor
import com.revenium_metering.api.models.ai.AiCreateCompletionParams
import com.revenium_metering.api.models.events.MeteringResponseResource
import java.util.function.Consumer

interface AiService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AiService

    /**
     * Submit AI completion metadata for metering and billing purposes. This endpoint tracks token
     * usage, costs, and performance metrics for AI model completions. **Base URL:** Use the
     * metering endpoint `/meter/v2/ai/completions` (not `/profitstream/v2/ai/completions`)
     */
    fun createCompletion(params: AiCreateCompletionParams): MeteringResponseResource =
        createCompletion(params, RequestOptions.none())

    /** @see createCompletion */
    fun createCompletion(
        params: AiCreateCompletionParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MeteringResponseResource

    /** A view of [AiService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AiService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v2/ai/completions`, but is otherwise the same as
         * [AiService.createCompletion].
         */
        @MustBeClosed
        fun createCompletion(
            params: AiCreateCompletionParams
        ): HttpResponseFor<MeteringResponseResource> =
            createCompletion(params, RequestOptions.none())

        /** @see createCompletion */
        @MustBeClosed
        fun createCompletion(
            params: AiCreateCompletionParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MeteringResponseResource>
    }
}
