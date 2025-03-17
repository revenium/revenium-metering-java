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
import com.revenium_metering.api.core.NoAutoDetect
import com.revenium_metering.api.core.Params
import com.revenium_metering.api.core.checkRequired
import com.revenium_metering.api.core.http.Headers
import com.revenium_metering.api.core.http.QueryParams
import com.revenium_metering.api.core.immutableEmptyMap
import com.revenium_metering.api.core.toImmutable
import com.revenium_metering.api.errors.ReveniumMeteringInvalidDataException
import java.util.Objects
import java.util.Optional

/** Record the details of an LLM completion */
class AiCreateCompletionParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The number of audio tokens in the completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun audioTokenCount(): Long = body.audioTokenCount()

    /**
     * The number of cached tokens in the completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun cachedTokenCount(): Long = body.cachedTokenCount()

    /**
     * Time to first token for streaming requests
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun completionStartTime(): String = body.completionStartTime()

    /**
     * The number of tokens in the completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun completionTokenCount(): Long = body.completionTokenCount()

    /**
     * Cost type for the completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun costType(): CostType = body.costType()

    /**
     * The input token cost associated with the LLM completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun inputTokenCost(): Double = body.inputTokenCost()

    /**
     * The model used for generating the LLM completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun model(): String = body.model()

    /**
     * The output token cost associated with the LLM completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun outputTokenCost(): Double = body.outputTokenCost()

    /**
     * The number of tokens in the prompt
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun promptTokenCount(): Long = body.promptTokenCount()

    /**
     * Vendor providing the LLM completion service
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun provider(): String = body.provider()

    /**
     * The number of reasoning tokens in the completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun reasoningTokenCount(): Long = body.reasoningTokenCount()

    /**
     * The duration of the request in milliseconds
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun requestDuration(): Long = body.requestDuration()

    /**
     * The timestamp when the request was made
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun requestTime(): String = body.requestTime()

    /**
     * The timestamp when the response was generated. If streaming, this is the time to first token
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
     * The total cost associated with the LLM completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun totalCost(): Double = body.totalCost()

    /**
     * The total number of tokens
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun totalTokenCount(): Long = body.totalTokenCount()

    /**
     * The unique identifier of the LLM completion transaction
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transactionId(): String = body.transactionId()

    /**
     * The AI agent that is making the request
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun agent(): Optional<String> = body.agent()

    /**
     * The name (not the value!) of the API key used to access the AI provider
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun aiProviderKeyName(): Optional<String> = body.aiProviderKeyName()

    /**
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun apiKey(): Optional<String> = body.apiKey()

    /**
     * Populate the ID of the subscriber’s organization from your system to allow Revenium to track
     * usage & costs by company. i.e. AcmeCorp. If several subscriberIds have the same
     * organizationId, Revenium’s reporting will show usage for the entire organization broken down
     * by user.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun organizationId(): Optional<String> = body.organizationId()

    /**
     * Identifier of the product from your own system that you wish to use to correlate usage
     * between Revenium & your application.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun productId(): Optional<String> = body.productId()

    /**
     * Identifier of the source to correlate usage between Revenium & your application.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun sourceId(): Optional<String> = body.sourceId()

    /**
     * Populate the ID of the subscriber from your system to allow Revenium to track usage & costs
     * for individual users. Oftentimes a subscriberId is an email address.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun subscriberIdentity(): Optional<String> = body.subscriberIdentity()

    /**
     * Unique identifier of the subscription from your own system that you wish to use to correlate
     * usage between Revenium & your application.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun subscriptionId(): Optional<String> = body.subscriptionId()

    /**
     * Identifier of the associated task. If you wish to track the costs and performance for a task
     * that occurs over several prompts, use a consistent task ID for all prompts included in that
     * task.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun taskId(): Optional<String> = body.taskId()

    /**
     * If you wish to track the costs or performance of a specific task and compare the values over
     * time or compare the performance across AI models or vendors, use a consistent taskType for
     * all related tasks.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun taskType(): Optional<String> = body.taskType()

    /**
     * Trace multiple LLM calls belonging to same overall request
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun traceId(): Optional<String> = body.traceId()

    /**
     * Returns the raw JSON value of [audioTokenCount].
     *
     * Unlike [audioTokenCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _audioTokenCount(): JsonField<Long> = body._audioTokenCount()

    /**
     * Returns the raw JSON value of [cachedTokenCount].
     *
     * Unlike [cachedTokenCount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _cachedTokenCount(): JsonField<Long> = body._cachedTokenCount()

    /**
     * Returns the raw JSON value of [completionStartTime].
     *
     * Unlike [completionStartTime], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _completionStartTime(): JsonField<String> = body._completionStartTime()

    /**
     * Returns the raw JSON value of [completionTokenCount].
     *
     * Unlike [completionTokenCount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _completionTokenCount(): JsonField<Long> = body._completionTokenCount()

    /**
     * Returns the raw JSON value of [costType].
     *
     * Unlike [costType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _costType(): JsonField<CostType> = body._costType()

    /**
     * Returns the raw JSON value of [inputTokenCost].
     *
     * Unlike [inputTokenCost], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _inputTokenCost(): JsonField<Double> = body._inputTokenCost()

    /**
     * Returns the raw JSON value of [model].
     *
     * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _model(): JsonField<String> = body._model()

    /**
     * Returns the raw JSON value of [outputTokenCost].
     *
     * Unlike [outputTokenCost], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _outputTokenCost(): JsonField<Double> = body._outputTokenCost()

    /**
     * Returns the raw JSON value of [promptTokenCount].
     *
     * Unlike [promptTokenCount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _promptTokenCount(): JsonField<Long> = body._promptTokenCount()

    /**
     * Returns the raw JSON value of [provider].
     *
     * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _provider(): JsonField<String> = body._provider()

    /**
     * Returns the raw JSON value of [reasoningTokenCount].
     *
     * Unlike [reasoningTokenCount], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _reasoningTokenCount(): JsonField<Long> = body._reasoningTokenCount()

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
     * Returns the raw JSON value of [totalCost].
     *
     * Unlike [totalCost], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _totalCost(): JsonField<Double> = body._totalCost()

    /**
     * Returns the raw JSON value of [totalTokenCount].
     *
     * Unlike [totalTokenCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _totalTokenCount(): JsonField<Long> = body._totalTokenCount()

    /**
     * Returns the raw JSON value of [transactionId].
     *
     * Unlike [transactionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _transactionId(): JsonField<String> = body._transactionId()

    /**
     * Returns the raw JSON value of [agent].
     *
     * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _agent(): JsonField<String> = body._agent()

    /**
     * Returns the raw JSON value of [aiProviderKeyName].
     *
     * Unlike [aiProviderKeyName], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _aiProviderKeyName(): JsonField<String> = body._aiProviderKeyName()

    /**
     * Returns the raw JSON value of [apiKey].
     *
     * Unlike [apiKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _apiKey(): JsonField<String> = body._apiKey()

    /**
     * Returns the raw JSON value of [organizationId].
     *
     * Unlike [organizationId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _organizationId(): JsonField<String> = body._organizationId()

    /**
     * Returns the raw JSON value of [productId].
     *
     * Unlike [productId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _productId(): JsonField<String> = body._productId()

    /**
     * Returns the raw JSON value of [sourceId].
     *
     * Unlike [sourceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sourceId(): JsonField<String> = body._sourceId()

    /**
     * Returns the raw JSON value of [subscriberIdentity].
     *
     * Unlike [subscriberIdentity], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _subscriberIdentity(): JsonField<String> = body._subscriberIdentity()

    /**
     * Returns the raw JSON value of [subscriptionId].
     *
     * Unlike [subscriptionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _subscriptionId(): JsonField<String> = body._subscriptionId()

    /**
     * Returns the raw JSON value of [taskId].
     *
     * Unlike [taskId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _taskId(): JsonField<String> = body._taskId()

    /**
     * Returns the raw JSON value of [taskType].
     *
     * Unlike [taskType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _taskType(): JsonField<String> = body._taskType()

    /**
     * Returns the raw JSON value of [traceId].
     *
     * Unlike [traceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _traceId(): JsonField<String> = body._traceId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** The AI completion metadata */
    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("audioTokenCount")
        @ExcludeMissing
        private val audioTokenCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("cachedTokenCount")
        @ExcludeMissing
        private val cachedTokenCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("completionStartTime")
        @ExcludeMissing
        private val completionStartTime: JsonField<String> = JsonMissing.of(),
        @JsonProperty("completionTokenCount")
        @ExcludeMissing
        private val completionTokenCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("costType")
        @ExcludeMissing
        private val costType: JsonField<CostType> = JsonMissing.of(),
        @JsonProperty("inputTokenCost")
        @ExcludeMissing
        private val inputTokenCost: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("model")
        @ExcludeMissing
        private val model: JsonField<String> = JsonMissing.of(),
        @JsonProperty("outputTokenCost")
        @ExcludeMissing
        private val outputTokenCost: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("promptTokenCount")
        @ExcludeMissing
        private val promptTokenCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("provider")
        @ExcludeMissing
        private val provider: JsonField<String> = JsonMissing.of(),
        @JsonProperty("reasoningTokenCount")
        @ExcludeMissing
        private val reasoningTokenCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("requestDuration")
        @ExcludeMissing
        private val requestDuration: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("requestTime")
        @ExcludeMissing
        private val requestTime: JsonField<String> = JsonMissing.of(),
        @JsonProperty("responseTime")
        @ExcludeMissing
        private val responseTime: JsonField<String> = JsonMissing.of(),
        @JsonProperty("stopReason")
        @ExcludeMissing
        private val stopReason: JsonField<StopReason> = JsonMissing.of(),
        @JsonProperty("totalCost")
        @ExcludeMissing
        private val totalCost: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("totalTokenCount")
        @ExcludeMissing
        private val totalTokenCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("transactionId")
        @ExcludeMissing
        private val transactionId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("agent")
        @ExcludeMissing
        private val agent: JsonField<String> = JsonMissing.of(),
        @JsonProperty("aiProviderKeyName")
        @ExcludeMissing
        private val aiProviderKeyName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("apiKey")
        @ExcludeMissing
        private val apiKey: JsonField<String> = JsonMissing.of(),
        @JsonProperty("organizationId")
        @ExcludeMissing
        private val organizationId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("productId")
        @ExcludeMissing
        private val productId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("sourceId")
        @ExcludeMissing
        private val sourceId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("subscriberIdentity")
        @ExcludeMissing
        private val subscriberIdentity: JsonField<String> = JsonMissing.of(),
        @JsonProperty("subscriptionId")
        @ExcludeMissing
        private val subscriptionId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("taskId")
        @ExcludeMissing
        private val taskId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("taskType")
        @ExcludeMissing
        private val taskType: JsonField<String> = JsonMissing.of(),
        @JsonProperty("traceId")
        @ExcludeMissing
        private val traceId: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * The number of audio tokens in the completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun audioTokenCount(): Long = audioTokenCount.getRequired("audioTokenCount")

        /**
         * The number of cached tokens in the completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun cachedTokenCount(): Long = cachedTokenCount.getRequired("cachedTokenCount")

        /**
         * Time to first token for streaming requests
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun completionStartTime(): String = completionStartTime.getRequired("completionStartTime")

        /**
         * The number of tokens in the completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun completionTokenCount(): Long = completionTokenCount.getRequired("completionTokenCount")

        /**
         * Cost type for the completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun costType(): CostType = costType.getRequired("costType")

        /**
         * The input token cost associated with the LLM completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun inputTokenCost(): Double = inputTokenCost.getRequired("inputTokenCost")

        /**
         * The model used for generating the LLM completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun model(): String = model.getRequired("model")

        /**
         * The output token cost associated with the LLM completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun outputTokenCost(): Double = outputTokenCost.getRequired("outputTokenCost")

        /**
         * The number of tokens in the prompt
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun promptTokenCount(): Long = promptTokenCount.getRequired("promptTokenCount")

        /**
         * Vendor providing the LLM completion service
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun provider(): String = provider.getRequired("provider")

        /**
         * The number of reasoning tokens in the completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun reasoningTokenCount(): Long = reasoningTokenCount.getRequired("reasoningTokenCount")

        /**
         * The duration of the request in milliseconds
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun requestDuration(): Long = requestDuration.getRequired("requestDuration")

        /**
         * The timestamp when the request was made
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun requestTime(): String = requestTime.getRequired("requestTime")

        /**
         * The timestamp when the response was generated. If streaming, this is the time to first
         * token
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
         * The total cost associated with the LLM completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun totalCost(): Double = totalCost.getRequired("totalCost")

        /**
         * The total number of tokens
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun totalTokenCount(): Long = totalTokenCount.getRequired("totalTokenCount")

        /**
         * The unique identifier of the LLM completion transaction
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun transactionId(): String = transactionId.getRequired("transactionId")

        /**
         * The AI agent that is making the request
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun agent(): Optional<String> = Optional.ofNullable(agent.getNullable("agent"))

        /**
         * The name (not the value!) of the API key used to access the AI provider
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun aiProviderKeyName(): Optional<String> =
            Optional.ofNullable(aiProviderKeyName.getNullable("aiProviderKeyName"))

        /**
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun apiKey(): Optional<String> = Optional.ofNullable(apiKey.getNullable("apiKey"))

        /**
         * Populate the ID of the subscriber’s organization from your system to allow Revenium to
         * track usage & costs by company. i.e. AcmeCorp. If several subscriberIds have the same
         * organizationId, Revenium’s reporting will show usage for the entire organization broken
         * down by user.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun organizationId(): Optional<String> =
            Optional.ofNullable(organizationId.getNullable("organizationId"))

        /**
         * Identifier of the product from your own system that you wish to use to correlate usage
         * between Revenium & your application.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun productId(): Optional<String> = Optional.ofNullable(productId.getNullable("productId"))

        /**
         * Identifier of the source to correlate usage between Revenium & your application.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun sourceId(): Optional<String> = Optional.ofNullable(sourceId.getNullable("sourceId"))

        /**
         * Populate the ID of the subscriber from your system to allow Revenium to track usage &
         * costs for individual users. Oftentimes a subscriberId is an email address.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun subscriberIdentity(): Optional<String> =
            Optional.ofNullable(subscriberIdentity.getNullable("subscriberIdentity"))

        /**
         * Unique identifier of the subscription from your own system that you wish to use to
         * correlate usage between Revenium & your application.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun subscriptionId(): Optional<String> =
            Optional.ofNullable(subscriptionId.getNullable("subscriptionId"))

        /**
         * Identifier of the associated task. If you wish to track the costs and performance for a
         * task that occurs over several prompts, use a consistent task ID for all prompts included
         * in that task.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun taskId(): Optional<String> = Optional.ofNullable(taskId.getNullable("taskId"))

        /**
         * If you wish to track the costs or performance of a specific task and compare the values
         * over time or compare the performance across AI models or vendors, use a consistent
         * taskType for all related tasks.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun taskType(): Optional<String> = Optional.ofNullable(taskType.getNullable("taskType"))

        /**
         * Trace multiple LLM calls belonging to same overall request
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun traceId(): Optional<String> = Optional.ofNullable(traceId.getNullable("traceId"))

        /**
         * Returns the raw JSON value of [audioTokenCount].
         *
         * Unlike [audioTokenCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("audioTokenCount")
        @ExcludeMissing
        fun _audioTokenCount(): JsonField<Long> = audioTokenCount

        /**
         * Returns the raw JSON value of [cachedTokenCount].
         *
         * Unlike [cachedTokenCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cachedTokenCount")
        @ExcludeMissing
        fun _cachedTokenCount(): JsonField<Long> = cachedTokenCount

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
         * Returns the raw JSON value of [completionTokenCount].
         *
         * Unlike [completionTokenCount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("completionTokenCount")
        @ExcludeMissing
        fun _completionTokenCount(): JsonField<Long> = completionTokenCount

        /**
         * Returns the raw JSON value of [costType].
         *
         * Unlike [costType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("costType") @ExcludeMissing fun _costType(): JsonField<CostType> = costType

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
         * Returns the raw JSON value of [model].
         *
         * Unlike [model], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("model") @ExcludeMissing fun _model(): JsonField<String> = model

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
         * Returns the raw JSON value of [promptTokenCount].
         *
         * Unlike [promptTokenCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("promptTokenCount")
        @ExcludeMissing
        fun _promptTokenCount(): JsonField<Long> = promptTokenCount

        /**
         * Returns the raw JSON value of [provider].
         *
         * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("provider") @ExcludeMissing fun _provider(): JsonField<String> = provider

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
         * Returns the raw JSON value of [totalCost].
         *
         * Unlike [totalCost], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("totalCost") @ExcludeMissing fun _totalCost(): JsonField<Double> = totalCost

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
         * Returns the raw JSON value of [transactionId].
         *
         * Unlike [transactionId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("transactionId")
        @ExcludeMissing
        fun _transactionId(): JsonField<String> = transactionId

        /**
         * Returns the raw JSON value of [agent].
         *
         * Unlike [agent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("agent") @ExcludeMissing fun _agent(): JsonField<String> = agent

        /**
         * Returns the raw JSON value of [aiProviderKeyName].
         *
         * Unlike [aiProviderKeyName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("aiProviderKeyName")
        @ExcludeMissing
        fun _aiProviderKeyName(): JsonField<String> = aiProviderKeyName

        /**
         * Returns the raw JSON value of [apiKey].
         *
         * Unlike [apiKey], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("apiKey") @ExcludeMissing fun _apiKey(): JsonField<String> = apiKey

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
         * Returns the raw JSON value of [productId].
         *
         * Unlike [productId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("productId") @ExcludeMissing fun _productId(): JsonField<String> = productId

        /**
         * Returns the raw JSON value of [sourceId].
         *
         * Unlike [sourceId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sourceId") @ExcludeMissing fun _sourceId(): JsonField<String> = sourceId

        /**
         * Returns the raw JSON value of [subscriberIdentity].
         *
         * Unlike [subscriberIdentity], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("subscriberIdentity")
        @ExcludeMissing
        fun _subscriberIdentity(): JsonField<String> = subscriberIdentity

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
         * Returns the raw JSON value of [taskId].
         *
         * Unlike [taskId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("taskId") @ExcludeMissing fun _taskId(): JsonField<String> = taskId

        /**
         * Returns the raw JSON value of [taskType].
         *
         * Unlike [taskType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("taskType") @ExcludeMissing fun _taskType(): JsonField<String> = taskType

        /**
         * Returns the raw JSON value of [traceId].
         *
         * Unlike [traceId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("traceId") @ExcludeMissing fun _traceId(): JsonField<String> = traceId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            audioTokenCount()
            cachedTokenCount()
            completionStartTime()
            completionTokenCount()
            costType()
            inputTokenCost()
            model()
            outputTokenCost()
            promptTokenCount()
            provider()
            reasoningTokenCount()
            requestDuration()
            requestTime()
            responseTime()
            stopReason()
            totalCost()
            totalTokenCount()
            transactionId()
            agent()
            aiProviderKeyName()
            apiKey()
            organizationId()
            productId()
            sourceId()
            subscriberIdentity()
            subscriptionId()
            taskId()
            taskType()
            traceId()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .audioTokenCount()
             * .cachedTokenCount()
             * .completionStartTime()
             * .completionTokenCount()
             * .costType()
             * .inputTokenCost()
             * .model()
             * .outputTokenCost()
             * .promptTokenCount()
             * .provider()
             * .reasoningTokenCount()
             * .requestDuration()
             * .requestTime()
             * .responseTime()
             * .stopReason()
             * .totalCost()
             * .totalTokenCount()
             * .transactionId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var audioTokenCount: JsonField<Long>? = null
            private var cachedTokenCount: JsonField<Long>? = null
            private var completionStartTime: JsonField<String>? = null
            private var completionTokenCount: JsonField<Long>? = null
            private var costType: JsonField<CostType>? = null
            private var inputTokenCost: JsonField<Double>? = null
            private var model: JsonField<String>? = null
            private var outputTokenCost: JsonField<Double>? = null
            private var promptTokenCount: JsonField<Long>? = null
            private var provider: JsonField<String>? = null
            private var reasoningTokenCount: JsonField<Long>? = null
            private var requestDuration: JsonField<Long>? = null
            private var requestTime: JsonField<String>? = null
            private var responseTime: JsonField<String>? = null
            private var stopReason: JsonField<StopReason>? = null
            private var totalCost: JsonField<Double>? = null
            private var totalTokenCount: JsonField<Long>? = null
            private var transactionId: JsonField<String>? = null
            private var agent: JsonField<String> = JsonMissing.of()
            private var aiProviderKeyName: JsonField<String> = JsonMissing.of()
            private var apiKey: JsonField<String> = JsonMissing.of()
            private var organizationId: JsonField<String> = JsonMissing.of()
            private var productId: JsonField<String> = JsonMissing.of()
            private var sourceId: JsonField<String> = JsonMissing.of()
            private var subscriberIdentity: JsonField<String> = JsonMissing.of()
            private var subscriptionId: JsonField<String> = JsonMissing.of()
            private var taskId: JsonField<String> = JsonMissing.of()
            private var taskType: JsonField<String> = JsonMissing.of()
            private var traceId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                audioTokenCount = body.audioTokenCount
                cachedTokenCount = body.cachedTokenCount
                completionStartTime = body.completionStartTime
                completionTokenCount = body.completionTokenCount
                costType = body.costType
                inputTokenCost = body.inputTokenCost
                model = body.model
                outputTokenCost = body.outputTokenCost
                promptTokenCount = body.promptTokenCount
                provider = body.provider
                reasoningTokenCount = body.reasoningTokenCount
                requestDuration = body.requestDuration
                requestTime = body.requestTime
                responseTime = body.responseTime
                stopReason = body.stopReason
                totalCost = body.totalCost
                totalTokenCount = body.totalTokenCount
                transactionId = body.transactionId
                agent = body.agent
                aiProviderKeyName = body.aiProviderKeyName
                apiKey = body.apiKey
                organizationId = body.organizationId
                productId = body.productId
                sourceId = body.sourceId
                subscriberIdentity = body.subscriberIdentity
                subscriptionId = body.subscriptionId
                taskId = body.taskId
                taskType = body.taskType
                traceId = body.traceId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The number of audio tokens in the completion */
            fun audioTokenCount(audioTokenCount: Long) =
                audioTokenCount(JsonField.of(audioTokenCount))

            /**
             * Sets [Builder.audioTokenCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audioTokenCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audioTokenCount(audioTokenCount: JsonField<Long>) = apply {
                this.audioTokenCount = audioTokenCount
            }

            /** The number of cached tokens in the completion */
            fun cachedTokenCount(cachedTokenCount: Long) =
                cachedTokenCount(JsonField.of(cachedTokenCount))

            /**
             * Sets [Builder.cachedTokenCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cachedTokenCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cachedTokenCount(cachedTokenCount: JsonField<Long>) = apply {
                this.cachedTokenCount = cachedTokenCount
            }

            /** Time to first token for streaming requests */
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

            /** The number of tokens in the completion */
            fun completionTokenCount(completionTokenCount: Long) =
                completionTokenCount(JsonField.of(completionTokenCount))

            /**
             * Sets [Builder.completionTokenCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.completionTokenCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun completionTokenCount(completionTokenCount: JsonField<Long>) = apply {
                this.completionTokenCount = completionTokenCount
            }

            /** Cost type for the completion */
            fun costType(costType: CostType) = costType(JsonField.of(costType))

            /**
             * Sets [Builder.costType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.costType] with a well-typed [CostType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun costType(costType: JsonField<CostType>) = apply { this.costType = costType }

            /** The input token cost associated with the LLM completion */
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

            /** The model used for generating the LLM completion */
            fun model(model: String) = model(JsonField.of(model))

            /**
             * Sets [Builder.model] to an arbitrary JSON value.
             *
             * You should usually call [Builder.model] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun model(model: JsonField<String>) = apply { this.model = model }

            /** The output token cost associated with the LLM completion */
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

            /** The number of tokens in the prompt */
            fun promptTokenCount(promptTokenCount: Long) =
                promptTokenCount(JsonField.of(promptTokenCount))

            /**
             * Sets [Builder.promptTokenCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.promptTokenCount] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun promptTokenCount(promptTokenCount: JsonField<Long>) = apply {
                this.promptTokenCount = promptTokenCount
            }

            /** Vendor providing the LLM completion service */
            fun provider(provider: String) = provider(JsonField.of(provider))

            /**
             * Sets [Builder.provider] to an arbitrary JSON value.
             *
             * You should usually call [Builder.provider] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun provider(provider: JsonField<String>) = apply { this.provider = provider }

            /** The number of reasoning tokens in the completion */
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

            /** The duration of the request in milliseconds */
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

            /** The timestamp when the request was made */
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
             * The timestamp when the response was generated. If streaming, this is the time to
             * first token
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

            /** The total cost associated with the LLM completion */
            fun totalCost(totalCost: Double) = totalCost(JsonField.of(totalCost))

            /**
             * Sets [Builder.totalCost] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalCost] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalCost(totalCost: JsonField<Double>) = apply { this.totalCost = totalCost }

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

            /** The unique identifier of the LLM completion transaction */
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

            /** The name (not the value!) of the API key used to access the AI provider */
            fun aiProviderKeyName(aiProviderKeyName: String) =
                aiProviderKeyName(JsonField.of(aiProviderKeyName))

            /**
             * Sets [Builder.aiProviderKeyName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.aiProviderKeyName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun aiProviderKeyName(aiProviderKeyName: JsonField<String>) = apply {
                this.aiProviderKeyName = aiProviderKeyName
            }

            fun apiKey(apiKey: String) = apiKey(JsonField.of(apiKey))

            /**
             * Sets [Builder.apiKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.apiKey] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun apiKey(apiKey: JsonField<String>) = apply { this.apiKey = apiKey }

            /**
             * Populate the ID of the subscriber’s organization from your system to allow Revenium
             * to track usage & costs by company. i.e. AcmeCorp. If several subscriberIds have the
             * same organizationId, Revenium’s reporting will show usage for the entire organization
             * broken down by user.
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

            /** Identifier of the source to correlate usage between Revenium & your application. */
            fun sourceId(sourceId: String) = sourceId(JsonField.of(sourceId))

            /**
             * Sets [Builder.sourceId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sourceId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sourceId(sourceId: JsonField<String>) = apply { this.sourceId = sourceId }

            /**
             * Populate the ID of the subscriber from your system to allow Revenium to track usage &
             * costs for individual users. Oftentimes a subscriberId is an email address.
             */
            fun subscriberIdentity(subscriberIdentity: String) =
                subscriberIdentity(JsonField.of(subscriberIdentity))

            /**
             * Sets [Builder.subscriberIdentity] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subscriberIdentity] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subscriberIdentity(subscriberIdentity: JsonField<String>) = apply {
                this.subscriberIdentity = subscriberIdentity
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
             * Identifier of the associated task. If you wish to track the costs and performance for
             * a task that occurs over several prompts, use a consistent task ID for all prompts
             * included in that task.
             */
            fun taskId(taskId: String) = taskId(JsonField.of(taskId))

            /**
             * Sets [Builder.taskId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.taskId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun taskId(taskId: JsonField<String>) = apply { this.taskId = taskId }

            /**
             * If you wish to track the costs or performance of a specific task and compare the
             * values over time or compare the performance across AI models or vendors, use a
             * consistent taskType for all related tasks.
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

            /** Trace multiple LLM calls belonging to same overall request */
            fun traceId(traceId: String) = traceId(JsonField.of(traceId))

            /**
             * Sets [Builder.traceId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.traceId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun traceId(traceId: JsonField<String>) = apply { this.traceId = traceId }

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

            fun build(): Body =
                Body(
                    checkRequired("audioTokenCount", audioTokenCount),
                    checkRequired("cachedTokenCount", cachedTokenCount),
                    checkRequired("completionStartTime", completionStartTime),
                    checkRequired("completionTokenCount", completionTokenCount),
                    checkRequired("costType", costType),
                    checkRequired("inputTokenCost", inputTokenCost),
                    checkRequired("model", model),
                    checkRequired("outputTokenCost", outputTokenCost),
                    checkRequired("promptTokenCount", promptTokenCount),
                    checkRequired("provider", provider),
                    checkRequired("reasoningTokenCount", reasoningTokenCount),
                    checkRequired("requestDuration", requestDuration),
                    checkRequired("requestTime", requestTime),
                    checkRequired("responseTime", responseTime),
                    checkRequired("stopReason", stopReason),
                    checkRequired("totalCost", totalCost),
                    checkRequired("totalTokenCount", totalTokenCount),
                    checkRequired("transactionId", transactionId),
                    agent,
                    aiProviderKeyName,
                    apiKey,
                    organizationId,
                    productId,
                    sourceId,
                    subscriberIdentity,
                    subscriptionId,
                    taskId,
                    taskType,
                    traceId,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && audioTokenCount == other.audioTokenCount && cachedTokenCount == other.cachedTokenCount && completionStartTime == other.completionStartTime && completionTokenCount == other.completionTokenCount && costType == other.costType && inputTokenCost == other.inputTokenCost && model == other.model && outputTokenCost == other.outputTokenCost && promptTokenCount == other.promptTokenCount && provider == other.provider && reasoningTokenCount == other.reasoningTokenCount && requestDuration == other.requestDuration && requestTime == other.requestTime && responseTime == other.responseTime && stopReason == other.stopReason && totalCost == other.totalCost && totalTokenCount == other.totalTokenCount && transactionId == other.transactionId && agent == other.agent && aiProviderKeyName == other.aiProviderKeyName && apiKey == other.apiKey && organizationId == other.organizationId && productId == other.productId && sourceId == other.sourceId && subscriberIdentity == other.subscriberIdentity && subscriptionId == other.subscriptionId && taskId == other.taskId && taskType == other.taskType && traceId == other.traceId && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(audioTokenCount, cachedTokenCount, completionStartTime, completionTokenCount, costType, inputTokenCost, model, outputTokenCost, promptTokenCount, provider, reasoningTokenCount, requestDuration, requestTime, responseTime, stopReason, totalCost, totalTokenCount, transactionId, agent, aiProviderKeyName, apiKey, organizationId, productId, sourceId, subscriberIdentity, subscriptionId, taskId, taskType, traceId, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{audioTokenCount=$audioTokenCount, cachedTokenCount=$cachedTokenCount, completionStartTime=$completionStartTime, completionTokenCount=$completionTokenCount, costType=$costType, inputTokenCost=$inputTokenCost, model=$model, outputTokenCost=$outputTokenCost, promptTokenCount=$promptTokenCount, provider=$provider, reasoningTokenCount=$reasoningTokenCount, requestDuration=$requestDuration, requestTime=$requestTime, responseTime=$responseTime, stopReason=$stopReason, totalCost=$totalCost, totalTokenCount=$totalTokenCount, transactionId=$transactionId, agent=$agent, aiProviderKeyName=$aiProviderKeyName, apiKey=$apiKey, organizationId=$organizationId, productId=$productId, sourceId=$sourceId, subscriberIdentity=$subscriberIdentity, subscriptionId=$subscriptionId, taskId=$taskId, taskType=$taskType, traceId=$traceId, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AiCreateCompletionParams].
         *
         * The following fields are required:
         * ```java
         * .audioTokenCount()
         * .cachedTokenCount()
         * .completionStartTime()
         * .completionTokenCount()
         * .costType()
         * .inputTokenCost()
         * .model()
         * .outputTokenCost()
         * .promptTokenCount()
         * .provider()
         * .reasoningTokenCount()
         * .requestDuration()
         * .requestTime()
         * .responseTime()
         * .stopReason()
         * .totalCost()
         * .totalTokenCount()
         * .transactionId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AiCreateCompletionParams]. */
    @NoAutoDetect
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

        /** The number of audio tokens in the completion */
        fun audioTokenCount(audioTokenCount: Long) = apply { body.audioTokenCount(audioTokenCount) }

        /**
         * Sets [Builder.audioTokenCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.audioTokenCount] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun audioTokenCount(audioTokenCount: JsonField<Long>) = apply {
            body.audioTokenCount(audioTokenCount)
        }

        /** The number of cached tokens in the completion */
        fun cachedTokenCount(cachedTokenCount: Long) = apply {
            body.cachedTokenCount(cachedTokenCount)
        }

        /**
         * Sets [Builder.cachedTokenCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cachedTokenCount] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun cachedTokenCount(cachedTokenCount: JsonField<Long>) = apply {
            body.cachedTokenCount(cachedTokenCount)
        }

        /** Time to first token for streaming requests */
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

        /** The number of tokens in the completion */
        fun completionTokenCount(completionTokenCount: Long) = apply {
            body.completionTokenCount(completionTokenCount)
        }

        /**
         * Sets [Builder.completionTokenCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.completionTokenCount] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun completionTokenCount(completionTokenCount: JsonField<Long>) = apply {
            body.completionTokenCount(completionTokenCount)
        }

        /** Cost type for the completion */
        fun costType(costType: CostType) = apply { body.costType(costType) }

        /**
         * Sets [Builder.costType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.costType] with a well-typed [CostType] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun costType(costType: JsonField<CostType>) = apply { body.costType(costType) }

        /** The input token cost associated with the LLM completion */
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

        /** The model used for generating the LLM completion */
        fun model(model: String) = apply { body.model(model) }

        /**
         * Sets [Builder.model] to an arbitrary JSON value.
         *
         * You should usually call [Builder.model] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun model(model: JsonField<String>) = apply { body.model(model) }

        /** The output token cost associated with the LLM completion */
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

        /** The number of tokens in the prompt */
        fun promptTokenCount(promptTokenCount: Long) = apply {
            body.promptTokenCount(promptTokenCount)
        }

        /**
         * Sets [Builder.promptTokenCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.promptTokenCount] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun promptTokenCount(promptTokenCount: JsonField<Long>) = apply {
            body.promptTokenCount(promptTokenCount)
        }

        /** Vendor providing the LLM completion service */
        fun provider(provider: String) = apply { body.provider(provider) }

        /**
         * Sets [Builder.provider] to an arbitrary JSON value.
         *
         * You should usually call [Builder.provider] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun provider(provider: JsonField<String>) = apply { body.provider(provider) }

        /** The number of reasoning tokens in the completion */
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

        /** The duration of the request in milliseconds */
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

        /** The timestamp when the request was made */
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
         * The timestamp when the response was generated. If streaming, this is the time to first
         * token
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

        /** The total cost associated with the LLM completion */
        fun totalCost(totalCost: Double) = apply { body.totalCost(totalCost) }

        /**
         * Sets [Builder.totalCost] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalCost] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalCost(totalCost: JsonField<Double>) = apply { body.totalCost(totalCost) }

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

        /** The unique identifier of the LLM completion transaction */
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

        /** The AI agent that is making the request */
        fun agent(agent: String) = apply { body.agent(agent) }

        /**
         * Sets [Builder.agent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.agent] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun agent(agent: JsonField<String>) = apply { body.agent(agent) }

        /** The name (not the value!) of the API key used to access the AI provider */
        fun aiProviderKeyName(aiProviderKeyName: String) = apply {
            body.aiProviderKeyName(aiProviderKeyName)
        }

        /**
         * Sets [Builder.aiProviderKeyName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.aiProviderKeyName] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun aiProviderKeyName(aiProviderKeyName: JsonField<String>) = apply {
            body.aiProviderKeyName(aiProviderKeyName)
        }

        fun apiKey(apiKey: String) = apply { body.apiKey(apiKey) }

        /**
         * Sets [Builder.apiKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.apiKey] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun apiKey(apiKey: JsonField<String>) = apply { body.apiKey(apiKey) }

        /**
         * Populate the ID of the subscriber’s organization from your system to allow Revenium to
         * track usage & costs by company. i.e. AcmeCorp. If several subscriberIds have the same
         * organizationId, Revenium’s reporting will show usage for the entire organization broken
         * down by user.
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

        /** Identifier of the source to correlate usage between Revenium & your application. */
        fun sourceId(sourceId: String) = apply { body.sourceId(sourceId) }

        /**
         * Sets [Builder.sourceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sourceId(sourceId: JsonField<String>) = apply { body.sourceId(sourceId) }

        /**
         * Populate the ID of the subscriber from your system to allow Revenium to track usage &
         * costs for individual users. Oftentimes a subscriberId is an email address.
         */
        fun subscriberIdentity(subscriberIdentity: String) = apply {
            body.subscriberIdentity(subscriberIdentity)
        }

        /**
         * Sets [Builder.subscriberIdentity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subscriberIdentity] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun subscriberIdentity(subscriberIdentity: JsonField<String>) = apply {
            body.subscriberIdentity(subscriberIdentity)
        }

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
         * Identifier of the associated task. If you wish to track the costs and performance for a
         * task that occurs over several prompts, use a consistent task ID for all prompts included
         * in that task.
         */
        fun taskId(taskId: String) = apply { body.taskId(taskId) }

        /**
         * Sets [Builder.taskId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taskId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun taskId(taskId: JsonField<String>) = apply { body.taskId(taskId) }

        /**
         * If you wish to track the costs or performance of a specific task and compare the values
         * over time or compare the performance across AI models or vendors, use a consistent
         * taskType for all related tasks.
         */
        fun taskType(taskType: String) = apply { body.taskType(taskType) }

        /**
         * Sets [Builder.taskType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taskType] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun taskType(taskType: JsonField<String>) = apply { body.taskType(taskType) }

        /** Trace multiple LLM calls belonging to same overall request */
        fun traceId(traceId: String) = apply { body.traceId(traceId) }

        /**
         * Sets [Builder.traceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.traceId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun traceId(traceId: JsonField<String>) = apply { body.traceId(traceId) }

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

        fun build(): AiCreateCompletionParams =
            AiCreateCompletionParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /** Cost type for the completion */
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is CostType && value == other.value /* spotless:on */
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is StopReason && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AiCreateCompletionParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "AiCreateCompletionParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
