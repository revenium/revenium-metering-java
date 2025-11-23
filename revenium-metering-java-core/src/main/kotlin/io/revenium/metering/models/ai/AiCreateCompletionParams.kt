// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.models.ai

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.revenium.metering.core.Enum
import io.revenium.metering.core.ExcludeMissing
import io.revenium.metering.core.JsonField
import io.revenium.metering.core.JsonMissing
import io.revenium.metering.core.JsonValue
import io.revenium.metering.core.Params
import io.revenium.metering.core.checkRequired
import io.revenium.metering.core.http.Headers
import io.revenium.metering.core.http.QueryParams
import io.revenium.metering.errors.ReveniumMeteringInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Record the details of an LLM completion */
class AiCreateCompletionParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Time to first token for streaming requests
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun completionStartTime(): String = body.completionStartTime()

    /**
     * Cost type for the completion
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
     * Indicates if the completion was streamed
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun isStreamed(): Boolean = body.isStreamed()

    /**
     * The model used for generating the LLM completion
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
     * Vendor providing the LLM completion service
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun provider(): String = body.provider()

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
     * The number of cached creation tokens in the completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun cacheCreationTokenCount(): Optional<Long> = body.cacheCreationTokenCount()

    /**
     * The number of cached read tokens in the completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun cacheReadTokenCount(): Optional<Long> = body.cacheReadTokenCount()

    /**
     * The details of the error that occurred during the LLM completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun errorReason(): Optional<String> = body.errorReason()

    /**
     * The input token cost associated with the LLM completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun inputTokenCost(): Optional<Double> = body.inputTokenCost()

    /**
     * The latency, in milliseconds, of latency by an AI or API gateway
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun mediationLatency(): Optional<Long> = body.mediationLatency()

    /**
     * The source of the AI model used for the completion
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
     * by user.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun organizationId(): Optional<String> = body.organizationId()

    /**
     * The output token cost associated with the LLM completion
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
     * The number of reasoning tokens in the completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun reasoningTokenCount(): Optional<Long> = body.reasoningTokenCount()

    /**
     * The quality score of the response
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun responseQualityScore(): Optional<Double> = body.responseQualityScore()

    /**
     * Populate the ID of the subscriber from your system to allow Revenium to track usage & costs
     * for individual users.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun subscriberCredential(): Optional<String> = body.subscriberCredential()

    /**
     * Populate the name of the subscriber credential from your system to allow Revenium to track
     * usage & costs for individual users.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun subscriberCredentialName(): Optional<String> = body.subscriberCredentialName()

    /**
     * The email address of the subscriber
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun subscriberEmail(): Optional<String> = body.subscriberEmail()

    /**
     * Populate the ID of the subscriber from your system to allow Revenium to track usage & costs
     * for individual users. i.e. user-123. If several subscriberCredentials have the same
     * subscriberId, Revenium’s reporting will show usage for the entire organization broken down by
     * user.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun subscriberId(): Optional<String> = body.subscriberId()

    /**
     * Unique identifier of the subscription from your own system that you wish to use to correlate
     * usage between Revenium & your application.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun subscriptionId(): Optional<String> = body.subscriptionId()

    /**
     * A unique identifier that represents the statistical signature of the language model that
     * generated a specific chat completion. This fingerprint can be used for model attribution,
     * debugging, and monitoring model behavior across request
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun systemFingerprint(): Optional<String> = body.systemFingerprint()

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
     * The temperature setting used for the LLM completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun temperature(): Optional<Double> = body.temperature()

    /**
     * The time to first token in milliseconds
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun timeToFirstToken(): Optional<Long> = body.timeToFirstToken()

    /**
     * The total cost associated with the LLM completion
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun totalCost(): Optional<Double> = body.totalCost()

    /**
     * Trace multiple LLM calls belonging to same overall request
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun traceId(): Optional<String> = body.traceId()

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
     * Returns the raw JSON value of [cacheCreationTokenCount].
     *
     * Unlike [cacheCreationTokenCount], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _cacheCreationTokenCount(): JsonField<Long> = body._cacheCreationTokenCount()

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
     * Returns the raw JSON value of [subscriberCredential].
     *
     * Unlike [subscriberCredential], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _subscriberCredential(): JsonField<String> = body._subscriberCredential()

    /**
     * Returns the raw JSON value of [subscriberCredentialName].
     *
     * Unlike [subscriberCredentialName], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _subscriberCredentialName(): JsonField<String> = body._subscriberCredentialName()

    /**
     * Returns the raw JSON value of [subscriberEmail].
     *
     * Unlike [subscriberEmail], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _subscriberEmail(): JsonField<String> = body._subscriberEmail()

    /**
     * Returns the raw JSON value of [subscriberId].
     *
     * Unlike [subscriberId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _subscriberId(): JsonField<String> = body._subscriberId()

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
         * .transactionId()
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

        /** Indicates if the completion was streamed */
        fun isStreamed(isStreamed: Boolean) = apply { body.isStreamed(isStreamed) }

        /**
         * Sets [Builder.isStreamed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isStreamed] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isStreamed(isStreamed: JsonField<Boolean>) = apply { body.isStreamed(isStreamed) }

        /** The model used for generating the LLM completion */
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

        /** Vendor providing the LLM completion service */
        fun provider(provider: String) = apply { body.provider(provider) }

        /**
         * Sets [Builder.provider] to an arbitrary JSON value.
         *
         * You should usually call [Builder.provider] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun provider(provider: JsonField<String>) = apply { body.provider(provider) }

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

        /** The number of cached creation tokens in the completion */
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

        /** The number of cached read tokens in the completion */
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

        /** The details of the error that occurred during the LLM completion */
        fun errorReason(errorReason: String) = apply { body.errorReason(errorReason) }

        /**
         * Sets [Builder.errorReason] to an arbitrary JSON value.
         *
         * You should usually call [Builder.errorReason] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun errorReason(errorReason: JsonField<String>) = apply { body.errorReason(errorReason) }

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

        /** The latency, in milliseconds, of latency by an AI or API gateway */
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

        /** The source of the AI model used for the completion */
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

        /** The quality score of the response */
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
         * Populate the ID of the subscriber from your system to allow Revenium to track usage &
         * costs for individual users.
         */
        fun subscriberCredential(subscriberCredential: String) = apply {
            body.subscriberCredential(subscriberCredential)
        }

        /**
         * Sets [Builder.subscriberCredential] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subscriberCredential] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun subscriberCredential(subscriberCredential: JsonField<String>) = apply {
            body.subscriberCredential(subscriberCredential)
        }

        /**
         * Populate the name of the subscriber credential from your system to allow Revenium to
         * track usage & costs for individual users.
         */
        fun subscriberCredentialName(subscriberCredentialName: String) = apply {
            body.subscriberCredentialName(subscriberCredentialName)
        }

        /**
         * Sets [Builder.subscriberCredentialName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subscriberCredentialName] with a well-typed [String]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun subscriberCredentialName(subscriberCredentialName: JsonField<String>) = apply {
            body.subscriberCredentialName(subscriberCredentialName)
        }

        /** The email address of the subscriber */
        fun subscriberEmail(subscriberEmail: String) = apply {
            body.subscriberEmail(subscriberEmail)
        }

        /**
         * Sets [Builder.subscriberEmail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subscriberEmail] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun subscriberEmail(subscriberEmail: JsonField<String>) = apply {
            body.subscriberEmail(subscriberEmail)
        }

        /**
         * Populate the ID of the subscriber from your system to allow Revenium to track usage &
         * costs for individual users. i.e. user-123. If several subscriberCredentials have the same
         * subscriberId, Revenium’s reporting will show usage for the entire organization broken
         * down by user.
         */
        fun subscriberId(subscriberId: String) = apply { body.subscriberId(subscriberId) }

        /**
         * Sets [Builder.subscriberId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subscriberId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun subscriberId(subscriberId: JsonField<String>) = apply {
            body.subscriberId(subscriberId)
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
         * A unique identifier that represents the statistical signature of the language model that
         * generated a specific chat completion. This fingerprint can be used for model attribution,
         * debugging, and monitoring model behavior across request
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

        /** The temperature setting used for the LLM completion */
        fun temperature(temperature: Double) = apply { body.temperature(temperature) }

        /**
         * Sets [Builder.temperature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.temperature] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun temperature(temperature: JsonField<Double>) = apply { body.temperature(temperature) }

        /** The time to first token in milliseconds */
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
         * .transactionId()
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

    /** The AI completion metadata */
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
        private val transactionId: JsonField<String>,
        private val agent: JsonField<String>,
        private val cacheCreationTokenCount: JsonField<Long>,
        private val cacheReadTokenCount: JsonField<Long>,
        private val errorReason: JsonField<String>,
        private val inputTokenCost: JsonField<Double>,
        private val mediationLatency: JsonField<Long>,
        private val modelSource: JsonField<String>,
        private val operationType: JsonField<OperationType>,
        private val organizationId: JsonField<String>,
        private val outputTokenCost: JsonField<Double>,
        private val productId: JsonField<String>,
        private val reasoningTokenCount: JsonField<Long>,
        private val responseQualityScore: JsonField<Double>,
        private val subscriberCredential: JsonField<String>,
        private val subscriberCredentialName: JsonField<String>,
        private val subscriberEmail: JsonField<String>,
        private val subscriberId: JsonField<String>,
        private val subscriptionId: JsonField<String>,
        private val systemFingerprint: JsonField<String>,
        private val taskType: JsonField<String>,
        private val temperature: JsonField<Double>,
        private val timeToFirstToken: JsonField<Long>,
        private val totalCost: JsonField<Double>,
        private val traceId: JsonField<String>,
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
            @JsonProperty("transactionId")
            @ExcludeMissing
            transactionId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("agent") @ExcludeMissing agent: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cacheCreationTokenCount")
            @ExcludeMissing
            cacheCreationTokenCount: JsonField<Long> = JsonMissing.of(),
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
            @JsonProperty("subscriberCredential")
            @ExcludeMissing
            subscriberCredential: JsonField<String> = JsonMissing.of(),
            @JsonProperty("subscriberCredentialName")
            @ExcludeMissing
            subscriberCredentialName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("subscriberEmail")
            @ExcludeMissing
            subscriberEmail: JsonField<String> = JsonMissing.of(),
            @JsonProperty("subscriberId")
            @ExcludeMissing
            subscriberId: JsonField<String> = JsonMissing.of(),
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
            transactionId,
            agent,
            cacheCreationTokenCount,
            cacheReadTokenCount,
            errorReason,
            inputTokenCost,
            mediationLatency,
            modelSource,
            operationType,
            organizationId,
            outputTokenCost,
            productId,
            reasoningTokenCount,
            responseQualityScore,
            subscriberCredential,
            subscriberCredentialName,
            subscriberEmail,
            subscriberId,
            subscriptionId,
            systemFingerprint,
            taskType,
            temperature,
            timeToFirstToken,
            totalCost,
            traceId,
            mutableMapOf(),
        )

        /**
         * Time to first token for streaming requests
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun completionStartTime(): String = completionStartTime.getRequired("completionStartTime")

        /**
         * Cost type for the completion
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
         * Indicates if the completion was streamed
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun isStreamed(): Boolean = isStreamed.getRequired("isStreamed")

        /**
         * The model used for generating the LLM completion
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
         * Vendor providing the LLM completion service
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun provider(): String = provider.getRequired("provider")

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
        fun agent(): Optional<String> = agent.getOptional("agent")

        /**
         * The number of cached creation tokens in the completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun cacheCreationTokenCount(): Optional<Long> =
            cacheCreationTokenCount.getOptional("cacheCreationTokenCount")

        /**
         * The number of cached read tokens in the completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun cacheReadTokenCount(): Optional<Long> =
            cacheReadTokenCount.getOptional("cacheReadTokenCount")

        /**
         * The details of the error that occurred during the LLM completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun errorReason(): Optional<String> = errorReason.getOptional("errorReason")

        /**
         * The input token cost associated with the LLM completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun inputTokenCost(): Optional<Double> = inputTokenCost.getOptional("inputTokenCost")

        /**
         * The latency, in milliseconds, of latency by an AI or API gateway
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun mediationLatency(): Optional<Long> = mediationLatency.getOptional("mediationLatency")

        /**
         * The source of the AI model used for the completion
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
         * down by user.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun organizationId(): Optional<String> = organizationId.getOptional("organizationId")

        /**
         * The output token cost associated with the LLM completion
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
         * The number of reasoning tokens in the completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun reasoningTokenCount(): Optional<Long> =
            reasoningTokenCount.getOptional("reasoningTokenCount")

        /**
         * The quality score of the response
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun responseQualityScore(): Optional<Double> =
            responseQualityScore.getOptional("responseQualityScore")

        /**
         * Populate the ID of the subscriber from your system to allow Revenium to track usage &
         * costs for individual users.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun subscriberCredential(): Optional<String> =
            subscriberCredential.getOptional("subscriberCredential")

        /**
         * Populate the name of the subscriber credential from your system to allow Revenium to
         * track usage & costs for individual users.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun subscriberCredentialName(): Optional<String> =
            subscriberCredentialName.getOptional("subscriberCredentialName")

        /**
         * The email address of the subscriber
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun subscriberEmail(): Optional<String> = subscriberEmail.getOptional("subscriberEmail")

        /**
         * Populate the ID of the subscriber from your system to allow Revenium to track usage &
         * costs for individual users. i.e. user-123. If several subscriberCredentials have the same
         * subscriberId, Revenium’s reporting will show usage for the entire organization broken
         * down by user.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun subscriberId(): Optional<String> = subscriberId.getOptional("subscriberId")

        /**
         * Unique identifier of the subscription from your own system that you wish to use to
         * correlate usage between Revenium & your application.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun subscriptionId(): Optional<String> = subscriptionId.getOptional("subscriptionId")

        /**
         * A unique identifier that represents the statistical signature of the language model that
         * generated a specific chat completion. This fingerprint can be used for model attribution,
         * debugging, and monitoring model behavior across request
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun systemFingerprint(): Optional<String> =
            systemFingerprint.getOptional("systemFingerprint")

        /**
         * If you wish to track the costs or performance of a specific task and compare the values
         * over time or compare the performance across AI models or vendors, use a consistent
         * taskType for all related tasks.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun taskType(): Optional<String> = taskType.getOptional("taskType")

        /**
         * The temperature setting used for the LLM completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun temperature(): Optional<Double> = temperature.getOptional("temperature")

        /**
         * The time to first token in milliseconds
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun timeToFirstToken(): Optional<Long> = timeToFirstToken.getOptional("timeToFirstToken")

        /**
         * The total cost associated with the LLM completion
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun totalCost(): Optional<Double> = totalCost.getOptional("totalCost")

        /**
         * Trace multiple LLM calls belonging to same overall request
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun traceId(): Optional<String> = traceId.getOptional("traceId")

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
         * Returns the raw JSON value of [cacheCreationTokenCount].
         *
         * Unlike [cacheCreationTokenCount], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("cacheCreationTokenCount")
        @ExcludeMissing
        fun _cacheCreationTokenCount(): JsonField<Long> = cacheCreationTokenCount

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
         * Returns the raw JSON value of [subscriberCredential].
         *
         * Unlike [subscriberCredential], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("subscriberCredential")
        @ExcludeMissing
        fun _subscriberCredential(): JsonField<String> = subscriberCredential

        /**
         * Returns the raw JSON value of [subscriberCredentialName].
         *
         * Unlike [subscriberCredentialName], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("subscriberCredentialName")
        @ExcludeMissing
        fun _subscriberCredentialName(): JsonField<String> = subscriberCredentialName

        /**
         * Returns the raw JSON value of [subscriberEmail].
         *
         * Unlike [subscriberEmail], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("subscriberEmail")
        @ExcludeMissing
        fun _subscriberEmail(): JsonField<String> = subscriberEmail

        /**
         * Returns the raw JSON value of [subscriberId].
         *
         * Unlike [subscriberId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("subscriberId")
        @ExcludeMissing
        fun _subscriberId(): JsonField<String> = subscriberId

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
             * .transactionId()
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
            private var transactionId: JsonField<String>? = null
            private var agent: JsonField<String> = JsonMissing.of()
            private var cacheCreationTokenCount: JsonField<Long> = JsonMissing.of()
            private var cacheReadTokenCount: JsonField<Long> = JsonMissing.of()
            private var errorReason: JsonField<String> = JsonMissing.of()
            private var inputTokenCost: JsonField<Double> = JsonMissing.of()
            private var mediationLatency: JsonField<Long> = JsonMissing.of()
            private var modelSource: JsonField<String> = JsonMissing.of()
            private var operationType: JsonField<OperationType> = JsonMissing.of()
            private var organizationId: JsonField<String> = JsonMissing.of()
            private var outputTokenCost: JsonField<Double> = JsonMissing.of()
            private var productId: JsonField<String> = JsonMissing.of()
            private var reasoningTokenCount: JsonField<Long> = JsonMissing.of()
            private var responseQualityScore: JsonField<Double> = JsonMissing.of()
            private var subscriberCredential: JsonField<String> = JsonMissing.of()
            private var subscriberCredentialName: JsonField<String> = JsonMissing.of()
            private var subscriberEmail: JsonField<String> = JsonMissing.of()
            private var subscriberId: JsonField<String> = JsonMissing.of()
            private var subscriptionId: JsonField<String> = JsonMissing.of()
            private var systemFingerprint: JsonField<String> = JsonMissing.of()
            private var taskType: JsonField<String> = JsonMissing.of()
            private var temperature: JsonField<Double> = JsonMissing.of()
            private var timeToFirstToken: JsonField<Long> = JsonMissing.of()
            private var totalCost: JsonField<Double> = JsonMissing.of()
            private var traceId: JsonField<String> = JsonMissing.of()
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
                transactionId = body.transactionId
                agent = body.agent
                cacheCreationTokenCount = body.cacheCreationTokenCount
                cacheReadTokenCount = body.cacheReadTokenCount
                errorReason = body.errorReason
                inputTokenCost = body.inputTokenCost
                mediationLatency = body.mediationLatency
                modelSource = body.modelSource
                operationType = body.operationType
                organizationId = body.organizationId
                outputTokenCost = body.outputTokenCost
                productId = body.productId
                reasoningTokenCount = body.reasoningTokenCount
                responseQualityScore = body.responseQualityScore
                subscriberCredential = body.subscriberCredential
                subscriberCredentialName = body.subscriberCredentialName
                subscriberEmail = body.subscriberEmail
                subscriberId = body.subscriberId
                subscriptionId = body.subscriptionId
                systemFingerprint = body.systemFingerprint
                taskType = body.taskType
                temperature = body.temperature
                timeToFirstToken = body.timeToFirstToken
                totalCost = body.totalCost
                traceId = body.traceId
                additionalProperties = body.additionalProperties.toMutableMap()
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

            /** Indicates if the completion was streamed */
            fun isStreamed(isStreamed: Boolean) = isStreamed(JsonField.of(isStreamed))

            /**
             * Sets [Builder.isStreamed] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isStreamed] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isStreamed(isStreamed: JsonField<Boolean>) = apply { this.isStreamed = isStreamed }

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

            /** The number of cached creation tokens in the completion */
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

            /** The number of cached read tokens in the completion */
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

            /** The details of the error that occurred during the LLM completion */
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

            /** The latency, in milliseconds, of latency by an AI or API gateway */
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

            /** The source of the AI model used for the completion */
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

            /** The quality score of the response */
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
             * Populate the ID of the subscriber from your system to allow Revenium to track usage &
             * costs for individual users.
             */
            fun subscriberCredential(subscriberCredential: String) =
                subscriberCredential(JsonField.of(subscriberCredential))

            /**
             * Sets [Builder.subscriberCredential] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subscriberCredential] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun subscriberCredential(subscriberCredential: JsonField<String>) = apply {
                this.subscriberCredential = subscriberCredential
            }

            /**
             * Populate the name of the subscriber credential from your system to allow Revenium to
             * track usage & costs for individual users.
             */
            fun subscriberCredentialName(subscriberCredentialName: String) =
                subscriberCredentialName(JsonField.of(subscriberCredentialName))

            /**
             * Sets [Builder.subscriberCredentialName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subscriberCredentialName] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun subscriberCredentialName(subscriberCredentialName: JsonField<String>) = apply {
                this.subscriberCredentialName = subscriberCredentialName
            }

            /** The email address of the subscriber */
            fun subscriberEmail(subscriberEmail: String) =
                subscriberEmail(JsonField.of(subscriberEmail))

            /**
             * Sets [Builder.subscriberEmail] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subscriberEmail] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subscriberEmail(subscriberEmail: JsonField<String>) = apply {
                this.subscriberEmail = subscriberEmail
            }

            /**
             * Populate the ID of the subscriber from your system to allow Revenium to track usage &
             * costs for individual users. i.e. user-123. If several subscriberCredentials have the
             * same subscriberId, Revenium’s reporting will show usage for the entire organization
             * broken down by user.
             */
            fun subscriberId(subscriberId: String) = subscriberId(JsonField.of(subscriberId))

            /**
             * Sets [Builder.subscriberId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subscriberId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subscriberId(subscriberId: JsonField<String>) = apply {
                this.subscriberId = subscriberId
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
             * A unique identifier that represents the statistical signature of the language model
             * that generated a specific chat completion. This fingerprint can be used for model
             * attribution, debugging, and monitoring model behavior across request
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

            /** The temperature setting used for the LLM completion */
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

            /** The time to first token in milliseconds */
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
             * .transactionId()
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
                    checkRequired("transactionId", transactionId),
                    agent,
                    cacheCreationTokenCount,
                    cacheReadTokenCount,
                    errorReason,
                    inputTokenCost,
                    mediationLatency,
                    modelSource,
                    operationType,
                    organizationId,
                    outputTokenCost,
                    productId,
                    reasoningTokenCount,
                    responseQualityScore,
                    subscriberCredential,
                    subscriberCredentialName,
                    subscriberEmail,
                    subscriberId,
                    subscriptionId,
                    systemFingerprint,
                    taskType,
                    temperature,
                    timeToFirstToken,
                    totalCost,
                    traceId,
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
            transactionId()
            agent()
            cacheCreationTokenCount()
            cacheReadTokenCount()
            errorReason()
            inputTokenCost()
            mediationLatency()
            modelSource()
            operationType().ifPresent { it.validate() }
            organizationId()
            outputTokenCost()
            productId()
            reasoningTokenCount()
            responseQualityScore()
            subscriberCredential()
            subscriberCredentialName()
            subscriberEmail()
            subscriberId()
            subscriptionId()
            systemFingerprint()
            taskType()
            temperature()
            timeToFirstToken()
            totalCost()
            traceId()
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
                (if (transactionId.asKnown().isPresent) 1 else 0) +
                (if (agent.asKnown().isPresent) 1 else 0) +
                (if (cacheCreationTokenCount.asKnown().isPresent) 1 else 0) +
                (if (cacheReadTokenCount.asKnown().isPresent) 1 else 0) +
                (if (errorReason.asKnown().isPresent) 1 else 0) +
                (if (inputTokenCost.asKnown().isPresent) 1 else 0) +
                (if (mediationLatency.asKnown().isPresent) 1 else 0) +
                (if (modelSource.asKnown().isPresent) 1 else 0) +
                (operationType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (organizationId.asKnown().isPresent) 1 else 0) +
                (if (outputTokenCost.asKnown().isPresent) 1 else 0) +
                (if (productId.asKnown().isPresent) 1 else 0) +
                (if (reasoningTokenCount.asKnown().isPresent) 1 else 0) +
                (if (responseQualityScore.asKnown().isPresent) 1 else 0) +
                (if (subscriberCredential.asKnown().isPresent) 1 else 0) +
                (if (subscriberCredentialName.asKnown().isPresent) 1 else 0) +
                (if (subscriberEmail.asKnown().isPresent) 1 else 0) +
                (if (subscriberId.asKnown().isPresent) 1 else 0) +
                (if (subscriptionId.asKnown().isPresent) 1 else 0) +
                (if (systemFingerprint.asKnown().isPresent) 1 else 0) +
                (if (taskType.asKnown().isPresent) 1 else 0) +
                (if (temperature.asKnown().isPresent) 1 else 0) +
                (if (timeToFirstToken.asKnown().isPresent) 1 else 0) +
                (if (totalCost.asKnown().isPresent) 1 else 0) +
                (if (traceId.asKnown().isPresent) 1 else 0)

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
                transactionId == other.transactionId &&
                agent == other.agent &&
                cacheCreationTokenCount == other.cacheCreationTokenCount &&
                cacheReadTokenCount == other.cacheReadTokenCount &&
                errorReason == other.errorReason &&
                inputTokenCost == other.inputTokenCost &&
                mediationLatency == other.mediationLatency &&
                modelSource == other.modelSource &&
                operationType == other.operationType &&
                organizationId == other.organizationId &&
                outputTokenCost == other.outputTokenCost &&
                productId == other.productId &&
                reasoningTokenCount == other.reasoningTokenCount &&
                responseQualityScore == other.responseQualityScore &&
                subscriberCredential == other.subscriberCredential &&
                subscriberCredentialName == other.subscriberCredentialName &&
                subscriberEmail == other.subscriberEmail &&
                subscriberId == other.subscriberId &&
                subscriptionId == other.subscriptionId &&
                systemFingerprint == other.systemFingerprint &&
                taskType == other.taskType &&
                temperature == other.temperature &&
                timeToFirstToken == other.timeToFirstToken &&
                totalCost == other.totalCost &&
                traceId == other.traceId &&
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
                transactionId,
                agent,
                cacheCreationTokenCount,
                cacheReadTokenCount,
                errorReason,
                inputTokenCost,
                mediationLatency,
                modelSource,
                operationType,
                organizationId,
                outputTokenCost,
                productId,
                reasoningTokenCount,
                responseQualityScore,
                subscriberCredential,
                subscriberCredentialName,
                subscriberEmail,
                subscriberId,
                subscriptionId,
                systemFingerprint,
                taskType,
                temperature,
                timeToFirstToken,
                totalCost,
                traceId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{completionStartTime=$completionStartTime, costType=$costType, inputTokenCount=$inputTokenCount, isStreamed=$isStreamed, model=$model, outputTokenCount=$outputTokenCount, provider=$provider, requestDuration=$requestDuration, requestTime=$requestTime, responseTime=$responseTime, stopReason=$stopReason, totalTokenCount=$totalTokenCount, transactionId=$transactionId, agent=$agent, cacheCreationTokenCount=$cacheCreationTokenCount, cacheReadTokenCount=$cacheReadTokenCount, errorReason=$errorReason, inputTokenCost=$inputTokenCost, mediationLatency=$mediationLatency, modelSource=$modelSource, operationType=$operationType, organizationId=$organizationId, outputTokenCost=$outputTokenCost, productId=$productId, reasoningTokenCount=$reasoningTokenCount, responseQualityScore=$responseQualityScore, subscriberCredential=$subscriberCredential, subscriberCredentialName=$subscriberCredentialName, subscriberEmail=$subscriberEmail, subscriberId=$subscriberId, subscriptionId=$subscriptionId, systemFingerprint=$systemFingerprint, taskType=$taskType, temperature=$temperature, timeToFirstToken=$timeToFirstToken, totalCost=$totalCost, traceId=$traceId, additionalProperties=$additionalProperties}"
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
