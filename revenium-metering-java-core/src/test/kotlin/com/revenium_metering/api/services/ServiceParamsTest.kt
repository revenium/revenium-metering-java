// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.revenium_metering.api.client.ReveniumMeteringClient
import com.revenium_metering.api.client.okhttp.ReveniumMeteringOkHttpClient
import com.revenium_metering.api.core.JsonValue
import com.revenium_metering.api.models.ai.AiCreateCompletionParams
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: ReveniumMeteringClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            ReveniumMeteringOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun createCompletion() {
        val aiService = client.ai()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

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
                .errorReason("Rate limit exceeded for model gpt-4")
                .inputTokenCost(0.0015)
                .mediationLatency(45L)
                .middlewareSource("revenium-openai-python-v1.2.3")
                .modelSource("LITELLM")
                .operationType(AiCreateCompletionParams.OperationType.CHAT)
                .organizationId("organizationId-123456")
                .outputTokenCost(0.006)
                .productId("Free Trial")
                .reasoningTokenCount(1300L)
                .responseQualityScore(85.5)
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
                .transactionId("txn-test-001")
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
