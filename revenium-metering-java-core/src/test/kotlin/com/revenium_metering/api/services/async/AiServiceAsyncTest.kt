// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.async

import com.revenium_metering.api.TestServerExtension
import com.revenium_metering.api.client.okhttp.ReveniumMeteringOkHttpClientAsync
import com.revenium_metering.api.models.ai.AiCreateCompletionParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AiServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createCompletion() {
        val client =
            ReveniumMeteringOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val aiServiceAsync = client.ai()

        val meteringResponseResourceFuture =
            aiServiceAsync.createCompletion(
                AiCreateCompletionParams.builder()
                    .audioTokenCount(150L)
                    .cachedTokenCount(1300L)
                    .completionStartTime("2025-03-02T15:04:05Z")
                    .completionTokenCount(150L)
                    .costType(AiCreateCompletionParams.CostType.AI)
                    .inputTokenCost(12.34)
                    .model("gpt4")
                    .outputTokenCost(12.34)
                    .promptTokenCount(50L)
                    .provider("OpenAI")
                    .reasoningTokenCount(1300L)
                    .requestDuration(1000L)
                    .requestTime("2025-03-02T15:04:05Z")
                    .responseTime("2025-03-02T15:04:06Z")
                    .stopReason(AiCreateCompletionParams.StopReason.END)
                    .totalCost(12.34)
                    .totalTokenCount(200L)
                    .transactionId("123e4567-e89b-12d3-a456-426614174000")
                    .agent("Bishop")
                    .aiProviderKeyName("Production Key (OpenAI)")
                    .apiKey("apiKey")
                    .organizationId("org-123")
                    .productId("Free Trial")
                    .sourceId("source-123")
                    .subscriberIdentity("ash")
                    .subscriptionId("subscr-456")
                    .taskId("task-123")
                    .taskType("completion")
                    .traceId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )

        val meteringResponseResource = meteringResponseResourceFuture.get()
        meteringResponseResource.validate()
    }
}
