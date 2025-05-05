// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.revenium_metering.api.client.ReveniumMeteringClient
import com.revenium_metering.api.client.okhttp.ReveniumMeteringOkHttpClient
import com.revenium_metering.api.core.JsonValue
import com.revenium_metering.api.core.http.Headers
import com.revenium_metering.api.core.jsonMapper
import com.revenium_metering.api.errors.BadRequestException
import com.revenium_metering.api.errors.InternalServerException
import com.revenium_metering.api.errors.NotFoundException
import com.revenium_metering.api.errors.PermissionDeniedException
import com.revenium_metering.api.errors.RateLimitException
import com.revenium_metering.api.errors.ReveniumMeteringException
import com.revenium_metering.api.errors.UnauthorizedException
import com.revenium_metering.api.errors.UnexpectedStatusCodeException
import com.revenium_metering.api.errors.UnprocessableEntityException
import com.revenium_metering.api.models.ai.AiCreateCompletionParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

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
    fun aiCreateCompletion400() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
                        .subscriberCredentialName("OpenAI Key (Production)")
                        .subscriberEmail("user@example.com")
                        .subscriptionId("subscr-456")
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
                        .taskId("task-123")
                        .taskType("completion")
                        .temperature(0.78)
                        .timeToFirstToken(10200L)
                        .totalCost(12.34)
                        .traceId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion401() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
                        .subscriberCredentialName("OpenAI Key (Production)")
                        .subscriberEmail("user@example.com")
                        .subscriptionId("subscr-456")
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
                        .taskId("task-123")
                        .taskType("completion")
                        .temperature(0.78)
                        .timeToFirstToken(10200L)
                        .totalCost(12.34)
                        .traceId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion403() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
                        .subscriberCredentialName("OpenAI Key (Production)")
                        .subscriberEmail("user@example.com")
                        .subscriptionId("subscr-456")
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
                        .taskId("task-123")
                        .taskType("completion")
                        .temperature(0.78)
                        .timeToFirstToken(10200L)
                        .totalCost(12.34)
                        .traceId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion404() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
                        .subscriberCredentialName("OpenAI Key (Production)")
                        .subscriberEmail("user@example.com")
                        .subscriptionId("subscr-456")
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
                        .taskId("task-123")
                        .taskType("completion")
                        .temperature(0.78)
                        .timeToFirstToken(10200L)
                        .totalCost(12.34)
                        .traceId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion422() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
                        .subscriberCredentialName("OpenAI Key (Production)")
                        .subscriberEmail("user@example.com")
                        .subscriptionId("subscr-456")
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
                        .taskId("task-123")
                        .taskType("completion")
                        .temperature(0.78)
                        .timeToFirstToken(10200L)
                        .totalCost(12.34)
                        .traceId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion429() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
                        .subscriberCredentialName("OpenAI Key (Production)")
                        .subscriberEmail("user@example.com")
                        .subscriptionId("subscr-456")
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
                        .taskId("task-123")
                        .taskType("completion")
                        .temperature(0.78)
                        .timeToFirstToken(10200L)
                        .totalCost(12.34)
                        .traceId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion500() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
                        .subscriberCredentialName("OpenAI Key (Production)")
                        .subscriberEmail("user@example.com")
                        .subscriptionId("subscr-456")
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
                        .taskId("task-123")
                        .taskType("completion")
                        .temperature(0.78)
                        .timeToFirstToken(10200L)
                        .totalCost(12.34)
                        .traceId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion999() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
                        .subscriberCredentialName("OpenAI Key (Production)")
                        .subscriberEmail("user@example.com")
                        .subscriptionId("subscr-456")
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
                        .taskId("task-123")
                        .taskType("completion")
                        .temperature(0.78)
                        .timeToFirstToken(10200L)
                        .totalCost(12.34)
                        .traceId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletionInvalidJsonBody() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<ReveniumMeteringException> {
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
                        .subscriberCredentialName("OpenAI Key (Production)")
                        .subscriberEmail("user@example.com")
                        .subscriptionId("subscr-456")
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
                        .taskId("task-123")
                        .taskType("completion")
                        .temperature(0.78)
                        .timeToFirstToken(10200L)
                        .totalCost(12.34)
                        .traceId("123e4567-e89b-12d3-a456-426614174000")
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
