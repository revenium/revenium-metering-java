// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services.async

import io.revenium.metering.core.ClientOptions
import io.revenium.metering.core.RequestOptions
import io.revenium.metering.core.http.HttpResponseFor
import io.revenium.metering.models.ai.AiCreateCompletionParams
import io.revenium.metering.models.events.MeteringResponseResource
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** AI Metering Operations */
interface AiServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AiServiceAsync

    /** Record the details of an LLM completion */
    fun createCompletion(
        params: AiCreateCompletionParams
    ): CompletableFuture<MeteringResponseResource> = createCompletion(params, RequestOptions.none())

    /** @see createCompletion */
    fun createCompletion(
        params: AiCreateCompletionParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MeteringResponseResource>

    /** A view of [AiServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AiServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v2/ai/completions`, but is otherwise the same as
         * [AiServiceAsync.createCompletion].
         */
        fun createCompletion(
            params: AiCreateCompletionParams
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>> =
            createCompletion(params, RequestOptions.none())

        /** @see createCompletion */
        fun createCompletion(
            params: AiCreateCompletionParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>>
    }
}
