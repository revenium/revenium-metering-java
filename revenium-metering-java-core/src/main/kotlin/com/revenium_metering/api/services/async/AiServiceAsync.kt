// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.async

import com.revenium_metering.api.core.RequestOptions
import com.revenium_metering.api.core.http.HttpResponseFor
import com.revenium_metering.api.models.ai.AiCreateCompletionParams
import com.revenium_metering.api.models.events.MeteringResponseResource
import java.util.concurrent.CompletableFuture

interface AiServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Record the details of an LLM completion */
    fun createCompletion(
        params: AiCreateCompletionParams
    ): CompletableFuture<MeteringResponseResource> = createCompletion(params, RequestOptions.none())

    /** @see [createCompletion] */
    fun createCompletion(
        params: AiCreateCompletionParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<MeteringResponseResource>

    /** A view of [AiServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v2/ai/completions`, but is otherwise the same as
         * [AiServiceAsync.createCompletion].
         */
        fun createCompletion(
            params: AiCreateCompletionParams
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>> =
            createCompletion(params, RequestOptions.none())

        /** @see [createCompletion] */
        fun createCompletion(
            params: AiCreateCompletionParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<MeteringResponseResource>>
    }
}
