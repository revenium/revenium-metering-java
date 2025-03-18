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
import com.revenium_metering.api.errors.ReveniumMeteringError
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

@WireMockTest
internal class ErrorHandlingTest {

    companion object {

        private val ERROR: ReveniumMeteringError =
            ReveniumMeteringError.builder()
                .putAdditionalProperty("errorProperty", JsonValue.from("42"))
                .build()

        private val ERROR_JSON: ByteArray = jsonMapper().writeValueAsBytes(ERROR)

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
                .willReturn(status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<BadRequestException> {
                aiService.createCompletion(
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
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion401() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnauthorizedException> {
                aiService.createCompletion(
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
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion403() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<PermissionDeniedException> {
                aiService.createCompletion(
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
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion404() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<NotFoundException> {
                aiService.createCompletion(
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
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion422() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                aiService.createCompletion(
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
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion429() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<RateLimitException> {
                aiService.createCompletion(
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
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion500() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<InternalServerException> {
                aiService.createCompletion(
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
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun aiCreateCompletion999() {
        val aiService = client.ai()
        stubFor(
            post(anyUrl())
                .willReturn(status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON))
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                aiService.createCompletion(
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
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.error()).isEqualTo(ERROR)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
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
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
