// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import io.revenium.metering.client.ReveniumMeteringClient
import io.revenium.metering.client.okhttp.ReveniumMeteringOkHttpClient
import io.revenium.metering.core.JsonValue
import io.revenium.metering.core.http.Headers
import io.revenium.metering.core.jsonMapper
import io.revenium.metering.errors.BadRequestException
import io.revenium.metering.errors.InternalServerException
import io.revenium.metering.errors.NotFoundException
import io.revenium.metering.errors.PermissionDeniedException
import io.revenium.metering.errors.RateLimitException
import io.revenium.metering.errors.ReveniumMeteringException
import io.revenium.metering.errors.UnauthorizedException
import io.revenium.metering.errors.UnexpectedStatusCodeException
import io.revenium.metering.errors.UnprocessableEntityException
import io.revenium.metering.models.ai.AiCreateCompletionParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun aiCreateCompletion400WithRawResponse() {
        val aiService = client.ai().withRawResponse()
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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun aiCreateCompletion401WithRawResponse() {
        val aiService = client.ai().withRawResponse()
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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun aiCreateCompletion403WithRawResponse() {
        val aiService = client.ai().withRawResponse()
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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun aiCreateCompletion404WithRawResponse() {
        val aiService = client.ai().withRawResponse()
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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun aiCreateCompletion422WithRawResponse() {
        val aiService = client.ai().withRawResponse()
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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun aiCreateCompletion429WithRawResponse() {
        val aiService = client.ai().withRawResponse()
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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun aiCreateCompletion500WithRawResponse() {
        val aiService = client.ai().withRawResponse()
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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun aiCreateCompletion999WithRawResponse() {
        val aiService = client.ai().withRawResponse()
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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

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
                        .systemFingerprint(
                            "fp_44z789a1c23def456gh7890ijkl1234mnopq567rstuv8910wxyz"
                        )
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
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
