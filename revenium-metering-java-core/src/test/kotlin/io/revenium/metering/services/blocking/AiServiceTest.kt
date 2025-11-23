// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services.blocking

import io.revenium.metering.TestServerExtension
import io.revenium.metering.client.okhttp.ReveniumMeteringOkHttpClient
import io.revenium.metering.models.ai.AiCreateCompletionParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AiServiceTest {

    @Disabled("Prism tests are disabled")
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
                    .completionStartTime("2025-10-17T17:35:00Z")
                    .costType(AiCreateCompletionParams.CostType.AI)
                    .inputTokenCount(100L)
                    .isStreamed(false)
                    .model("gpt-4")
                    .outputTokenCount(150L)
                    .provider("OpenAI")
                    .requestDuration(2000L)
                    .requestTime("2025-10-17T17:35:00Z")
                    .responseTime("2025-10-17T17:35:02Z")
                    .stopReason(AiCreateCompletionParams.StopReason.END)
                    .totalTokenCount(250L)
                    .agent("marketing-agent")
                    .cacheCreationTokenCost(0.0037)
                    .cacheCreationTokenCount(1300L)
                    .cacheReadTokenCost(0.0001)
                    .cacheReadTokenCount(1300L)
                    .environment("production")
                    .errorReason("Rate limit exceeded for model gpt-4")
                    .inputTokenCost(0.0015)
                    .mediationLatency(45L)
                    .middlewareSource("revenium-openai-python-v1.2.3")
                    .modelSource("LITELLM")
                    .operationSubtype("web_search")
                    .operationType(AiCreateCompletionParams.OperationType.CHAT)
                    .organizationId("organizationId-123456")
                    .outputTokenCost(0.006)
                    .parentTransactionId("parent-txn-123e4567-e89b-12d3-a456-426614174000")
                    .productId("Free Trial")
                    .reasoningTokenCount(1300L)
                    .region("us-east-1")
                    .responseQualityScore(0.9)
                    .retryNumber(0)
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
                    .taskType("code-generation")
                    .temperature(0.7)
                    .timeToFirstToken(245L)
                    .totalCost(0.0213)
                    .traceId("123e4567-e89b-12d3-a456-426614174000")
                    .traceName("Customer Onboarding - Acme Corp")
                    .traceType("document_analysis")
                    .transactionId("txn-test-001")
                    .transactionName("Summarize Application")
                    .build()
            )

        meteringResponseResource.validate()
    }
}
