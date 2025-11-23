// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import io.revenium.metering.core.ClientOptions
import io.revenium.metering.core.RequestOptions
import io.revenium.metering.core.http.HttpResponseFor
import io.revenium.metering.models.ai.AiCreateCompletionParams
import io.revenium.metering.models.events.MeteringResponseResource
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

    /** Submit AI completion metadata for metering and billing purposes. */
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
