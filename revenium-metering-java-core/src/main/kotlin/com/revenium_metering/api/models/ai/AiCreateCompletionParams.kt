// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.models.ai

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.revenium_metering.api.core.Enum
import com.revenium_metering.api.core.ExcludeMissing
import com.revenium_metering.api.core.JsonField
import com.revenium_metering.api.core.JsonMissing
import com.revenium_metering.api.core.JsonValue
import com.revenium_metering.api.core.Params
import com.revenium_metering.api.core.checkRequired
import com.revenium_metering.api.core.http.Headers
import com.revenium_metering.api.core.http.QueryParams
import com.revenium_metering.api.errors.ReveniumMeteringInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Submit AI completion metadata for metering and billing purposes. This endpoint tracks token
 * usage, costs, and performance metrics for AI model completions. **Base URL:** Use the metering
 * endpoint `/meter/v2/ai/completions` (not `/profitstream/v2/ai/completions`)
 */
class AiCreateCompletionParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The timestamp when the AI completion started generating output, in ISO 8601 format with UTC
     * timezone. For streaming requests, this is when the first token was received. For
     * non-streaming requests, this is typically the same as or very close to responseTime. Used to
     * calculate time-to-first-token latency for streaming completions.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun completionStartTime(): String = body.completionStartTime()

    /**
     * The type of cost being tracked. Currently always 'AI' for AI completion costs. This field is
     * used internally by Revenium to categorize different types of metered usage. You typically do
     * not need to set this field as it defaults to 'AI'.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun costType(): CostType = body.costType()

    /**
     * The count of consumed input tokens
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun inputTokenCount(): Long = body.inputTokenCount()

    /**
     * Indicates whether this completion used streaming (true) or non-streaming/batch mode (false).
     * Streaming completions receive tokens incrementally as they're generated, while non-streaming
     * completions wait for the complete response. This affects how timeToFirstToken and
     * responseTime are interpreted.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isStreamed(): Boolean = body.isStreamed()

    /**
     * The AI model identifier used for this completion. Should match the exact model name from your
     * AI provider (e.g., 'gpt-4', 'claude-3-opus-20240229', 'gemini-pro'). This is used for cost
     * calculation, performance analytics, and model comparison reporting in Revenium. Valid model
     * names in Revenium for proper cost estimate can be verified using the sources/ai/models
     * endpoint.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = body.model()

    /**
     * The count of consumed output tokens
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputTokenCount(): Long = body.outputTokenCount()

    /**
     * The underlying AI provider/vendor whose model is actually processing the request. This
     * identifies which company's AI model is being used, regardless of how you're accessing it
     * (direct API, proxy, or gateway).
     *
     * Common values: 'OpenAI' (for GPT models), 'Anthropic' (for Claude models), 'Google' (for
     * Gemini models), 'Cohere', 'Mistral', 'Meta' (for Llama models), 'Amazon Bedrock', 'Azure'.
     *
     * Custom values are accepted but may affect analytics categorization. Revenium looks up model
     * pricing primarily by model name (e.g., 'gpt-4', 'claude-3-opus'), so using non-standard
     * provider names will not break cost calculation. However, using standard provider names
     * ensures proper categorization in analytics and reporting.
     *
     * If using an aggregation service like LiteLLM or OpenRouter, this should still be the actual
     * provider (e.g., 'Anthropic' not 'LiteLLM'). If using Revenium middleware, this is typically
     * auto-populated from the AI provider's API response. Supported provider models can be verified
     * using the sources/ai/models endpoint which returns both providers and model names.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun provider(): String = body.provider()

    /**
     * The total duration of the AI completion request in milliseconds, from request start to
     * completion. Calculated as (responseTime - requestTime). This includes network latency, AI
     * processing time, and any mediation/gateway overhead. Used for performance analytics and SLA
     * monitoring.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun requestDuration(): Long = body.requestDuration()

    /**
     * The timestamp when your application sent the request to the AI provider, in ISO 8601 format
     * with UTC timezone (e.g., '2025-03-02T15:04:05Z'). This is used to calculate request duration
     * and analyze usage patterns over time. Set this to the time immediately before calling the AI
     * provider's API.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun requestTime(): String = body.requestTime()

    /**
     * The timestamp when the AI completion finished, in ISO 8601 format with UTC timezone. For
     * streaming requests, this is when the last token was received and the stream closed. For
     * non-streaming requests, this is when the complete response was received. Used to calculate
     * total request duration.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun responseTime(): String = body.responseTime()

    /**
     * The reason for stopping the completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun stopReason(): StopReason = body.stopReason()

    /**
     * The total number of tokens
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun totalTokenCount(): Long = body.totalTokenCount()

    /**
     * The AI agent that is making the request
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun agent(): Optional<String> = body.agent()

    /**
     * The cost in USD for cache creation tokens in this completion. Typically leave null to let
     * Revenium automatically calculate costs based on the model and provider's caching pricing.
     * Only provide a value if you have custom pricing agreements or want to override Revenium's
     * cost calculation. If provided, this will override Revenium's automatic calculation.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun cacheCreationTokenCost(): Optional<Double> = body.cacheCreationTokenCost()

    /**
     * The number of tokens used to create new cache entries (prompt caching). When you send a long
     * prompt for the first time, the AI provider may cache it for faster subsequent requests. Cache
     * creation tokens are typically billed at a higher rate than regular input tokens. Only include
     * if your provider supports prompt caching (e.g., Anthropic Claude, OpenAI with cache-enabled
     * models). Revenium's middleware will always populate this field automatically. Leave null
     * otherwise.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun cacheCreationTokenCount(): Optional<Long> = body.cacheCreationTokenCount()

    /**
     * The cost in USD for cache read tokens in this completion. Typically leave null to let
     * Revenium automatically calculate costs based on the model and provider's caching pricing.
     * Only provide a value if you have custom pricing agreements or want to override Revenium's
     * cost calculation. If provided, this will override Revenium's automatic calculation.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun cacheReadTokenCost(): Optional<Double> = body.cacheReadTokenCost()

    /**
     * The number of tokens read from cache (prompt caching). When reusing a previously cached
     * prompt, these tokens are read from cache instead of being processed as new input tokens.
     * Cache read tokens are typically billed at a lower rate than regular input tokens. Only
     * include if your provider supports prompt caching and reports cache hits. Revenium's
     * middleware will always populate this field automatically. Leave null otherwise.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun cacheReadTokenCount(): Optional<Long> = body.cacheReadTokenCount()

    /**
     * Error message or reason if the AI completion failed. Include this field when the AI provider
     * returns an error (e.g., rate limit exceeded, invalid API key, model not found, content policy
     * violation). Used for error rate analytics and debugging. Leave null for successful
     * completions.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun errorReason(): Optional<String> = body.errorReason()

    /**
     * The cost in USD for input tokens in this completion. Typically leave null to let Revenium
     * automatically calculate costs based on the model and provider's current pricing. Only provide
     * a value if you have custom pricing agreements or want to override Revenium's cost
     * calculation. Note: Manual cost override may not be available on all Revenium plans.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun inputTokenCost(): Optional<Double> = body.inputTokenCost()

    /**
     * The latency in milliseconds introduced by intermediate systems between your application and
     * the AI provider, such as API gateways, proxies, or AI mediation layers. This helps identify
     * performance bottlenecks outside of the AI provider's processing time. Leave null if not using
     * intermediate systems or if latency is not tracked separately.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun mediationLatency(): Optional<Long> = body.mediationLatency()

    /**
     * Identifier of the Revenium middleware package or SDK that captured and submitted this AI
     * completion metadata. This field is AUTOMATICALLY SET by Revenium's middleware packages (e.g.,
     * 'revenium-openai-python', 'revenium-anthropic-node'). You typically should NOT manually set
     * this field. It is used for analytics to track which integration methods are being used and
     * for debugging middleware-specific issues.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun middlewareSource(): Optional<String> = body.middlewareSource()

    /**
     * The routing or aggregation layer used to access the AI model. This identifies whether you're
     * calling the AI provider directly or through an intermediary service.
     *
     * Common values: 'DIRECT', 'LITELLM', 'OPENROUTER', 'PORTKEY', 'AZURE_OPENAI', or provider
     * names ('OPENAI', 'ANTHROPIC', 'GOOGLE', etc.) when calling directly.
     *
     * Custom values are accepted for specialized routing layers or gateways. This field is used for
     * integration tracking and analytics.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun modelSource(): Optional<String> = body.modelSource()

    /**
     * The type of operation performed
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun operationType(): Optional<OperationType> = body.operationType()

    /**
     * Populate the ID of the subscriber’s organization from your system to allow Revenium to track
     * usage & costs by company. i.e. AcmeCorp. If several subscriberIds have the same
     * organizationId, Revenium’s reporting will show usage for the entire organization broken down
     * by subscriberId.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun organizationId(): Optional<String> = body.organizationId()

    /**
     * The cost in USD for output tokens in this completion. Typically leave null to let Revenium
     * automatically calculate costs based on the model and provider's current pricing. Only provide
     * a value if you have custom pricing agreements or want to override Revenium's cost
     * calculation. If provided, this will override Revenium's automatic calculation. Note: Manual
     * cost override may not be available on all Revenium plans.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun outputTokenCost(): Optional<Double> = body.outputTokenCost()

    /**
     * Identifier of the product from your own system that you wish to use to correlate usage
     * between Revenium & your application.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun productId(): Optional<String> = body.productId()

    /**
     * The number of reasoning tokens used in the completion. Reasoning tokens are extended thinking
     * tokens used by AI models for complex problem-solving. These are sometimes billed separately
     * from regular input/output tokens. Only include this field if your AI provider reports
     * reasoning tokens Revenium's middleware will always populate this field if reasoning tokens
     * are reported by the AI provider. Leave null for models without reasoning capabilities.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun reasoningTokenCount(): Optional<Long> = body.reasoningTokenCount()

    /**
     * Optional quality score for the AI response, typically on a 0-100 scale. Set by your
     * application's evaluation logic (e.g., RAGAS, human feedback, custom scoring). Used in
     * Revenium analytics to correlate quality with cost, model choice, and other metrics. Leave
     * null if not tracking quality scores.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun responseQualityScore(): Optional<Double> = body.responseQualityScore()

    /**
     * Metadata about the subscriber/end-user making this AI request. Include this to track usage by
     * individual users within an organization. Contains user identifiers and associated credential
     * information. Leave null if not tracking individual user-level usage.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun subscriber(): Optional<Subscriber> = body.subscriber()

    /**
     * Unique identifier of the subscription from your own system that you wish to use to correlate
     * usage between Revenium & your application.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun subscriptionId(): Optional<String> = body.subscriptionId()

    /**
     * A unique identifier provided by the AI provider that represents the statistical signature of
     * the language model that generated this completion. This fingerprint can be used for model
     * attribution, debugging, and monitoring model behavior across requests. Automatically provided
     * by some AI providers (e.g., OpenAI) in their API responses. Leave null if your provider does
     * not supply this value.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun systemFingerprint(): Optional<String> = body.systemFingerprint()

    /**
     * Optional category to group related AI tasks for cost and performance analysis. Use consistent
     * values to compare metrics across different models or vendors performing the same type of
     * work. Examples: 'chat', 'summarization', 'code-generation', 'translation',
     * 'image-generation', 'embeddings', 'classification', 'sentiment-analysis'. This is freeform
     * text - choose values that match your use cases.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun taskType(): Optional<String> = body.taskType()

    /**
     * The temperature parameter used for this completion, controlling randomness in the AI's
     * output. Typically ranges from 0.0 (deterministic) to 2.0 (very random). Track this to
     * correlate temperature settings with response quality, cost, or other metrics. Useful for A/B
     * testing different temperature values.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> = body.temperature()

    /**
     * The latency in milliseconds from request start to first token received. Calculated as
     * (completionStartTime - requestTime). This metric is particularly important for streaming
     * completions to measure perceived responsiveness. For non-streaming completions, this may be
     * null or equal to requestDuration.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun timeToFirstToken(): Optional<Long> = body.timeToFirstToken()

    /**
     * The total cost in USD for this completion (sum of all token costs). Typically leave null to
     * let Revenium automatically calculate the total based on token counts and current pricing.
     * Only provide a value if you have custom pricing agreements or want to override Revenium's
     * cost calculation. If provided, this will override Revenium's automatic calculation.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun totalCost(): Optional<Double> = body.totalCost()

    /**
     * Optional trace identifier to group multiple related AI completion calls that belong to the
     * same overall user request or workflow. For example, if a single user query triggers multiple
     * LLM calls (e.g., retrieval + generation), use the same traceId for all calls to analyze them
     * together in Revenium's analytics. Leave null for standalone completions.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun traceId(): Optional<String> = body.traceId()

    /**
     * Unique identifier for this specific AI completion transaction. Used for deduplication,
     * correlation with request/response pairs, and transaction lookup in Revenium analytics. If not
     * provided, a UUID will be auto-generated. For best practices, generate a UUID in your
     * application before making the AI call and use the same ID when submitting to Revenium.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun transactionId(): Optional<String> = body.transactionId()

    /**
     * Returns the raw JSON value of [completionStartTime].
     *
     * Unlike [completionStartTime], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _completionStartTime(): JsonField<String> = body._completionStartTime()

    /**
     * Returns the raw JSON value of [costType].
     *
     * Unlike [costType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _costType(): JsonField<CostType> = body._costType()

    /**
     * Returns the raw JSON value of [inputTokenCount].
     *
     * Unlike [inputTokenCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _inputTokenCount(): JsonField<Long> = body._inputTokenCount()

    /**
     * Returns the raw JSON value of [isStreamed].
     *
     * Unlike [isStreamed], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _isStreamed(): JsonField<Boolean> = body._isStreamed()

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _model(): JsonField<String> = body._model()

    /**
     * Returns the raw JSON value of [outputTokenCount].
     *
     * Unlike [outputTokenCount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _outputTokenCount(): JsonField<Long> = body._outputTokenCount()

    /**
     * Returns the raw JSON value of [provider].
     *
     * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _provider(): JsonField<String> = body._provider()

    /**
     * Returns the raw JSON value of [requestDuration].
     *
     * Unlike [requestDuration], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _requestDuration(): JsonField<Long> = body._requestDuration()

    /**
     * Returns the raw JSON value of [requestTime].
     *
     * Unlike [requestTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _requestTime(): JsonField<String> = body._requestTime()

    /**
     * Returns the raw JSON value of [responseTime].
     *
     * Unlike [responseTime], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _responseTime(): JsonField<String> = body._responseTime()

    /**
     * Returns the raw JSON value of [stopReason].
     *
     * Unlike [stopReason], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _stopReason(): JsonField<StopReason> = body._stopReason()

    /**
     * Returns the raw JSON value of [totalTokenCount].
     *
     * Unlike [totalTokenCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _totalTokenCount(): JsonField<Long> = body._totalTokenCount()

    /**
     * Returns the raw JSON value of [agent].
     *
     * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _agent(): JsonField<String> = body._agent()

    /**
     * Returns the raw JSON value of [cacheCreationTokenCost].
     *
     * Unlike [cacheCreationTokenCost], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _cacheCreationTokenCost(): JsonField<Double> = body._cacheCreationTokenCost()

    /**
     * Returns the raw JSON value of [cacheCreationTokenCount].
     *
     * Unlike [cacheCreationTokenCount], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _cacheCreationTokenCount(): JsonField<Long> = body._cacheCreationTokenCount()

    /**
     * Returns the raw JSON value of [cacheReadTokenCost].
     *
     * Unlike [cacheReadTokenCost], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _cacheReadTokenCost(): JsonField<Double> = body._cacheReadTokenCost()

    /**
     * Returns the raw JSON value of [cacheReadTokenCount].
     *
     * Unlike [cacheReadTokenCount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _cacheReadTokenCount(): JsonField<Long> = body._cacheReadTokenCount()

    /**
     * Returns the raw JSON value of [errorReason].
     *
     * Unlike [errorReason], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _errorReason(): JsonField<String> = body._errorReason()

    /**
     * Returns the raw JSON value of [inputTokenCost].
     *
     * Unlike [inputTokenCost], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _inputTokenCost(): JsonField<Double> = body._inputTokenCost()

    /**
     * Returns the raw JSON value of [mediationLatency].
     *
     * Unlike [mediationLatency], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _mediationLatency(): JsonField<Long> = body._mediationLatency()

    /**
     * Returns the raw JSON value of [middlewareSource].
     *
     * Unlike [middlewareSource], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _middlewareSource(): JsonField<String> = body._middlewareSource()

    /**
     * Returns the raw JSON value of [modelSource].
     *
     * Unlike [modelSource], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _modelSource(): JsonField<String> = body._modelSource()

    /**
     * Returns the raw JSON value of [operationType].
     *
     * Unlike [operationType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _operationType(): JsonField<OperationType> = body._operationType()

    /**
     * Returns the raw JSON value of [organizationId].
     *
     * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _organizationId(): JsonField<String> = body._organizationId()

    /**
     * Returns the raw JSON value of [outputTokenCost].
     *
     * Unlike [outputTokenCost], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _outputTokenCost(): JsonField<Double> = body._outputTokenCost()

    /**
     * Returns the raw JSON value of [productId].
     *
     * Unlike [productId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _productId(): JsonField<String> = body._productId()

    /**
     * Returns the raw JSON value of [reasoningTokenCount].
     *
     * Unlike [reasoningTokenCount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _reasoningTokenCount(): JsonField<Long> = body._reasoningTokenCount()

    /**
     * Returns the raw JSON value of [responseQualityScore].
     *
     * Unlike [responseQualityScore], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _responseQualityScore(): JsonField<Double> = body._responseQualityScore()

    /**
     * Returns the raw JSON value of [subscriber].
     *
     * Unlike [subscriber], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _subscriber(): JsonField<Subscriber> = body._subscriber()

    /**
     * Returns the raw JSON value of [subscriptionId].
     *
     * Unlike [subscriptionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _subscriptionId(): JsonField<String> = body._subscriptionId()

    /**
     * Returns the raw JSON value of [systemFingerprint].
     *
     * Unlike [systemFingerprint], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _systemFingerprint(): JsonField<String> = body._systemFingerprint()

    /**
     * Returns the raw JSON value of [taskType].
     *
     * Unlike [taskType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _taskType(): JsonField<String> = body._taskType()

    /**
     * Returns the raw JSON value of [temperature].
     *
     * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _temperature(): JsonField<Double> = body._temperature()

    /**
     * Returns the raw JSON value of [timeToFirstToken].
     *
     * Unlike [timeToFirstToken], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _timeToFirstToken(): JsonField<Long> = body._timeToFirstToken()

    /**
     * Returns the raw JSON value of [totalCost].
     *
     * Unlike [totalCost], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _totalCost(): JsonField<Double> = body._totalCost()

    /**
     * Returns the raw JSON value of [traceId].
     *
     * Unlike [traceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _traceId(): JsonField<String> = body._traceId()

    /**
     * Returns the raw JSON value of [transactionId].
     *
     * Unlike [transactionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _transactionId(): JsonField<String> = body._transactionId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AiCreateCompletionParams].
         *
         * The following fields are required:
         * ```java
         * .completionStartTime()
         * .costType()
         * .inputTokenCount()
         * .isStreamed()
         * .model()
         * .outputTokenCount()
         * .provider()
         * .requestDuration()
         * .requestTime()
         * .responseTime()
         * .stopReason()
         * .totalTokenCount()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AiCreateCompletionParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(aiCreateCompletionParams: AiCreateCompletionParams) = apply {
            body = aiCreateCompletionParams.body.toBuilder()
            additionalHeaders = aiCreateCompletionParams.additionalHeaders.toBuilder()
            additionalQueryParams = aiCreateCompletionParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [completionStartTime]
         * - [costType]
         * - [inputTokenCount]
         * - [isStreamed]
         * - [model]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The timestamp when the AI completion started generating output, in ISO 8601 format with
         * UTC timezone. For streaming requests, this is when the first token was received. For
         * non-streaming requests, this is typically the same as or very close to responseTime. Used
         * to calculate time-to-first-token latency for streaming completions.
         */
        fun completionStartTime(completionStartTime: String) = apply {
            body.completionStartTime(completionStartTime)
        }

        /**
         * Sets [Builder.completionStartTime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completionStartTime] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun completionStartTime(completionStartTime: JsonField<String>) = apply {
            body.completionStartTime(completionStartTime)
        }

        /**
         * The type of cost being tracked. Currently always 'AI' for AI completion costs. This field
         * is used internally by Revenium to categorize different types of metered usage. You
         * typically do not need to set this field as it defaults to 'AI'.
         */
        fun costType(costType: CostType) = apply { body.costType(costType) }

        /**
         * Sets [Builder.costType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.costType] with a well-typed [CostType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun costType(costType: JsonField<CostType>) = apply { body.costType(costType) }

        /** The count of consumed input tokens */
        fun inputTokenCount(inputTokenCount: Long) = apply { body.inputTokenCount(inputTokenCount) }

        /**
         * Sets [Builder.inputTokenCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputTokenCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inputTokenCount(inputTokenCount: JsonField<Long>) = apply {
            body.inputTokenCount(inputTokenCount)
        }

        /**
         * Indicates whether this completion used streaming (true) or non-streaming/batch mode
         * (false). Streaming completions receive tokens incrementally as they're generated, while
         * non-streaming completions wait for the complete response. This affects how
         * timeToFirstToken and responseTime are interpreted.
         */
        fun isStreamed(isStreamed: Boolean) = apply { body.isStreamed(isStreamed) }

        /**
         * Sets [Builder.isStreamed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isStreamed] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isStreamed(isStreamed: JsonField<Boolean>) = apply { body.isStreamed(isStreamed) }

        /**
         * The AI model identifier used for this completion. Should match the exact model name from
         * your AI provider (e.g., 'gpt-4', 'claude-3-opus-20240229', 'gemini-pro'). This is used
         * for cost calculation, performance analytics, and model comparison reporting in Revenium.
         * Valid model names in Revenium for proper cost estimate can be verified using the
         * sources/ai/models endpoint.
         */
        fun model(model: String) = apply { body.model(model) }

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { body.model(model) }

        /** The count of consumed output tokens */
        fun outputTokenCount(outputTokenCount: Long) = apply {
            body.outputTokenCount(outputTokenCount)
        }

        /**
         * Sets [Builder.outputTokenCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputTokenCount] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun outputTokenCount(outputTokenCount: JsonField<Long>) = apply {
            body.outputTokenCount(outputTokenCount)
        }

        /**
         * The underlying AI provider/vendor whose model is actually processing the request. This
         * identifies which company's AI model is being used, regardless of how you're accessing it
         * (direct API, proxy, or gateway).
         *
         * Common values: 'OpenAI' (for GPT models), 'Anthropic' (for Claude models), 'Google' (for
         * Gemini models), 'Cohere', 'Mistral', 'Meta' (for Llama models), 'Amazon Bedrock',
         * 'Azure'.
         *
         * Custom values are accepted but may affect analytics categorization. Revenium looks up
         * model pricing primarily by model name (e.g., 'gpt-4', 'claude-3-opus'), so using
         * non-standard provider names will not break cost calculation. However, using standard
         * provider names ensures proper categorization in analytics and reporting.
         *
         * If using an aggregation service like LiteLLM or OpenRouter, this should still be the
         * actual provider (e.g., 'Anthropic' not 'LiteLLM'). If using Revenium middleware, this is
         * typically auto-populated from the AI provider's API response. Supported provider models
         * can be verified using the sources/ai/models endpoint which returns both providers and
         * model names.
         */
        fun provider(provider: String) = apply { body.provider(provider) }

        /**
         * Sets [Builder.provider] to an arbitrary JSON value.
         *
         * You should usually call [Builder.provider] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun provider(provider: JsonField<String>) = apply { body.provider(provider) }

        /**
         * The total duration of the AI completion request in milliseconds, from request start to
         * completion. Calculated as (responseTime - requestTime). This includes network latency, AI
         * processing time, and any mediation/gateway overhead. Used for performance analytics and
         * SLA monitoring.
         */
        fun requestDuration(requestDuration: Long) = apply { body.requestDuration(requestDuration) }

        /**
         * Sets [Builder.requestDuration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestDuration] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestDuration(requestDuration: JsonField<Long>) = apply {
            body.requestDuration(requestDuration)
        }

        /**
         * The timestamp when your application sent the request to the AI provider, in ISO 8601
         * format with UTC timezone (e.g., '2025-03-02T15:04:05Z'). This is used to calculate
         * request duration and analyze usage patterns over time. Set this to the time immediately
         * before calling the AI provider's API.
         */
        fun requestTime(requestTime: String) = apply { body.requestTime(requestTime) }

        /**
         * Sets [Builder.requestTime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestTime] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun requestTime(requestTime: JsonField<String>) = apply { body.requestTime(requestTime) }

        /**
         * The timestamp when the AI completion finished, in ISO 8601 format with UTC timezone. For
         * streaming requests, this is when the last token was received and the stream closed. For
         * non-streaming requests, this is when the complete response was received. Used to
         * calculate total request duration.
         */
        fun responseTime(responseTime: String) = apply { body.responseTime(responseTime) }

        /**
         * Sets [Builder.responseTime] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseTime] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun responseTime(responseTime: JsonField<String>) = apply {
            body.responseTime(responseTime)
        }

        /** The reason for stopping the completion */
        fun stopReason(stopReason: StopReason) = apply { body.stopReason(stopReason) }

        /**
         * Sets [Builder.stopReason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.stopReason] with a well-typed [StopReason] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun stopReason(stopReason: JsonField<StopReason>) = apply { body.stopReason(stopReason) }

        /** The total number of tokens */
        fun totalTokenCount(totalTokenCount: Long) = apply { body.totalTokenCount(totalTokenCount) }

        /**
         * Sets [Builder.totalTokenCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalTokenCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalTokenCount(totalTokenCount: JsonField<Long>) = apply {
            body.totalTokenCount(totalTokenCount)
        }

        /** The AI agent that is making the request */
        fun agent(agent: String) = apply { body.agent(agent) }

        /**
         * Sets [Builder.agent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agent] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agent(agent: JsonField<String>) = apply { body.agent(agent) }

        /**
         * The cost in USD for cache creation tokens in this completion. Typically leave null to let
         * Revenium automatically calculate costs based on the model and provider's caching pricing.
         * Only provide a value if you have custom pricing agreements or want to override Revenium's
         * cost calculation. If provided, this will override Revenium's automatic calculation.
         */
        fun cacheCreationTokenCost(cacheCreationTokenCost: Double) = apply {
            body.cacheCreationTokenCost(cacheCreationTokenCost)
        }

        /**
         * Sets [Builder.cacheCreationTokenCost] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cacheCreationTokenCost] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun cacheCreationTokenCost(cacheCreationTokenCost: JsonField<Double>) = apply {
            body.cacheCreationTokenCost(cacheCreationTokenCost)
        }

        /**
         * The number of tokens used to create new cache entries (prompt caching). When you send a
         * long prompt for the first time, the AI provider may cache it for faster subsequent
         * requests. Cache creation tokens are typically billed at a higher rate than regular input
         * tokens. Only include if your provider supports prompt caching (e.g., Anthropic Claude,
         * OpenAI with cache-enabled models). Revenium's middleware will always populate this field
         * automatically. Leave null otherwise.
         */
        fun cacheCreationTokenCount(cacheCreationTokenCount: Long) = apply {
            body.cacheCreationTokenCount(cacheCreationTokenCount)
        }

        /**
         * Sets [Builder.cacheCreationTokenCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cacheCreationTokenCount] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun cacheCreationTokenCount(cacheCreationTokenCount: JsonField<Long>) = apply {
            body.cacheCreationTokenCount(cacheCreationTokenCount)
        }

        /**
         * The cost in USD for cache read tokens in this completion. Typically leave null to let
         * Revenium automatically calculate costs based on the model and provider's caching pricing.
         * Only provide a value if you have custom pricing agreements or want to override Revenium's
         * cost calculation. If provided, this will override Revenium's automatic calculation.
         */
        fun cacheReadTokenCost(cacheReadTokenCost: Double) = apply {
            body.cacheReadTokenCost(cacheReadTokenCost)
        }

        /**
         * Sets [Builder.cacheReadTokenCost] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cacheReadTokenCost] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun cacheReadTokenCost(cacheReadTokenCost: JsonField<Double>) = apply {
            body.cacheReadTokenCost(cacheReadTokenCost)
        }

        /**
         * The number of tokens read from cache (prompt caching). When reusing a previously cached
         * prompt, these tokens are read from cache instead of being processed as new input tokens.
         * Cache read tokens are typically billed at a lower rate than regular input tokens. Only
         * include if your provider supports prompt caching and reports cache hits. Revenium's
         * middleware will always populate this field automatically. Leave null otherwise.
         */
        fun cacheReadTokenCount(cacheReadTokenCount: Long) = apply {
            body.cacheReadTokenCount(cacheReadTokenCount)
        }

        /**
         * Sets [Builder.cacheReadTokenCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cacheReadTokenCount] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun cacheReadTokenCount(cacheReadTokenCount: JsonField<Long>) = apply {
            body.cacheReadTokenCount(cacheReadTokenCount)
        }

        /**
         * Error message or reason if the AI completion failed. Include this field when the AI
         * provider returns an error (e.g., rate limit exceeded, invalid API key, model not found,
         * content policy violation). Used for error rate analytics and debugging. Leave null for
         * successful completions.
         */
        fun errorReason(errorReason: String) = apply { body.errorReason(errorReason) }

        /**
         * Sets [Builder.errorReason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.errorReason] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun errorReason(errorReason: JsonField<String>) = apply { body.errorReason(errorReason) }

        /**
         * The cost in USD for input tokens in this completion. Typically leave null to let Revenium
         * automatically calculate costs based on the model and provider's current pricing. Only
         * provide a value if you have custom pricing agreements or want to override Revenium's cost
         * calculation. Note: Manual cost override may not be available on all Revenium plans.
         */
        fun inputTokenCost(inputTokenCost: Double) = apply { body.inputTokenCost(inputTokenCost) }

        /**
         * Sets [Builder.inputTokenCost] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputTokenCost] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun inputTokenCost(inputTokenCost: JsonField<Double>) = apply {
            body.inputTokenCost(inputTokenCost)
        }

        /**
         * The latency in milliseconds introduced by intermediate systems between your application
         * and the AI provider, such as API gateways, proxies, or AI mediation layers. This helps
         * identify performance bottlenecks outside of the AI provider's processing time. Leave null
         * if not using intermediate systems or if latency is not tracked separately.
         */
        fun mediationLatency(mediationLatency: Long) = apply {
            body.mediationLatency(mediationLatency)
        }

        /**
         * Sets [Builder.mediationLatency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mediationLatency] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun mediationLatency(mediationLatency: JsonField<Long>) = apply {
            body.mediationLatency(mediationLatency)
        }

        /**
         * Identifier of the Revenium middleware package or SDK that captured and submitted this AI
         * completion metadata. This field is AUTOMATICALLY SET by Revenium's middleware packages
         * (e.g., 'revenium-openai-python', 'revenium-anthropic-node'). You typically should NOT
         * manually set this field. It is used for analytics to track which integration methods are
         * being used and for debugging middleware-specific issues.
         */
        fun middlewareSource(middlewareSource: String) = apply {
            body.middlewareSource(middlewareSource)
        }

        /**
         * Sets [Builder.middlewareSource] to an arbitrary JSON value.
         *
         * You should usually call [Builder.middlewareSource] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun middlewareSource(middlewareSource: JsonField<String>) = apply {
            body.middlewareSource(middlewareSource)
        }

        /**
         * The routing or aggregation layer used to access the AI model. This identifies whether
         * you're calling the AI provider directly or through an intermediary service.
         *
         * Common values: 'DIRECT', 'LITELLM', 'OPENROUTER', 'PORTKEY', 'AZURE_OPENAI', or provider
         * names ('OPENAI', 'ANTHROPIC', 'GOOGLE', etc.) when calling directly.
         *
         * Custom values are accepted for specialized routing layers or gateways. This field is used
         * for integration tracking and analytics.
         */
        fun modelSource(modelSource: String) = apply { body.modelSource(modelSource) }

        /**
         * Sets [Builder.modelSource] to an arbitrary JSON value.
         *
         * You should usually call [Builder.modelSource] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun modelSource(modelSource: JsonField<String>) = apply { body.modelSource(modelSource) }

        /** The type of operation performed */
        fun operationType(operationType: OperationType) = apply {
            body.operationType(operationType)
        }

        /**
         * Sets [Builder.operationType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.operationType] with a well-typed [OperationType] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun operationType(operationType: JsonField<OperationType>) = apply {
            body.operationType(operationType)
        }

        /**
         * Populate the ID of the subscriber’s organization from your system to allow Revenium to
         * track usage & costs by company. i.e. AcmeCorp. If several subscriberIds have the same
         * organizationId, Revenium’s reporting will show usage for the entire organization broken
         * down by subscriberId.
         */
        fun organizationId(organizationId: String) = apply { body.organizationId(organizationId) }

        /**
         * Sets [Builder.organizationId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.organizationId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun organizationId(organizationId: JsonField<String>) = apply {
            body.organizationId(organizationId)
        }

        /**
         * The cost in USD for output tokens in this completion. Typically leave null to let
         * Revenium automatically calculate costs based on the model and provider's current pricing.
         * Only provide a value if you have custom pricing agreements or want to override Revenium's
         * cost calculation. If provided, this will override Revenium's automatic calculation. Note:
         * Manual cost override may not be available on all Revenium plans.
         */
        fun outputTokenCost(outputTokenCost: Double) = apply {
            body.outputTokenCost(outputTokenCost)
        }

        /**
         * Sets [Builder.outputTokenCost] to an arbitrary JSON value.
         *
         * You should usually call [Builder.outputTokenCost] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun outputTokenCost(outputTokenCost: JsonField<Double>) = apply {
            body.outputTokenCost(outputTokenCost)
        }

        /**
         * Identifier of the product from your own system that you wish to use to correlate usage
         * between Revenium & your application.
         */
        fun productId(productId: String) = apply { body.productId(productId) }

        /**
         * Sets [Builder.productId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.productId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun productId(productId: JsonField<String>) = apply { body.productId(productId) }

        /**
         * The number of reasoning tokens used in the completion. Reasoning tokens are extended
         * thinking tokens used by AI models for complex problem-solving. These are sometimes billed
         * separately from regular input/output tokens. Only include this field if your AI provider
         * reports reasoning tokens Revenium's middleware will always populate this field if
         * reasoning tokens are reported by the AI provider. Leave null for models without reasoning
         * capabilities.
         */
        fun reasoningTokenCount(reasoningTokenCount: Long) = apply {
            body.reasoningTokenCount(reasoningTokenCount)
        }

        /**
         * Sets [Builder.reasoningTokenCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reasoningTokenCount] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun reasoningTokenCount(reasoningTokenCount: JsonField<Long>) = apply {
            body.reasoningTokenCount(reasoningTokenCount)
        }

        /**
         * Optional quality score for the AI response, typically on a 0-100 scale. Set by your
         * application's evaluation logic (e.g., RAGAS, human feedback, custom scoring). Used in
         * Revenium analytics to correlate quality with cost, model choice, and other metrics. Leave
         * null if not tracking quality scores.
         */
        fun responseQualityScore(responseQualityScore: Double) = apply {
            body.responseQualityScore(responseQualityScore)
        }

        /**
         * Sets [Builder.responseQualityScore] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseQualityScore] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun responseQualityScore(responseQualityScore: JsonField<Double>) = apply {
            body.responseQualityScore(responseQualityScore)
        }

        /**
         * Metadata about the subscriber/end-user making this AI request. Include this to track
         * usage by individual users within an organization. Contains user identifiers and
         * associated credential information. Leave null if not tracking individual user-level
         * usage.
         */
        fun subscriber(subscriber: Subscriber) = apply { body.subscriber(subscriber) }

        /**
         * Sets [Builder.subscriber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subscriber] with a well-typed [Subscriber] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun subscriber(subscriber: JsonField<Subscriber>) = apply { body.subscriber(subscriber) }

        /**
         * Unique identifier of the subscription from your own system that you wish to use to
         * correlate usage between Revenium & your application.
         */
        fun subscriptionId(subscriptionId: String) = apply { body.subscriptionId(subscriptionId) }

        /**
         * Sets [Builder.subscriptionId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subscriptionId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun subscriptionId(subscriptionId: JsonField<String>) = apply {
            body.subscriptionId(subscriptionId)
        }

        /**
         * A unique identifier provided by the AI provider that represents the statistical signature
         * of the language model that generated this completion. This fingerprint can be used for
         * model attribution, debugging, and monitoring model behavior across requests.
         * Automatically provided by some AI providers (e.g., OpenAI) in their API responses. Leave
         * null if your provider does not supply this value.
         */
        fun systemFingerprint(systemFingerprint: String) = apply {
            body.systemFingerprint(systemFingerprint)
        }

        /**
         * Sets [Builder.systemFingerprint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.systemFingerprint] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun systemFingerprint(systemFingerprint: JsonField<String>) = apply {
            body.systemFingerprint(systemFingerprint)
        }

        /**
         * Optional category to group related AI tasks for cost and performance analysis. Use
         * consistent values to compare metrics across different models or vendors performing the
         * same type of work. Examples: 'chat', 'summarization', 'code-generation', 'translation',
         * 'image-generation', 'embeddings', 'classification', 'sentiment-analysis'. This is
         * freeform text - choose values that match your use cases.
         */
        fun taskType(taskType: String) = apply { body.taskType(taskType) }

        /**
         * Sets [Builder.taskType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taskType] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun taskType(taskType: JsonField<String>) = apply { body.taskType(taskType) }

        /**
         * The temperature parameter used for this completion, controlling randomness in the AI's
         * output. Typically ranges from 0.0 (deterministic) to 2.0 (very random). Track this to
         * correlate temperature settings with response quality, cost, or other metrics. Useful for
         * A/B testing different temperature values.
         */
        fun temperature(temperature: Double) = apply { body.temperature(temperature) }

        /**
         * Sets [Builder.temperature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.temperature] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun temperature(temperature: JsonField<Double>) = apply { body.temperature(temperature) }

        /**
         * The latency in milliseconds from request start to first token received. Calculated as
         * (completionStartTime - requestTime). This metric is particularly important for streaming
         * completions to measure perceived responsiveness. For non-streaming completions, this may
         * be null or equal to requestDuration.
         */
        fun timeToFirstToken(timeToFirstToken: Long) = apply {
            body.timeToFirstToken(timeToFirstToken)
        }

        /**
         * Sets [Builder.timeToFirstToken] to an arbitrary JSON value.
         *
         * You should usually call [Builder.timeToFirstToken] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun timeToFirstToken(timeToFirstToken: JsonField<Long>) = apply {
            body.timeToFirstToken(timeToFirstToken)
        }

        /**
         * The total cost in USD for this completion (sum of all token costs). Typically leave null
         * to let Revenium automatically calculate the total based on token counts and current
         * pricing. Only provide a value if you have custom pricing agreements or want to override
         * Revenium's cost calculation. If provided, this will override Revenium's automatic
         * calculation.
         */
        fun totalCost(totalCost: Double) = apply { body.totalCost(totalCost) }

        /**
         * Sets [Builder.totalCost] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalCost] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalCost(totalCost: JsonField<Double>) = apply { body.totalCost(totalCost) }

        /**
         * Optional trace identifier to group multiple related AI completion calls that belong to
         * the same overall user request or workflow. For example, if a single user query triggers
         * multiple LLM calls (e.g., retrieval + generation), use the same traceId for all calls to
         * analyze them together in Revenium's analytics. Leave null for standalone completions.
         */
        fun traceId(traceId: String) = apply { body.traceId(traceId) }

        /**
         * Sets [Builder.traceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.traceId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun traceId(traceId: JsonField<String>) = apply { body.traceId(traceId) }

        /**
         * Unique identifier for this specific AI completion transaction. Used for deduplication,
         * correlation with request/response pairs, and transaction lookup in Revenium analytics. If
         * not provided, a UUID will be auto-generated. For best practices, generate a UUID in your
         * application before making the AI call and use the same ID when submitting to Revenium.
         */
        fun transactionId(transactionId: String) = apply { body.transactionId(transactionId) }

        /**
         * Sets [Builder.transactionId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.transactionId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun transactionId(transactionId: JsonField<String>) = apply {
            body.transactionId(transactionId)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [AiCreateCompletionParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .completionStartTime()
         * .costType()
         * .inputTokenCount()
         * .isStreamed()
         * .model()
         * .outputTokenCount()
         * .provider()
         * .requestDuration()
         * .requestTime()
         * .responseTime()
         * .stopReason()
         * .totalTokenCount()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AiCreateCompletionParams =
            AiCreateCompletionParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * Completion metadata details for LLM completions, capturing identifiers and cost metrics for
     * analytics and monetization.
     */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val completionStartTime: JsonField<String>,
        private val costType: JsonField<CostType>,
        private val inputTokenCount: JsonField<Long>,
        private val isStreamed: JsonField<Boolean>,
        private val model: JsonField<String>,
        private val outputTokenCount: JsonField<Long>,
        private val provider: JsonField<String>,
        private val requestDuration: JsonField<Long>,
        private val requestTime: JsonField<String>,
        private val responseTime: JsonField<String>,
        private val stopReason: JsonField<StopReason>,
        private val totalTokenCount: JsonField<Long>,
        private val agent: JsonField<String>,
        private val cacheCreationTokenCost: JsonField<Double>,
        private val cacheCreationTokenCount: JsonField<Long>,
        private val cacheReadTokenCost: JsonField<Double>,
        private val cacheReadTokenCount: JsonField<Long>,
        private val errorReason: JsonField<String>,
        private val inputTokenCost: JsonField<Double>,
        private val mediationLatency: JsonField<Long>,
        private val middlewareSource: JsonField<String>,
        private val modelSource: JsonField<String>,
        private val operationType: JsonField<OperationType>,
        private val organizationId: JsonField<String>,
        private val outputTokenCost: JsonField<Double>,
        private val productId: JsonField<String>,
        private val reasoningTokenCount: JsonField<Long>,
        private val responseQualityScore: JsonField<Double>,
        private val subscriber: JsonField<Subscriber>,
        private val subscriptionId: JsonField<String>,
        private val systemFingerprint: JsonField<String>,
        private val taskType: JsonField<String>,
        private val temperature: JsonField<Double>,
        private val timeToFirstToken: JsonField<Long>,
        private val totalCost: JsonField<Double>,
        private val traceId: JsonField<String>,
        private val transactionId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("completionStartTime")
            @ExcludeMissing
            completionStartTime: JsonField<String> = JsonMissing.of(),
            @JsonProperty("costType")
            @ExcludeMissing
            costType: JsonField<CostType> = JsonMissing.of(),
            @JsonProperty("inputTokenCount")
            @ExcludeMissing
            inputTokenCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("isStreamed")
            @ExcludeMissing
            isStreamed: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("model") @ExcludeMissing model: JsonField<String> = JsonMissing.of(),
            @JsonProperty("outputTokenCount")
            @ExcludeMissing
            outputTokenCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("provider")
            @ExcludeMissing
            provider: JsonField<String> = JsonMissing.of(),
            @JsonProperty("requestDuration")
            @ExcludeMissing
            requestDuration: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("requestTime")
            @ExcludeMissing
            requestTime: JsonField<String> = JsonMissing.of(),
            @JsonProperty("responseTime")
            @ExcludeMissing
            responseTime: JsonField<String> = JsonMissing.of(),
            @JsonProperty("stopReason")
            @ExcludeMissing
            stopReason: JsonField<StopReason> = JsonMissing.of(),
            @JsonProperty("totalTokenCount")
            @ExcludeMissing
            totalTokenCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cacheCreationTokenCost")
            @ExcludeMissing
            cacheCreationTokenCost: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("cacheCreationTokenCount")
            @ExcludeMissing
            cacheCreationTokenCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("cacheReadTokenCost")
            @ExcludeMissing
            cacheReadTokenCost: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("cacheReadTokenCount")
            @ExcludeMissing
            cacheReadTokenCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("errorReason")
            @ExcludeMissing
            errorReason: JsonField<String> = JsonMissing.of(),
            @JsonProperty("inputTokenCost")
            @ExcludeMissing
            inputTokenCost: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("mediationLatency")
            @ExcludeMissing
            mediationLatency: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("middlewareSource")
            @ExcludeMissing
            middlewareSource: JsonField<String> = JsonMissing.of(),
            @JsonProperty("modelSource")
            @ExcludeMissing
            modelSource: JsonField<String> = JsonMissing.of(),
            @JsonProperty("operationType")
            @ExcludeMissing
            operationType: JsonField<OperationType> = JsonMissing.of(),
            @JsonProperty("organizationId")
            @ExcludeMissing
            organizationId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("outputTokenCost")
            @ExcludeMissing
            outputTokenCost: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("productId")
            @ExcludeMissing
            productId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reasoningTokenCount")
            @ExcludeMissing
            reasoningTokenCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("responseQualityScore")
            @ExcludeMissing
            responseQualityScore: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("subscriber")
            @ExcludeMissing
            subscriber: JsonField<Subscriber> = JsonMissing.of(),
            @JsonProperty("subscriptionId")
            @ExcludeMissing
            subscriptionId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("systemFingerprint")
            @ExcludeMissing
            systemFingerprint: JsonField<String> = JsonMissing.of(),
            @JsonProperty("taskType")
            @ExcludeMissing
            taskType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("temperature")
            @ExcludeMissing
            temperature: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("timeToFirstToken")
            @ExcludeMissing
            timeToFirstToken: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("totalCost")
            @ExcludeMissing
            totalCost: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("traceId") @ExcludeMissing traceId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("transactionId")
            @ExcludeMissing
            transactionId: JsonField<String> = JsonMissing.of(),
        ) : this(
            completionStartTime,
            costType,
            inputTokenCount,
            isStreamed,
            model,
            outputTokenCount,
            provider,
            requestDuration,
            requestTime,
            responseTime,
            stopReason,
            totalTokenCount,
            agent,
            cacheCreationTokenCost,
            cacheCreationTokenCount,
            cacheReadTokenCost,
            cacheReadTokenCount,
            errorReason,
            inputTokenCost,
            mediationLatency,
            middlewareSource,
            modelSource,
            operationType,
            organizationId,
            outputTokenCost,
            productId,
            reasoningTokenCount,
            responseQualityScore,
            subscriber,
            subscriptionId,
            systemFingerprint,
            taskType,
            temperature,
            timeToFirstToken,
            totalCost,
            traceId,
            transactionId,
            mutableMapOf(),
        )

        /**
         * The timestamp when the AI completion started generating output, in ISO 8601 format with
         * UTC timezone. For streaming requests, this is when the first token was received. For
         * non-streaming requests, this is typically the same as or very close to responseTime. Used
         * to calculate time-to-first-token latency for streaming completions.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun completionStartTime(): String = completionStartTime.getRequired("completionStartTime")

        /**
         * The type of cost being tracked. Currently always 'AI' for AI completion costs. This field
         * is used internally by Revenium to categorize different types of metered usage. You
         * typically do not need to set this field as it defaults to 'AI'.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun costType(): CostType = costType.getRequired("costType")

        /**
         * The count of consumed input tokens
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun inputTokenCount(): Long = inputTokenCount.getRequired("inputTokenCount")

        /**
         * Indicates whether this completion used streaming (true) or non-streaming/batch mode
         * (false). Streaming completions receive tokens incrementally as they're generated, while
         * non-streaming completions wait for the complete response. This affects how
         * timeToFirstToken and responseTime are interpreted.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun isStreamed(): Boolean = isStreamed.getRequired("isStreamed")

        /**
         * The AI model identifier used for this completion. Should match the exact model name from
         * your AI provider (e.g., 'gpt-4', 'claude-3-opus-20240229', 'gemini-pro'). This is used
         * for cost calculation, performance analytics, and model comparison reporting in Revenium.
         * Valid model names in Revenium for proper cost estimate can be verified using the
         * sources/ai/models endpoint.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun model(): String = model.getRequired("model")

        /**
         * The count of consumed output tokens
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun outputTokenCount(): Long = outputTokenCount.getRequired("outputTokenCount")

        /**
         * The underlying AI provider/vendor whose model is actually processing the request. This
         * identifies which company's AI model is being used, regardless of how you're accessing it
         * (direct API, proxy, or gateway).
         *
         * Common values: 'OpenAI' (for GPT models), 'Anthropic' (for Claude models), 'Google' (for
         * Gemini models), 'Cohere', 'Mistral', 'Meta' (for Llama models), 'Amazon Bedrock',
         * 'Azure'.
         *
         * Custom values are accepted but may affect analytics categorization. Revenium looks up
         * model pricing primarily by model name (e.g., 'gpt-4', 'claude-3-opus'), so using
         * non-standard provider names will not break cost calculation. However, using standard
         * provider names ensures proper categorization in analytics and reporting.
         *
         * If using an aggregation service like LiteLLM or OpenRouter, this should still be the
         * actual provider (e.g., 'Anthropic' not 'LiteLLM'). If using Revenium middleware, this is
         * typically auto-populated from the AI provider's API response. Supported provider models
         * can be verified using the sources/ai/models endpoint which returns both providers and
         * model names.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun provider(): String = provider.getRequired("provider")

        /**
         * The total duration of the AI completion request in milliseconds, from request start to
         * completion. Calculated as (responseTime - requestTime). This includes network latency, AI
         * processing time, and any mediation/gateway overhead. Used for performance analytics and
         * SLA monitoring.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun requestDuration(): Long = requestDuration.getRequired("requestDuration")

        /**
         * The timestamp when your application sent the request to the AI provider, in ISO 8601
         * format with UTC timezone (e.g., '2025-03-02T15:04:05Z'). This is used to calculate
         * request duration and analyze usage patterns over time. Set this to the time immediately
         * before calling the AI provider's API.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun requestTime(): String = requestTime.getRequired("requestTime")

        /**
         * The timestamp when the AI completion finished, in ISO 8601 format with UTC timezone. For
         * streaming requests, this is when the last token was received and the stream closed. For
         * non-streaming requests, this is when the complete response was received. Used to
         * calculate total request duration.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun responseTime(): String = responseTime.getRequired("responseTime")

        /**
         * The reason for stopping the completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun stopReason(): StopReason = stopReason.getRequired("stopReason")

        /**
         * The total number of tokens
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun totalTokenCount(): Long = totalTokenCount.getRequired("totalTokenCount")

        /**
         * The AI agent that is making the request
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun agent(): Optional<String> = agent.getOptional("agent")

        /**
         * The cost in USD for cache creation tokens in this completion. Typically leave null to let
         * Revenium automatically calculate costs based on the model and provider's caching pricing.
         * Only provide a value if you have custom pricing agreements or want to override Revenium's
         * cost calculation. If provided, this will override Revenium's automatic calculation.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun cacheCreationTokenCost(): Optional<Double> =
            cacheCreationTokenCost.getOptional("cacheCreationTokenCost")

        /**
         * The number of tokens used to create new cache entries (prompt caching). When you send a
         * long prompt for the first time, the AI provider may cache it for faster subsequent
         * requests. Cache creation tokens are typically billed at a higher rate than regular input
         * tokens. Only include if your provider supports prompt caching (e.g., Anthropic Claude,
         * OpenAI with cache-enabled models). Revenium's middleware will always populate this field
         * automatically. Leave null otherwise.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun cacheCreationTokenCount(): Optional<Long> =
            cacheCreationTokenCount.getOptional("cacheCreationTokenCount")

        /**
         * The cost in USD for cache read tokens in this completion. Typically leave null to let
         * Revenium automatically calculate costs based on the model and provider's caching pricing.
         * Only provide a value if you have custom pricing agreements or want to override Revenium's
         * cost calculation. If provided, this will override Revenium's automatic calculation.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun cacheReadTokenCost(): Optional<Double> =
            cacheReadTokenCost.getOptional("cacheReadTokenCost")

        /**
         * The number of tokens read from cache (prompt caching). When reusing a previously cached
         * prompt, these tokens are read from cache instead of being processed as new input tokens.
         * Cache read tokens are typically billed at a lower rate than regular input tokens. Only
         * include if your provider supports prompt caching and reports cache hits. Revenium's
         * middleware will always populate this field automatically. Leave null otherwise.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun cacheReadTokenCount(): Optional<Long> =
            cacheReadTokenCount.getOptional("cacheReadTokenCount")

        /**
         * Error message or reason if the AI completion failed. Include this field when the AI
         * provider returns an error (e.g., rate limit exceeded, invalid API key, model not found,
         * content policy violation). Used for error rate analytics and debugging. Leave null for
         * successful completions.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun errorReason(): Optional<String> = errorReason.getOptional("errorReason")

        /**
         * The cost in USD for input tokens in this completion. Typically leave null to let Revenium
         * automatically calculate costs based on the model and provider's current pricing. Only
         * provide a value if you have custom pricing agreements or want to override Revenium's cost
         * calculation. Note: Manual cost override may not be available on all Revenium plans.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun inputTokenCost(): Optional<Double> = inputTokenCost.getOptional("inputTokenCost")

        /**
         * The latency in milliseconds introduced by intermediate systems between your application
         * and the AI provider, such as API gateways, proxies, or AI mediation layers. This helps
         * identify performance bottlenecks outside of the AI provider's processing time. Leave null
         * if not using intermediate systems or if latency is not tracked separately.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mediationLatency(): Optional<Long> = mediationLatency.getOptional("mediationLatency")

        /**
         * Identifier of the Revenium middleware package or SDK that captured and submitted this AI
         * completion metadata. This field is AUTOMATICALLY SET by Revenium's middleware packages
         * (e.g., 'revenium-openai-python', 'revenium-anthropic-node'). You typically should NOT
         * manually set this field. It is used for analytics to track which integration methods are
         * being used and for debugging middleware-specific issues.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun middlewareSource(): Optional<String> = middlewareSource.getOptional("middlewareSource")

        /**
         * The routing or aggregation layer used to access the AI model. This identifies whether
         * you're calling the AI provider directly or through an intermediary service.
         *
         * Common values: 'DIRECT', 'LITELLM', 'OPENROUTER', 'PORTKEY', 'AZURE_OPENAI', or provider
         * names ('OPENAI', 'ANTHROPIC', 'GOOGLE', etc.) when calling directly.
         *
         * Custom values are accepted for specialized routing layers or gateways. This field is used
         * for integration tracking and analytics.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun modelSource(): Optional<String> = modelSource.getOptional("modelSource")

        /**
         * The type of operation performed
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun operationType(): Optional<OperationType> = operationType.getOptional("operationType")

        /**
         * Populate the ID of the subscriber’s organization from your system to allow Revenium to
         * track usage & costs by company. i.e. AcmeCorp. If several subscriberIds have the same
         * organizationId, Revenium’s reporting will show usage for the entire organization broken
         * down by subscriberId.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun organizationId(): Optional<String> = organizationId.getOptional("organizationId")

        /**
         * The cost in USD for output tokens in this completion. Typically leave null to let
         * Revenium automatically calculate costs based on the model and provider's current pricing.
         * Only provide a value if you have custom pricing agreements or want to override Revenium's
         * cost calculation. If provided, this will override Revenium's automatic calculation. Note:
         * Manual cost override may not be available on all Revenium plans.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun outputTokenCost(): Optional<Double> = outputTokenCost.getOptional("outputTokenCost")

        /**
         * Identifier of the product from your own system that you wish to use to correlate usage
         * between Revenium & your application.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun productId(): Optional<String> = productId.getOptional("productId")

        /**
         * The number of reasoning tokens used in the completion. Reasoning tokens are extended
         * thinking tokens used by AI models for complex problem-solving. These are sometimes billed
         * separately from regular input/output tokens. Only include this field if your AI provider
         * reports reasoning tokens Revenium's middleware will always populate this field if
         * reasoning tokens are reported by the AI provider. Leave null for models without reasoning
         * capabilities.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun reasoningTokenCount(): Optional<Long> =
            reasoningTokenCount.getOptional("reasoningTokenCount")

        /**
         * Optional quality score for the AI response, typically on a 0-100 scale. Set by your
         * application's evaluation logic (e.g., RAGAS, human feedback, custom scoring). Used in
         * Revenium analytics to correlate quality with cost, model choice, and other metrics. Leave
         * null if not tracking quality scores.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun responseQualityScore(): Optional<Double> =
            responseQualityScore.getOptional("responseQualityScore")

        /**
         * Metadata about the subscriber/end-user making this AI request. Include this to track
         * usage by individual users within an organization. Contains user identifiers and
         * associated credential information. Leave null if not tracking individual user-level
         * usage.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun subscriber(): Optional<Subscriber> = subscriber.getOptional("subscriber")

        /**
         * Unique identifier of the subscription from your own system that you wish to use to
         * correlate usage between Revenium & your application.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun subscriptionId(): Optional<String> = subscriptionId.getOptional("subscriptionId")

        /**
         * A unique identifier provided by the AI provider that represents the statistical signature
         * of the language model that generated this completion. This fingerprint can be used for
         * model attribution, debugging, and monitoring model behavior across requests.
         * Automatically provided by some AI providers (e.g., OpenAI) in their API responses. Leave
         * null if your provider does not supply this value.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun systemFingerprint(): Optional<String> =
            systemFingerprint.getOptional("systemFingerprint")

        /**
         * Optional category to group related AI tasks for cost and performance analysis. Use
         * consistent values to compare metrics across different models or vendors performing the
         * same type of work. Examples: 'chat', 'summarization', 'code-generation', 'translation',
         * 'image-generation', 'embeddings', 'classification', 'sentiment-analysis'. This is
         * freeform text - choose values that match your use cases.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun taskType(): Optional<String> = taskType.getOptional("taskType")

        /**
         * The temperature parameter used for this completion, controlling randomness in the AI's
         * output. Typically ranges from 0.0 (deterministic) to 2.0 (very random). Track this to
         * correlate temperature settings with response quality, cost, or other metrics. Useful for
         * A/B testing different temperature values.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> = temperature.getOptional("temperature")

        /**
         * The latency in milliseconds from request start to first token received. Calculated as
         * (completionStartTime - requestTime). This metric is particularly important for streaming
         * completions to measure perceived responsiveness. For non-streaming completions, this may
         * be null or equal to requestDuration.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun timeToFirstToken(): Optional<Long> = timeToFirstToken.getOptional("timeToFirstToken")

        /**
         * The total cost in USD for this completion (sum of all token costs). Typically leave null
         * to let Revenium automatically calculate the total based on token counts and current
         * pricing. Only provide a value if you have custom pricing agreements or want to override
         * Revenium's cost calculation. If provided, this will override Revenium's automatic
         * calculation.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun totalCost(): Optional<Double> = totalCost.getOptional("totalCost")

        /**
         * Optional trace identifier to group multiple related AI completion calls that belong to
         * the same overall user request or workflow. For example, if a single user query triggers
         * multiple LLM calls (e.g., retrieval + generation), use the same traceId for all calls to
         * analyze them together in Revenium's analytics. Leave null for standalone completions.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun traceId(): Optional<String> = traceId.getOptional("traceId")

        /**
         * Unique identifier for this specific AI completion transaction. Used for deduplication,
         * correlation with request/response pairs, and transaction lookup in Revenium analytics. If
         * not provided, a UUID will be auto-generated. For best practices, generate a UUID in your
         * application before making the AI call and use the same ID when submitting to Revenium.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun transactionId(): Optional<String> = transactionId.getOptional("transactionId")

        /**
         * Returns the raw JSON value of [completionStartTime].
         *
         * Unlike [completionStartTime], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("completionStartTime")
        @ExcludeMissing
        fun _completionStartTime(): JsonField<String> = completionStartTime

        /**
         * Returns the raw JSON value of [costType].
         *
         * Unlike [costType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("costType") @ExcludeMissing fun _costType(): JsonField<CostType> = costType

        /**
         * Returns the raw JSON value of [inputTokenCount].
         *
         * Unlike [inputTokenCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("inputTokenCount")
        @ExcludeMissing
        fun _inputTokenCount(): JsonField<Long> = inputTokenCount

        /**
         * Returns the raw JSON value of [isStreamed].
         *
         * Unlike [isStreamed], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("isStreamed")
        @ExcludeMissing
        fun _isStreamed(): JsonField<Boolean> = isStreamed

        /**
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

        /**
         * Returns the raw JSON value of [outputTokenCount].
         *
         * Unlike [outputTokenCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("outputTokenCount")
        @ExcludeMissing
        fun _outputTokenCount(): JsonField<Long> = outputTokenCount

        /**
         * Returns the raw JSON value of [provider].
         *
         * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("provider") @ExcludeMissing fun _provider(): JsonField<String> = provider

        /**
         * Returns the raw JSON value of [requestDuration].
         *
         * Unlike [requestDuration], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("requestDuration")
        @ExcludeMissing
        fun _requestDuration(): JsonField<Long> = requestDuration

        /**
         * Returns the raw JSON value of [requestTime].
         *
         * Unlike [requestTime], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("requestTime")
        @ExcludeMissing
        fun _requestTime(): JsonField<String> = requestTime

        /**
         * Returns the raw JSON value of [responseTime].
         *
         * Unlike [responseTime], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("responseTime")
        @ExcludeMissing
        fun _responseTime(): JsonField<String> = responseTime

        /**
         * Returns the raw JSON value of [stopReason].
         *
         * Unlike [stopReason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stopReason")
        @ExcludeMissing
        fun _stopReason(): JsonField<StopReason> = stopReason

        /**
         * Returns the raw JSON value of [totalTokenCount].
         *
         * Unlike [totalTokenCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("totalTokenCount")
        @ExcludeMissing
        fun _totalTokenCount(): JsonField<Long> = totalTokenCount

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<String> = agent

        /**
         * Returns the raw JSON value of [cacheCreationTokenCost].
         *
         * Unlike [cacheCreationTokenCost], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("cacheCreationTokenCost")
        @ExcludeMissing
        fun _cacheCreationTokenCost(): JsonField<Double> = cacheCreationTokenCost

        /**
         * Returns the raw JSON value of [cacheCreationTokenCount].
         *
         * Unlike [cacheCreationTokenCount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("cacheCreationTokenCount")
        @ExcludeMissing
        fun _cacheCreationTokenCount(): JsonField<Long> = cacheCreationTokenCount

        /**
         * Returns the raw JSON value of [cacheReadTokenCost].
         *
         * Unlike [cacheReadTokenCost], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("cacheReadTokenCost")
        @ExcludeMissing
        fun _cacheReadTokenCost(): JsonField<Double> = cacheReadTokenCost

        /**
         * Returns the raw JSON value of [cacheReadTokenCount].
         *
         * Unlike [cacheReadTokenCount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("cacheReadTokenCount")
        @ExcludeMissing
        fun _cacheReadTokenCount(): JsonField<Long> = cacheReadTokenCount

        /**
         * Returns the raw JSON value of [errorReason].
         *
         * Unlike [errorReason], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("errorReason")
        @ExcludeMissing
        fun _errorReason(): JsonField<String> = errorReason

        /**
         * Returns the raw JSON value of [inputTokenCost].
         *
         * Unlike [inputTokenCost], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("inputTokenCost")
        @ExcludeMissing
        fun _inputTokenCost(): JsonField<Double> = inputTokenCost

        /**
         * Returns the raw JSON value of [mediationLatency].
         *
         * Unlike [mediationLatency], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("mediationLatency")
        @ExcludeMissing
        fun _mediationLatency(): JsonField<Long> = mediationLatency

        /**
         * Returns the raw JSON value of [middlewareSource].
         *
         * Unlike [middlewareSource], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("middlewareSource")
        @ExcludeMissing
        fun _middlewareSource(): JsonField<String> = middlewareSource

        /**
         * Returns the raw JSON value of [modelSource].
         *
         * Unlike [modelSource], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("modelSource")
        @ExcludeMissing
        fun _modelSource(): JsonField<String> = modelSource

        /**
         * Returns the raw JSON value of [operationType].
         *
         * Unlike [operationType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("operationType")
        @ExcludeMissing
        fun _operationType(): JsonField<OperationType> = operationType

        /**
         * Returns the raw JSON value of [organizationId].
         *
         * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("organizationId")
        @ExcludeMissing
        fun _organizationId(): JsonField<String> = organizationId

        /**
         * Returns the raw JSON value of [outputTokenCost].
         *
         * Unlike [outputTokenCost], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("outputTokenCost")
        @ExcludeMissing
        fun _outputTokenCost(): JsonField<Double> = outputTokenCost

        /**
         * Returns the raw JSON value of [productId].
         *
         * Unlike [productId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("productId") @ExcludeMissing fun _productId(): JsonField<String> = productId

        /**
         * Returns the raw JSON value of [reasoningTokenCount].
         *
         * Unlike [reasoningTokenCount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("reasoningTokenCount")
        @ExcludeMissing
        fun _reasoningTokenCount(): JsonField<Long> = reasoningTokenCount

        /**
         * Returns the raw JSON value of [responseQualityScore].
         *
         * Unlike [responseQualityScore], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("responseQualityScore")
        @ExcludeMissing
        fun _responseQualityScore(): JsonField<Double> = responseQualityScore

        /**
         * Returns the raw JSON value of [subscriber].
         *
         * Unlike [subscriber], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("subscriber")
        @ExcludeMissing
        fun _subscriber(): JsonField<Subscriber> = subscriber

        /**
         * Returns the raw JSON value of [subscriptionId].
         *
         * Unlike [subscriptionId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("subscriptionId")
        @ExcludeMissing
        fun _subscriptionId(): JsonField<String> = subscriptionId

        /**
         * Returns the raw JSON value of [systemFingerprint].
         *
         * Unlike [systemFingerprint], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("systemFingerprint")
        @ExcludeMissing
        fun _systemFingerprint(): JsonField<String> = systemFingerprint

        /**
         * Returns the raw JSON value of [taskType].
         *
         * Unlike [taskType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("taskType") @ExcludeMissing fun _taskType(): JsonField<String> = taskType

        /**
         * Returns the raw JSON value of [temperature].
         *
         * Unlike [temperature], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("temperature")
        @ExcludeMissing
        fun _temperature(): JsonField<Double> = temperature

        /**
         * Returns the raw JSON value of [timeToFirstToken].
         *
         * Unlike [timeToFirstToken], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("timeToFirstToken")
        @ExcludeMissing
        fun _timeToFirstToken(): JsonField<Long> = timeToFirstToken

        /**
         * Returns the raw JSON value of [totalCost].
         *
         * Unlike [totalCost], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("totalCost") @ExcludeMissing fun _totalCost(): JsonField<Double> = totalCost

        /**
         * Returns the raw JSON value of [traceId].
         *
         * Unlike [traceId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("traceId") @ExcludeMissing fun _traceId(): JsonField<String> = traceId

        /**
         * Returns the raw JSON value of [transactionId].
         *
         * Unlike [transactionId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("transactionId")
        @ExcludeMissing
        fun _transactionId(): JsonField<String> = transactionId

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .completionStartTime()
             * .costType()
             * .inputTokenCount()
             * .isStreamed()
             * .model()
             * .outputTokenCount()
             * .provider()
             * .requestDuration()
             * .requestTime()
             * .responseTime()
             * .stopReason()
             * .totalTokenCount()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var completionStartTime: JsonField<String>? = null
            private var costType: JsonField<CostType>? = null
            private var inputTokenCount: JsonField<Long>? = null
            private var isStreamed: JsonField<Boolean>? = null
            private var model: JsonField<String>? = null
            private var outputTokenCount: JsonField<Long>? = null
            private var provider: JsonField<String>? = null
            private var requestDuration: JsonField<Long>? = null
            private var requestTime: JsonField<String>? = null
            private var responseTime: JsonField<String>? = null
            private var stopReason: JsonField<StopReason>? = null
            private var totalTokenCount: JsonField<Long>? = null
            private var agent: JsonField<String> = JsonMissing.of()
            private var cacheCreationTokenCost: JsonField<Double> = JsonMissing.of()
            private var cacheCreationTokenCount: JsonField<Long> = JsonMissing.of()
            private var cacheReadTokenCost: JsonField<Double> = JsonMissing.of()
            private var cacheReadTokenCount: JsonField<Long> = JsonMissing.of()
            private var errorReason: JsonField<String> = JsonMissing.of()
            private var inputTokenCost: JsonField<Double> = JsonMissing.of()
            private var mediationLatency: JsonField<Long> = JsonMissing.of()
            private var middlewareSource: JsonField<String> = JsonMissing.of()
            private var modelSource: JsonField<String> = JsonMissing.of()
            private var operationType: JsonField<OperationType> = JsonMissing.of()
            private var organizationId: JsonField<String> = JsonMissing.of()
            private var outputTokenCost: JsonField<Double> = JsonMissing.of()
            private var productId: JsonField<String> = JsonMissing.of()
            private var reasoningTokenCount: JsonField<Long> = JsonMissing.of()
            private var responseQualityScore: JsonField<Double> = JsonMissing.of()
            private var subscriber: JsonField<Subscriber> = JsonMissing.of()
            private var subscriptionId: JsonField<String> = JsonMissing.of()
            private var systemFingerprint: JsonField<String> = JsonMissing.of()
            private var taskType: JsonField<String> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var timeToFirstToken: JsonField<Long> = JsonMissing.of()
            private var totalCost: JsonField<Double> = JsonMissing.of()
            private var traceId: JsonField<String> = JsonMissing.of()
            private var transactionId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                completionStartTime = body.completionStartTime
                costType = body.costType
                inputTokenCount = body.inputTokenCount
                isStreamed = body.isStreamed
                model = body.model
                outputTokenCount = body.outputTokenCount
                provider = body.provider
                requestDuration = body.requestDuration
                requestTime = body.requestTime
                responseTime = body.responseTime
                stopReason = body.stopReason
                totalTokenCount = body.totalTokenCount
                agent = body.agent
                cacheCreationTokenCost = body.cacheCreationTokenCost
                cacheCreationTokenCount = body.cacheCreationTokenCount
                cacheReadTokenCost = body.cacheReadTokenCost
                cacheReadTokenCount = body.cacheReadTokenCount
                errorReason = body.errorReason
                inputTokenCost = body.inputTokenCost
                mediationLatency = body.mediationLatency
                middlewareSource = body.middlewareSource
                modelSource = body.modelSource
                operationType = body.operationType
                organizationId = body.organizationId
                outputTokenCost = body.outputTokenCost
                productId = body.productId
                reasoningTokenCount = body.reasoningTokenCount
                responseQualityScore = body.responseQualityScore
                subscriber = body.subscriber
                subscriptionId = body.subscriptionId
                systemFingerprint = body.systemFingerprint
                taskType = body.taskType
                temperature = body.temperature
                timeToFirstToken = body.timeToFirstToken
                totalCost = body.totalCost
                traceId = body.traceId
                transactionId = body.transactionId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The timestamp when the AI completion started generating output, in ISO 8601 format
             * with UTC timezone. For streaming requests, this is when the first token was received.
             * For non-streaming requests, this is typically the same as or very close to
             * responseTime. Used to calculate time-to-first-token latency for streaming
             * completions.
             */
            fun completionStartTime(completionStartTime: String) =
                completionStartTime(JsonField.of(completionStartTime))

            /**
             * Sets [Builder.completionStartTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.completionStartTime] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun completionStartTime(completionStartTime: JsonField<String>) = apply {
                this.completionStartTime = completionStartTime
            }

            /**
             * The type of cost being tracked. Currently always 'AI' for AI completion costs. This
             * field is used internally by Revenium to categorize different types of metered usage.
             * You typically do not need to set this field as it defaults to 'AI'.
             */
            fun costType(costType: CostType) = costType(JsonField.of(costType))

            /**
             * Sets [Builder.costType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.costType] with a well-typed [CostType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun costType(costType: JsonField<CostType>) = apply { this.costType = costType }

            /** The count of consumed input tokens */
            fun inputTokenCount(inputTokenCount: Long) =
                inputTokenCount(JsonField.of(inputTokenCount))

            /**
             * Sets [Builder.inputTokenCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputTokenCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inputTokenCount(inputTokenCount: JsonField<Long>) = apply {
                this.inputTokenCount = inputTokenCount
            }

            /**
             * Indicates whether this completion used streaming (true) or non-streaming/batch mode
             * (false). Streaming completions receive tokens incrementally as they're generated,
             * while non-streaming completions wait for the complete response. This affects how
             * timeToFirstToken and responseTime are interpreted.
             */
            fun isStreamed(isStreamed: Boolean) = isStreamed(JsonField.of(isStreamed))

            /**
             * Sets [Builder.isStreamed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isStreamed] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isStreamed(isStreamed: JsonField<Boolean>) = apply { this.isStreamed = isStreamed }

            /**
             * The AI model identifier used for this completion. Should match the exact model name
             * from your AI provider (e.g., 'gpt-4', 'claude-3-opus-20240229', 'gemini-pro'). This
             * is used for cost calculation, performance analytics, and model comparison reporting
             * in Revenium. Valid model names in Revenium for proper cost estimate can be verified
             * using the sources/ai/models endpoint.
             */
            fun model(model: String) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<String>) = apply { this.model = model }

            /** The count of consumed output tokens */
            fun outputTokenCount(outputTokenCount: Long) =
                outputTokenCount(JsonField.of(outputTokenCount))

            /**
             * Sets [Builder.outputTokenCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputTokenCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputTokenCount(outputTokenCount: JsonField<Long>) = apply {
                this.outputTokenCount = outputTokenCount
            }

            /**
             * The underlying AI provider/vendor whose model is actually processing the request.
             * This identifies which company's AI model is being used, regardless of how you're
             * accessing it (direct API, proxy, or gateway).
             *
             * Common values: 'OpenAI' (for GPT models), 'Anthropic' (for Claude models), 'Google'
             * (for Gemini models), 'Cohere', 'Mistral', 'Meta' (for Llama models), 'Amazon
             * Bedrock', 'Azure'.
             *
             * Custom values are accepted but may affect analytics categorization. Revenium looks up
             * model pricing primarily by model name (e.g., 'gpt-4', 'claude-3-opus'), so using
             * non-standard provider names will not break cost calculation. However, using standard
             * provider names ensures proper categorization in analytics and reporting.
             *
             * If using an aggregation service like LiteLLM or OpenRouter, this should still be the
             * actual provider (e.g., 'Anthropic' not 'LiteLLM'). If using Revenium middleware, this
             * is typically auto-populated from the AI provider's API response. Supported provider
             * models can be verified using the sources/ai/models endpoint which returns both
             * providers and model names.
             */
            fun provider(provider: String) = provider(JsonField.of(provider))

            /**
             * Sets [Builder.provider] to an arbitrary JSON value.
             *
             * You should usually call [Builder.provider] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun provider(provider: JsonField<String>) = apply { this.provider = provider }

            /**
             * The total duration of the AI completion request in milliseconds, from request start
             * to completion. Calculated as (responseTime - requestTime). This includes network
             * latency, AI processing time, and any mediation/gateway overhead. Used for performance
             * analytics and SLA monitoring.
             */
            fun requestDuration(requestDuration: Long) =
                requestDuration(JsonField.of(requestDuration))

            /**
             * Sets [Builder.requestDuration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestDuration] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestDuration(requestDuration: JsonField<Long>) = apply {
                this.requestDuration = requestDuration
            }

            /**
             * The timestamp when your application sent the request to the AI provider, in ISO 8601
             * format with UTC timezone (e.g., '2025-03-02T15:04:05Z'). This is used to calculate
             * request duration and analyze usage patterns over time. Set this to the time
             * immediately before calling the AI provider's API.
             */
            fun requestTime(requestTime: String) = requestTime(JsonField.of(requestTime))

            /**
             * Sets [Builder.requestTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestTime] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestTime(requestTime: JsonField<String>) = apply {
                this.requestTime = requestTime
            }

            /**
             * The timestamp when the AI completion finished, in ISO 8601 format with UTC timezone.
             * For streaming requests, this is when the last token was received and the stream
             * closed. For non-streaming requests, this is when the complete response was received.
             * Used to calculate total request duration.
             */
            fun responseTime(responseTime: String) = responseTime(JsonField.of(responseTime))

            /**
             * Sets [Builder.responseTime] to an arbitrary JSON value.
             *
             * You should usually call [Builder.responseTime] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun responseTime(responseTime: JsonField<String>) = apply {
                this.responseTime = responseTime
            }

            /** The reason for stopping the completion */
            fun stopReason(stopReason: StopReason) = stopReason(JsonField.of(stopReason))

            /**
             * Sets [Builder.stopReason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stopReason] with a well-typed [StopReason] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stopReason(stopReason: JsonField<StopReason>) = apply {
                this.stopReason = stopReason
            }

            /** The total number of tokens */
            fun totalTokenCount(totalTokenCount: Long) =
                totalTokenCount(JsonField.of(totalTokenCount))

            /**
             * Sets [Builder.totalTokenCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalTokenCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalTokenCount(totalTokenCount: JsonField<Long>) = apply {
                this.totalTokenCount = totalTokenCount
            }

            /** The AI agent that is making the request */
            fun agent(agent: String) = agent(JsonField.of(agent))

            /**
             * Sets [Builder.agent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.agent] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun agent(agent: JsonField<String>) = apply { this.agent = agent }

            /**
             * The cost in USD for cache creation tokens in this completion. Typically leave null to
             * let Revenium automatically calculate costs based on the model and provider's caching
             * pricing. Only provide a value if you have custom pricing agreements or want to
             * override Revenium's cost calculation. If provided, this will override Revenium's
             * automatic calculation.
             */
            fun cacheCreationTokenCost(cacheCreationTokenCost: Double) =
                cacheCreationTokenCost(JsonField.of(cacheCreationTokenCost))

            /**
             * Sets [Builder.cacheCreationTokenCost] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cacheCreationTokenCost] with a well-typed [Double]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun cacheCreationTokenCost(cacheCreationTokenCost: JsonField<Double>) = apply {
                this.cacheCreationTokenCost = cacheCreationTokenCost
            }

            /**
             * The number of tokens used to create new cache entries (prompt caching). When you send
             * a long prompt for the first time, the AI provider may cache it for faster subsequent
             * requests. Cache creation tokens are typically billed at a higher rate than regular
             * input tokens. Only include if your provider supports prompt caching (e.g., Anthropic
             * Claude, OpenAI with cache-enabled models). Revenium's middleware will always populate
             * this field automatically. Leave null otherwise.
             */
            fun cacheCreationTokenCount(cacheCreationTokenCount: Long) =
                cacheCreationTokenCount(JsonField.of(cacheCreationTokenCount))

            /**
             * Sets [Builder.cacheCreationTokenCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cacheCreationTokenCount] with a well-typed [Long]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun cacheCreationTokenCount(cacheCreationTokenCount: JsonField<Long>) = apply {
                this.cacheCreationTokenCount = cacheCreationTokenCount
            }

            /**
             * The cost in USD for cache read tokens in this completion. Typically leave null to let
             * Revenium automatically calculate costs based on the model and provider's caching
             * pricing. Only provide a value if you have custom pricing agreements or want to
             * override Revenium's cost calculation. If provided, this will override Revenium's
             * automatic calculation.
             */
            fun cacheReadTokenCost(cacheReadTokenCost: Double) =
                cacheReadTokenCost(JsonField.of(cacheReadTokenCost))

            /**
             * Sets [Builder.cacheReadTokenCost] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cacheReadTokenCost] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cacheReadTokenCost(cacheReadTokenCost: JsonField<Double>) = apply {
                this.cacheReadTokenCost = cacheReadTokenCost
            }

            /**
             * The number of tokens read from cache (prompt caching). When reusing a previously
             * cached prompt, these tokens are read from cache instead of being processed as new
             * input tokens. Cache read tokens are typically billed at a lower rate than regular
             * input tokens. Only include if your provider supports prompt caching and reports cache
             * hits. Revenium's middleware will always populate this field automatically. Leave null
             * otherwise.
             */
            fun cacheReadTokenCount(cacheReadTokenCount: Long) =
                cacheReadTokenCount(JsonField.of(cacheReadTokenCount))

            /**
             * Sets [Builder.cacheReadTokenCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cacheReadTokenCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cacheReadTokenCount(cacheReadTokenCount: JsonField<Long>) = apply {
                this.cacheReadTokenCount = cacheReadTokenCount
            }

            /**
             * Error message or reason if the AI completion failed. Include this field when the AI
             * provider returns an error (e.g., rate limit exceeded, invalid API key, model not
             * found, content policy violation). Used for error rate analytics and debugging. Leave
             * null for successful completions.
             */
            fun errorReason(errorReason: String) = errorReason(JsonField.of(errorReason))

            /**
             * Sets [Builder.errorReason] to an arbitrary JSON value.
             *
             * You should usually call [Builder.errorReason] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun errorReason(errorReason: JsonField<String>) = apply {
                this.errorReason = errorReason
            }

            /**
             * The cost in USD for input tokens in this completion. Typically leave null to let
             * Revenium automatically calculate costs based on the model and provider's current
             * pricing. Only provide a value if you have custom pricing agreements or want to
             * override Revenium's cost calculation. Note: Manual cost override may not be available
             * on all Revenium plans.
             */
            fun inputTokenCost(inputTokenCost: Double) =
                inputTokenCost(JsonField.of(inputTokenCost))

            /**
             * Sets [Builder.inputTokenCost] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputTokenCost] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inputTokenCost(inputTokenCost: JsonField<Double>) = apply {
                this.inputTokenCost = inputTokenCost
            }

            /**
             * The latency in milliseconds introduced by intermediate systems between your
             * application and the AI provider, such as API gateways, proxies, or AI mediation
             * layers. This helps identify performance bottlenecks outside of the AI provider's
             * processing time. Leave null if not using intermediate systems or if latency is not
             * tracked separately.
             */
            fun mediationLatency(mediationLatency: Long) =
                mediationLatency(JsonField.of(mediationLatency))

            /**
             * Sets [Builder.mediationLatency] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mediationLatency] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mediationLatency(mediationLatency: JsonField<Long>) = apply {
                this.mediationLatency = mediationLatency
            }

            /**
             * Identifier of the Revenium middleware package or SDK that captured and submitted this
             * AI completion metadata. This field is AUTOMATICALLY SET by Revenium's middleware
             * packages (e.g., 'revenium-openai-python', 'revenium-anthropic-node'). You typically
             * should NOT manually set this field. It is used for analytics to track which
             * integration methods are being used and for debugging middleware-specific issues.
             */
            fun middlewareSource(middlewareSource: String) =
                middlewareSource(JsonField.of(middlewareSource))

            /**
             * Sets [Builder.middlewareSource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.middlewareSource] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun middlewareSource(middlewareSource: JsonField<String>) = apply {
                this.middlewareSource = middlewareSource
            }

            /**
             * The routing or aggregation layer used to access the AI model. This identifies whether
             * you're calling the AI provider directly or through an intermediary service.
             *
             * Common values: 'DIRECT', 'LITELLM', 'OPENROUTER', 'PORTKEY', 'AZURE_OPENAI', or
             * provider names ('OPENAI', 'ANTHROPIC', 'GOOGLE', etc.) when calling directly.
             *
             * Custom values are accepted for specialized routing layers or gateways. This field is
             * used for integration tracking and analytics.
             */
            fun modelSource(modelSource: String) = modelSource(JsonField.of(modelSource))

            /**
             * Sets [Builder.modelSource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.modelSource] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun modelSource(modelSource: JsonField<String>) = apply {
                this.modelSource = modelSource
            }

            /** The type of operation performed */
            fun operationType(operationType: OperationType) =
                operationType(JsonField.of(operationType))

            /**
             * Sets [Builder.operationType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.operationType] with a well-typed [OperationType]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun operationType(operationType: JsonField<OperationType>) = apply {
                this.operationType = operationType
            }

            /**
             * Populate the ID of the subscriber’s organization from your system to allow Revenium
             * to track usage & costs by company. i.e. AcmeCorp. If several subscriberIds have the
             * same organizationId, Revenium’s reporting will show usage for the entire organization
             * broken down by subscriberId.
             */
            fun organizationId(organizationId: String) =
                organizationId(JsonField.of(organizationId))

            /**
             * Sets [Builder.organizationId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.organizationId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun organizationId(organizationId: JsonField<String>) = apply {
                this.organizationId = organizationId
            }

            /**
             * The cost in USD for output tokens in this completion. Typically leave null to let
             * Revenium automatically calculate costs based on the model and provider's current
             * pricing. Only provide a value if you have custom pricing agreements or want to
             * override Revenium's cost calculation. If provided, this will override Revenium's
             * automatic calculation. Note: Manual cost override may not be available on all
             * Revenium plans.
             */
            fun outputTokenCost(outputTokenCost: Double) =
                outputTokenCost(JsonField.of(outputTokenCost))

            /**
             * Sets [Builder.outputTokenCost] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputTokenCost] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputTokenCost(outputTokenCost: JsonField<Double>) = apply {
                this.outputTokenCost = outputTokenCost
            }

            /**
             * Identifier of the product from your own system that you wish to use to correlate
             * usage between Revenium & your application.
             */
            fun productId(productId: String) = productId(JsonField.of(productId))

            /**
             * Sets [Builder.productId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.productId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun productId(productId: JsonField<String>) = apply { this.productId = productId }

            /**
             * The number of reasoning tokens used in the completion. Reasoning tokens are extended
             * thinking tokens used by AI models for complex problem-solving. These are sometimes
             * billed separately from regular input/output tokens. Only include this field if your
             * AI provider reports reasoning tokens Revenium's middleware will always populate this
             * field if reasoning tokens are reported by the AI provider. Leave null for models
             * without reasoning capabilities.
             */
            fun reasoningTokenCount(reasoningTokenCount: Long) =
                reasoningTokenCount(JsonField.of(reasoningTokenCount))

            /**
             * Sets [Builder.reasoningTokenCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reasoningTokenCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun reasoningTokenCount(reasoningTokenCount: JsonField<Long>) = apply {
                this.reasoningTokenCount = reasoningTokenCount
            }

            /**
             * Optional quality score for the AI response, typically on a 0-100 scale. Set by your
             * application's evaluation logic (e.g., RAGAS, human feedback, custom scoring). Used in
             * Revenium analytics to correlate quality with cost, model choice, and other metrics.
             * Leave null if not tracking quality scores.
             */
            fun responseQualityScore(responseQualityScore: Double) =
                responseQualityScore(JsonField.of(responseQualityScore))

            /**
             * Sets [Builder.responseQualityScore] to an arbitrary JSON value.
             *
             * You should usually call [Builder.responseQualityScore] with a well-typed [Double]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun responseQualityScore(responseQualityScore: JsonField<Double>) = apply {
                this.responseQualityScore = responseQualityScore
            }

            /**
             * Metadata about the subscriber/end-user making this AI request. Include this to track
             * usage by individual users within an organization. Contains user identifiers and
             * associated credential information. Leave null if not tracking individual user-level
             * usage.
             */
            fun subscriber(subscriber: Subscriber) = subscriber(JsonField.of(subscriber))

            /**
             * Sets [Builder.subscriber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subscriber] with a well-typed [Subscriber] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subscriber(subscriber: JsonField<Subscriber>) = apply {
                this.subscriber = subscriber
            }

            /**
             * Unique identifier of the subscription from your own system that you wish to use to
             * correlate usage between Revenium & your application.
             */
            fun subscriptionId(subscriptionId: String) =
                subscriptionId(JsonField.of(subscriptionId))

            /**
             * Sets [Builder.subscriptionId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subscriptionId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subscriptionId(subscriptionId: JsonField<String>) = apply {
                this.subscriptionId = subscriptionId
            }

            /**
             * A unique identifier provided by the AI provider that represents the statistical
             * signature of the language model that generated this completion. This fingerprint can
             * be used for model attribution, debugging, and monitoring model behavior across
             * requests. Automatically provided by some AI providers (e.g., OpenAI) in their API
             * responses. Leave null if your provider does not supply this value.
             */
            fun systemFingerprint(systemFingerprint: String) =
                systemFingerprint(JsonField.of(systemFingerprint))

            /**
             * Sets [Builder.systemFingerprint] to an arbitrary JSON value.
             *
             * You should usually call [Builder.systemFingerprint] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun systemFingerprint(systemFingerprint: JsonField<String>) = apply {
                this.systemFingerprint = systemFingerprint
            }

            /**
             * Optional category to group related AI tasks for cost and performance analysis. Use
             * consistent values to compare metrics across different models or vendors performing
             * the same type of work. Examples: 'chat', 'summarization', 'code-generation',
             * 'translation', 'image-generation', 'embeddings', 'classification',
             * 'sentiment-analysis'. This is freeform text - choose values that match your use
             * cases.
             */
            fun taskType(taskType: String) = taskType(JsonField.of(taskType))

            /**
             * Sets [Builder.taskType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.taskType] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun taskType(taskType: JsonField<String>) = apply { this.taskType = taskType }

            /**
             * The temperature parameter used for this completion, controlling randomness in the
             * AI's output. Typically ranges from 0.0 (deterministic) to 2.0 (very random). Track
             * this to correlate temperature settings with response quality, cost, or other metrics.
             * Useful for A/B testing different temperature values.
             */
            fun temperature(temperature: Double) = temperature(JsonField.of(temperature))

            /**
             * Sets [Builder.temperature] to an arbitrary JSON value.
             *
             * You should usually call [Builder.temperature] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun temperature(temperature: JsonField<Double>) = apply {
                this.temperature = temperature
            }

            /**
             * The latency in milliseconds from request start to first token received. Calculated as
             * (completionStartTime - requestTime). This metric is particularly important for
             * streaming completions to measure perceived responsiveness. For non-streaming
             * completions, this may be null or equal to requestDuration.
             */
            fun timeToFirstToken(timeToFirstToken: Long) =
                timeToFirstToken(JsonField.of(timeToFirstToken))

            /**
             * Sets [Builder.timeToFirstToken] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timeToFirstToken] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timeToFirstToken(timeToFirstToken: JsonField<Long>) = apply {
                this.timeToFirstToken = timeToFirstToken
            }

            /**
             * The total cost in USD for this completion (sum of all token costs). Typically leave
             * null to let Revenium automatically calculate the total based on token counts and
             * current pricing. Only provide a value if you have custom pricing agreements or want
             * to override Revenium's cost calculation. If provided, this will override Revenium's
             * automatic calculation.
             */
            fun totalCost(totalCost: Double) = totalCost(JsonField.of(totalCost))

            /**
             * Sets [Builder.totalCost] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalCost] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalCost(totalCost: JsonField<Double>) = apply { this.totalCost = totalCost }

            /**
             * Optional trace identifier to group multiple related AI completion calls that belong
             * to the same overall user request or workflow. For example, if a single user query
             * triggers multiple LLM calls (e.g., retrieval + generation), use the same traceId for
             * all calls to analyze them together in Revenium's analytics. Leave null for standalone
             * completions.
             */
            fun traceId(traceId: String) = traceId(JsonField.of(traceId))

            /**
             * Sets [Builder.traceId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.traceId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun traceId(traceId: JsonField<String>) = apply { this.traceId = traceId }

            /**
             * Unique identifier for this specific AI completion transaction. Used for
             * deduplication, correlation with request/response pairs, and transaction lookup in
             * Revenium analytics. If not provided, a UUID will be auto-generated. For best
             * practices, generate a UUID in your application before making the AI call and use the
             * same ID when submitting to Revenium.
             */
            fun transactionId(transactionId: String) = transactionId(JsonField.of(transactionId))

            /**
             * Sets [Builder.transactionId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.transactionId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun transactionId(transactionId: JsonField<String>) = apply {
                this.transactionId = transactionId
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .completionStartTime()
             * .costType()
             * .inputTokenCount()
             * .isStreamed()
             * .model()
             * .outputTokenCount()
             * .provider()
             * .requestDuration()
             * .requestTime()
             * .responseTime()
             * .stopReason()
             * .totalTokenCount()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("completionStartTime", completionStartTime),
                    checkRequired("costType", costType),
                    checkRequired("inputTokenCount", inputTokenCount),
                    checkRequired("isStreamed", isStreamed),
                    checkRequired("model", model),
                    checkRequired("outputTokenCount", outputTokenCount),
                    checkRequired("provider", provider),
                    checkRequired("requestDuration", requestDuration),
                    checkRequired("requestTime", requestTime),
                    checkRequired("responseTime", responseTime),
                    checkRequired("stopReason", stopReason),
                    checkRequired("totalTokenCount", totalTokenCount),
                    agent,
                    cacheCreationTokenCost,
                    cacheCreationTokenCount,
                    cacheReadTokenCost,
                    cacheReadTokenCount,
                    errorReason,
                    inputTokenCost,
                    mediationLatency,
                    middlewareSource,
                    modelSource,
                    operationType,
                    organizationId,
                    outputTokenCost,
                    productId,
                    reasoningTokenCount,
                    responseQualityScore,
                    subscriber,
                    subscriptionId,
                    systemFingerprint,
                    taskType,
                    temperature,
                    timeToFirstToken,
                    totalCost,
                    traceId,
                    transactionId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            completionStartTime()
            costType().validate()
            inputTokenCount()
            isStreamed()
            model()
            outputTokenCount()
            provider()
            requestDuration()
            requestTime()
            responseTime()
            stopReason().validate()
            totalTokenCount()
            agent()
            cacheCreationTokenCost()
            cacheCreationTokenCount()
            cacheReadTokenCost()
            cacheReadTokenCount()
            errorReason()
            inputTokenCost()
            mediationLatency()
            middlewareSource()
            modelSource()
            operationType().ifPresent { it.validate() }
            organizationId()
            outputTokenCost()
            productId()
            reasoningTokenCount()
            responseQualityScore()
            subscriber().ifPresent { it.validate() }
            subscriptionId()
            systemFingerprint()
            taskType()
            temperature()
            timeToFirstToken()
            totalCost()
            traceId()
            transactionId()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ReveniumMeteringInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (completionStartTime.asKnown().isPresent) 1 else 0) +
                (costType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (inputTokenCount.asKnown().isPresent) 1 else 0) +
                (if (isStreamed.asKnown().isPresent) 1 else 0) +
                (if (model.asKnown().isPresent) 1 else 0) +
                (if (outputTokenCount.asKnown().isPresent) 1 else 0) +
                (if (provider.asKnown().isPresent) 1 else 0) +
                (if (requestDuration.asKnown().isPresent) 1 else 0) +
                (if (requestTime.asKnown().isPresent) 1 else 0) +
                (if (responseTime.asKnown().isPresent) 1 else 0) +
                (stopReason.asKnown().getOrNull()?.validity() ?: 0) +
                (if (totalTokenCount.asKnown().isPresent) 1 else 0) +
                (if (agent.asKnown().isPresent) 1 else 0) +
                (if (cacheCreationTokenCost.asKnown().isPresent) 1 else 0) +
                (if (cacheCreationTokenCount.asKnown().isPresent) 1 else 0) +
                (if (cacheReadTokenCost.asKnown().isPresent) 1 else 0) +
                (if (cacheReadTokenCount.asKnown().isPresent) 1 else 0) +
                (if (errorReason.asKnown().isPresent) 1 else 0) +
                (if (inputTokenCost.asKnown().isPresent) 1 else 0) +
                (if (mediationLatency.asKnown().isPresent) 1 else 0) +
                (if (middlewareSource.asKnown().isPresent) 1 else 0) +
                (if (modelSource.asKnown().isPresent) 1 else 0) +
                (operationType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (organizationId.asKnown().isPresent) 1 else 0) +
                (if (outputTokenCost.asKnown().isPresent) 1 else 0) +
                (if (productId.asKnown().isPresent) 1 else 0) +
                (if (reasoningTokenCount.asKnown().isPresent) 1 else 0) +
                (if (responseQualityScore.asKnown().isPresent) 1 else 0) +
                (subscriber.asKnown().getOrNull()?.validity() ?: 0) +
                (if (subscriptionId.asKnown().isPresent) 1 else 0) +
                (if (systemFingerprint.asKnown().isPresent) 1 else 0) +
                (if (taskType.asKnown().isPresent) 1 else 0) +
                (if (temperature.asKnown().isPresent) 1 else 0) +
                (if (timeToFirstToken.asKnown().isPresent) 1 else 0) +
                (if (totalCost.asKnown().isPresent) 1 else 0) +
                (if (traceId.asKnown().isPresent) 1 else 0) +
                (if (transactionId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                completionStartTime == other.completionStartTime &&
                costType == other.costType &&
                inputTokenCount == other.inputTokenCount &&
                isStreamed == other.isStreamed &&
                model == other.model &&
                outputTokenCount == other.outputTokenCount &&
                provider == other.provider &&
                requestDuration == other.requestDuration &&
                requestTime == other.requestTime &&
                responseTime == other.responseTime &&
                stopReason == other.stopReason &&
                totalTokenCount == other.totalTokenCount &&
                agent == other.agent &&
                cacheCreationTokenCost == other.cacheCreationTokenCost &&
                cacheCreationTokenCount == other.cacheCreationTokenCount &&
                cacheReadTokenCost == other.cacheReadTokenCost &&
                cacheReadTokenCount == other.cacheReadTokenCount &&
                errorReason == other.errorReason &&
                inputTokenCost == other.inputTokenCost &&
                mediationLatency == other.mediationLatency &&
                middlewareSource == other.middlewareSource &&
                modelSource == other.modelSource &&
                operationType == other.operationType &&
                organizationId == other.organizationId &&
                outputTokenCost == other.outputTokenCost &&
                productId == other.productId &&
                reasoningTokenCount == other.reasoningTokenCount &&
                responseQualityScore == other.responseQualityScore &&
                subscriber == other.subscriber &&
                subscriptionId == other.subscriptionId &&
                systemFingerprint == other.systemFingerprint &&
                taskType == other.taskType &&
                temperature == other.temperature &&
                timeToFirstToken == other.timeToFirstToken &&
                totalCost == other.totalCost &&
                traceId == other.traceId &&
                transactionId == other.transactionId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                completionStartTime,
                costType,
                inputTokenCount,
                isStreamed,
                model,
                outputTokenCount,
                provider,
                requestDuration,
                requestTime,
                responseTime,
                stopReason,
                totalTokenCount,
                agent,
                cacheCreationTokenCost,
                cacheCreationTokenCount,
                cacheReadTokenCost,
                cacheReadTokenCount,
                errorReason,
                inputTokenCost,
                mediationLatency,
                middlewareSource,
                modelSource,
                operationType,
                organizationId,
                outputTokenCost,
                productId,
                reasoningTokenCount,
                responseQualityScore,
                subscriber,
                subscriptionId,
                systemFingerprint,
                taskType,
                temperature,
                timeToFirstToken,
                totalCost,
                traceId,
                transactionId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{completionStartTime=$completionStartTime, costType=$costType, inputTokenCount=$inputTokenCount, isStreamed=$isStreamed, model=$model, outputTokenCount=$outputTokenCount, provider=$provider, requestDuration=$requestDuration, requestTime=$requestTime, responseTime=$responseTime, stopReason=$stopReason, totalTokenCount=$totalTokenCount, agent=$agent, cacheCreationTokenCost=$cacheCreationTokenCost, cacheCreationTokenCount=$cacheCreationTokenCount, cacheReadTokenCost=$cacheReadTokenCost, cacheReadTokenCount=$cacheReadTokenCount, errorReason=$errorReason, inputTokenCost=$inputTokenCost, mediationLatency=$mediationLatency, middlewareSource=$middlewareSource, modelSource=$modelSource, operationType=$operationType, organizationId=$organizationId, outputTokenCost=$outputTokenCost, productId=$productId, reasoningTokenCount=$reasoningTokenCount, responseQualityScore=$responseQualityScore, subscriber=$subscriber, subscriptionId=$subscriptionId, systemFingerprint=$systemFingerprint, taskType=$taskType, temperature=$temperature, timeToFirstToken=$timeToFirstToken, totalCost=$totalCost, traceId=$traceId, transactionId=$transactionId, additionalProperties=$additionalProperties}"
    }

    /**
     * The type of cost being tracked. Currently always 'AI' for AI completion costs. This field is
     * used internally by Revenium to categorize different types of metered usage. You typically do
     * not need to set this field as it defaults to 'AI'.
     */
    class CostType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val AI = of("AI")

            @JvmStatic fun of(value: String) = CostType(JsonField.of(value))
        }

        /** An enum containing [CostType]'s known values. */
        enum class Known {
            AI
        }

        /**
         * An enum containing [CostType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [CostType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            AI,
            /** An enum member indicating that [CostType] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                AI -> Value.AI
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ReveniumMeteringInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                AI -> Known.AI
                else -> throw ReveniumMeteringInvalidDataException("Unknown CostType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ReveniumMeteringInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                ReveniumMeteringInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): CostType = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ReveniumMeteringInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CostType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The reason for stopping the completion */
    class StopReason @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val END = of("END")

            @JvmField val END_SEQUENCE = of("END_SEQUENCE")

            @JvmField val TIMEOUT = of("TIMEOUT")

            @JvmField val TOKEN_LIMIT = of("TOKEN_LIMIT")

            @JvmField val COST_LIMIT = of("COST_LIMIT")

            @JvmField val COMPLETION_LIMIT = of("COMPLETION_LIMIT")

            @JvmField val ERROR = of("ERROR")

            @JvmField val CANCELLED = of("CANCELLED")

            @JvmStatic fun of(value: String) = StopReason(JsonField.of(value))
        }

        /** An enum containing [StopReason]'s known values. */
        enum class Known {
            END,
            END_SEQUENCE,
            TIMEOUT,
            TOKEN_LIMIT,
            COST_LIMIT,
            COMPLETION_LIMIT,
            ERROR,
            CANCELLED,
        }

        /**
         * An enum containing [StopReason]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [StopReason] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            END,
            END_SEQUENCE,
            TIMEOUT,
            TOKEN_LIMIT,
            COST_LIMIT,
            COMPLETION_LIMIT,
            ERROR,
            CANCELLED,
            /**
             * An enum member indicating that [StopReason] was instantiated with an unknown value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                END -> Value.END
                END_SEQUENCE -> Value.END_SEQUENCE
                TIMEOUT -> Value.TIMEOUT
                TOKEN_LIMIT -> Value.TOKEN_LIMIT
                COST_LIMIT -> Value.COST_LIMIT
                COMPLETION_LIMIT -> Value.COMPLETION_LIMIT
                ERROR -> Value.ERROR
                CANCELLED -> Value.CANCELLED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ReveniumMeteringInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                END -> Known.END
                END_SEQUENCE -> Known.END_SEQUENCE
                TIMEOUT -> Known.TIMEOUT
                TOKEN_LIMIT -> Known.TOKEN_LIMIT
                COST_LIMIT -> Known.COST_LIMIT
                COMPLETION_LIMIT -> Known.COMPLETION_LIMIT
                ERROR -> Known.ERROR
                CANCELLED -> Known.CANCELLED
                else -> throw ReveniumMeteringInvalidDataException("Unknown StopReason: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ReveniumMeteringInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                ReveniumMeteringInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): StopReason = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ReveniumMeteringInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is StopReason && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The type of operation performed */
    class OperationType @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val CHAT = of("CHAT")

            @JvmField val GENERATE = of("GENERATE")

            @JvmField val EMBED = of("EMBED")

            @JvmField val CLASSIFY = of("CLASSIFY")

            @JvmField val SUMMARIZE = of("SUMMARIZE")

            @JvmField val TRANSLATE = of("TRANSLATE")

            @JvmField val OTHER = of("OTHER")

            @JvmStatic fun of(value: String) = OperationType(JsonField.of(value))
        }

        /** An enum containing [OperationType]'s known values. */
        enum class Known {
            CHAT,
            GENERATE,
            EMBED,
            CLASSIFY,
            SUMMARIZE,
            TRANSLATE,
            OTHER,
        }

        /**
         * An enum containing [OperationType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [OperationType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CHAT,
            GENERATE,
            EMBED,
            CLASSIFY,
            SUMMARIZE,
            TRANSLATE,
            OTHER,
            /**
             * An enum member indicating that [OperationType] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                CHAT -> Value.CHAT
                GENERATE -> Value.GENERATE
                EMBED -> Value.EMBED
                CLASSIFY -> Value.CLASSIFY
                SUMMARIZE -> Value.SUMMARIZE
                TRANSLATE -> Value.TRANSLATE
                OTHER -> Value.OTHER
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws ReveniumMeteringInvalidDataException if this class instance's value is a not a
         *   known member.
         */
        fun known(): Known =
            when (this) {
                CHAT -> Known.CHAT
                GENERATE -> Known.GENERATE
                EMBED -> Known.EMBED
                CLASSIFY -> Known.CLASSIFY
                SUMMARIZE -> Known.SUMMARIZE
                TRANSLATE -> Known.TRANSLATE
                OTHER -> Known.OTHER
                else -> throw ReveniumMeteringInvalidDataException("Unknown OperationType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws ReveniumMeteringInvalidDataException if this class instance's value does not have
         *   the expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                ReveniumMeteringInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): OperationType = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ReveniumMeteringInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OperationType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Metadata about the subscriber/end-user making this AI request. Include this to track usage by
     * individual users within an organization. Contains user identifiers and associated credential
     * information. Leave null if not tracking individual user-level usage.
     */
    class Subscriber
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val credential: JsonField<Credential>,
        private val email: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("credential")
            @ExcludeMissing
            credential: JsonField<Credential> = JsonMissing.of(),
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        ) : this(id, credential, email, mutableMapOf())

        /**
         * Track cost & performance by individual users (if customers are anonymous or tracking by
         * emails is not desired). If several subscriberIds are submitted with the same
         * organizationId, Revenium’s reporting will show usage for the entire organization broken
         * down by subscriberId.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The credential used by the subscriber
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun credential(): Optional<Credential> = credential.getOptional("credential")

        /**
         * The email address of the subscriber. Used to track cost & performance by individual users
         * if customer e-mail addresses are known.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun email(): Optional<String> = email.getOptional("email")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [credential].
         *
         * Unlike [credential], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("credential")
        @ExcludeMissing
        fun _credential(): JsonField<Credential> = credential

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Subscriber]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Subscriber]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var credential: JsonField<Credential> = JsonMissing.of()
            private var email: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(subscriber: Subscriber) = apply {
                id = subscriber.id
                credential = subscriber.credential
                email = subscriber.email
                additionalProperties = subscriber.additionalProperties.toMutableMap()
            }

            /**
             * Track cost & performance by individual users (if customers are anonymous or tracking
             * by emails is not desired). If several subscriberIds are submitted with the same
             * organizationId, Revenium’s reporting will show usage for the entire organization
             * broken down by subscriberId.
             */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The credential used by the subscriber */
            fun credential(credential: Credential) = credential(JsonField.of(credential))

            /**
             * Sets [Builder.credential] to an arbitrary JSON value.
             *
             * You should usually call [Builder.credential] with a well-typed [Credential] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun credential(credential: JsonField<Credential>) = apply {
                this.credential = credential
            }

            /**
             * The email address of the subscriber. Used to track cost & performance by individual
             * users if customer e-mail addresses are known.
             */
            fun email(email: String) = email(JsonField.of(email))

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Subscriber].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Subscriber =
                Subscriber(id, credential, email, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Subscriber = apply {
            if (validated) {
                return@apply
            }

            id()
            credential().ifPresent { it.validate() }
            email()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: ReveniumMeteringInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (id.asKnown().isPresent) 1 else 0) +
                (credential.asKnown().getOrNull()?.validity() ?: 0) +
                (if (email.asKnown().isPresent) 1 else 0)

        /** The credential used by the subscriber */
        class Credential
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val name: JsonField<String>,
            private val value: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("value") @ExcludeMissing value: JsonField<String> = JsonMissing.of(),
            ) : this(name, value, mutableMapOf())

            /**
             * An alias for an API key used by one or more users. Used to track cost & performance
             * by individual API keys.
             *
             * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * The key value associated with the subscriber (most commonly an API key). Used to
             * track cost & performance by API key value (normally used when the only identifier for
             * a user is an API key).
             *
             * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
             *   (e.g. if the server responded with an unexpected value).
             */
            fun value(): Optional<String> = value.getOptional("value")

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [value].
             *
             * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<String> = value

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Credential]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Credential]. */
            class Builder internal constructor() {

                private var name: JsonField<String> = JsonMissing.of()
                private var value: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(credential: Credential) = apply {
                    name = credential.name
                    value = credential.value
                    additionalProperties = credential.additionalProperties.toMutableMap()
                }

                /**
                 * An alias for an API key used by one or more users. Used to track cost &
                 * performance by individual API keys.
                 */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * The key value associated with the subscriber (most commonly an API key). Used to
                 * track cost & performance by API key value (normally used when the only identifier
                 * for a user is an API key).
                 */
                fun value(value: String) = value(JsonField.of(value))

                /**
                 * Sets [Builder.value] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.value] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun value(value: JsonField<String>) = apply { this.value = value }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Credential].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Credential =
                    Credential(name, value, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Credential = apply {
                if (validated) {
                    return@apply
                }

                name()
                value()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: ReveniumMeteringInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (name.asKnown().isPresent) 1 else 0) + (if (value.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Credential &&
                    name == other.name &&
                    value == other.value &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(name, value, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Credential{name=$name, value=$value, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Subscriber &&
                id == other.id &&
                credential == other.credential &&
                email == other.email &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, credential, email, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Subscriber{id=$id, credential=$credential, email=$email, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AiCreateCompletionParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "AiCreateCompletionParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
