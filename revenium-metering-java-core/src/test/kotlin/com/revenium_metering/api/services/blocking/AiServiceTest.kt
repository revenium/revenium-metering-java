// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.blocking

import com.revenium_metering.api.TestServerExtension
import com.revenium_metering.api.client.okhttp.ReveniumMeteringOkHttpClient
import com.revenium_metering.api.models.ai.AiCreateCompletionParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AiServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createCompletion() {
        val client =
            ReveniumMeteringOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val aiService = client.ai()

        val meteringResponseResource =
            aiService.createCompletion(
                AiCreateCompletionParams.builder()
                    .completionStartTime("2025-03-02T15:04:05Z")
                    .costType(AiCreateCompletionParams.CostType.AI)
                    .inputTokenCount(50L)
                    .isStreamed(false)
                    .model("gpt4")
                    .outputTokenCount(150L)
                    .provider("OpenAI")
                    .requestDuration(1000L)
                    .requestTime("2025-03-02T15:04:05Z")
                    .responseTime("2025-03-02T15:04:06Z")
                    .stopReason(AiCreateCompletionParams.StopReason.END)
                    .totalTokenCount(200L)
                    .transactionId("123e4567-e89b-12d3-a456-426614174000")
                    .agent("marketing-agent")
                    .cacheCreationTokenCost(12.34)
                    .cacheCreationTokenCount(1300L)
                    .cacheReadTokenCost(12.34)
                    .cacheReadTokenCount(1300L)
                    .errorReason("key not allowed to access model")
                    .inputTokenCost(12.34)
                    .mediationLatency(1000L)
                    .middlewareSource("openai-python-sdk")
                    .modelSource("ANTHROPIC")
                    .operationType(AiCreateCompletionParams.OperationType.CHAT)
                    .organizationId("organizationId-123456")
                    .outputTokenCost(12.34)
                    .productId("Free Trial")
                    .reasoningTokenCount(1300L)
                    .responseQualityScore(45.0)
                    .subscriber(
                        AiCreateCompletionParams.Subscriber.builder()
                            .id("subscriberId-123456")
                            .credential(
                                AiCreateCompletionParams.Subscriber.Credential.builder()
                                    .name("OpenAI Key (Production)")
                                    .value("pk-1234567")
                                    .build()
                            )
                            .email("user@example.com")
                            .build()
                    )
                    .subscriptionId("subscriptionId-456789")
                    .systemFingerprint("fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz")
                    .taskType("image-generation")
                    .temperature(0.78)
                    .timeToFirstToken(10200L)
                    .totalCost(12.34)
                    .traceId("123e4567-e89b-12d3-a456-426614174000")
                    .build()
            )

        meteringResponseResource.validate()
    }
}
