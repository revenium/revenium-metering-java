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

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createCompletion() {
        val aiService = client.ai()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        aiService.createCompletion(
            AiCreateCompletionParams.builder()
                .cacheCreationTokenCount(1300L)
                .cacheReadTokenCount(1300L)
                .completionStartTime("2025-03-02T15:04:05Z")
                .costType(AiCreateCompletionParams.CostType.AI)
                .inputTokenCount(50L)
                .isStreamed(false)
                .model("gpt4")
                .outputTokenCount(150L)
                .provider("OpenAI")
                .reasoningTokenCount(1300L)
                .requestDuration(1000L)
                .requestTime("2025-03-02T15:04:05Z")
                .responseTime("2025-03-02T15:04:06Z")
                .stopReason(AiCreateCompletionParams.StopReason.END)
                .totalTokenCount(200L)
                .transactionId("123e4567-e89b-12d3-a456-426614174000")
                .agent("Bishop")
                .aiProviderKeyName("Production Key (OpenAI)")
                .apiKey("apiKey")
                .errorReason("key not allowed to access model")
                .inputTokenCost(12.34)
                .mediationLatency(1000L)
                .modelSource("ANTHROPIC")
                .operationType(AiCreateCompletionParams.OperationType.CHAT)
                .organizationId("org-123")
                .outputTokenCost(12.34)
                .productId("Free Trial")
                .responseQualityScore(45.0)
                .subscriberCredential("asd-123")
                .subscriberEmail("user@example.com")
                .subscriptionId("subscr-456")
                .systemFingerprint("fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz")
                .taskId("task-123")
                .taskType("completion")
                .temperature(0.78)
                .timeToFirstToken(10200L)
                .totalCost(12.34)
                .traceId("123e4567-e89b-12d3-a456-426614174000")
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
