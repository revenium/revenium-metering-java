// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.models.apis

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
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

/** Meter an API response */
class ApiMeterResponseParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The HTTP status code of the response
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun responseCode(): Long = body.responseCode()

    /**
     * A client-supplied unique identifier used to correlate request and response pairs across
     * /meter/v2/apis/requests and /meter/v2/apis/response endpoints. Must be consistent between
     * related API calls to ensure proper usage tracking and analytics.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transactionId(): String = body.transactionId()

    /**
     * The latency introduced by backend services in milliseconds
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun backendLatency(): Optional<Double> = body.backendLatency()

    /**
     * The content type of the request
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun contentType(): Optional<String> = body.contentType()

    /**
     * The latency introduced by the gateway in milliseconds
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun gatewayLatency(): Optional<Double> = body.gatewayLatency()

    /**
     * The size of the response message in bytes
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun responseMessageSize(): Optional<Long> = body.responseMessageSize()

    /**
     * The total duration of the request processing in milliseconds
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun totalDuration(): Optional<Long> = body.totalDuration()

    /**
     * Returns the raw JSON value of [responseCode].
     *
     * Unlike [responseCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _responseCode(): JsonField<Long> = body._responseCode()

    /**
     * Returns the raw JSON value of [transactionId].
     *
     * Unlike [transactionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _transactionId(): JsonField<String> = body._transactionId()

    /**
     * Returns the raw JSON value of [backendLatency].
     *
     * Unlike [backendLatency], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _backendLatency(): JsonField<Double> = body._backendLatency()

    /**
     * Returns the raw JSON value of [contentType].
     *
     * Unlike [contentType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _contentType(): JsonField<String> = body._contentType()

    /**
     * Returns the raw JSON value of [gatewayLatency].
     *
     * Unlike [gatewayLatency], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _gatewayLatency(): JsonField<Double> = body._gatewayLatency()

    /**
     * Returns the raw JSON value of [responseMessageSize].
     *
     * Unlike [responseMessageSize], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _responseMessageSize(): JsonField<Long> = body._responseMessageSize()

    /**
     * Returns the raw JSON value of [totalDuration].
     *
     * Unlike [totalDuration], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _totalDuration(): JsonField<Long> = body._totalDuration()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ApiMeterResponseParams].
         *
         * The following fields are required:
         * ```java
         * .responseCode()
         * .transactionId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ApiMeterResponseParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(apiMeterResponseParams: ApiMeterResponseParams) = apply {
            body = apiMeterResponseParams.body.toBuilder()
            additionalHeaders = apiMeterResponseParams.additionalHeaders.toBuilder()
            additionalQueryParams = apiMeterResponseParams.additionalQueryParams.toBuilder()
        }

        /** The HTTP status code of the response */
        fun responseCode(responseCode: Long) = apply { body.responseCode(responseCode) }

        /**
         * Sets [Builder.responseCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseCode] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun responseCode(responseCode: JsonField<Long>) = apply { body.responseCode(responseCode) }

        /**
         * A client-supplied unique identifier used to correlate request and response pairs across
         * /meter/v2/apis/requests and /meter/v2/apis/response endpoints. Must be consistent between
         * related API calls to ensure proper usage tracking and analytics.
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

        /** The latency introduced by backend services in milliseconds */
        fun backendLatency(backendLatency: Double) = apply { body.backendLatency(backendLatency) }

        /**
         * Sets [Builder.backendLatency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.backendLatency] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun backendLatency(backendLatency: JsonField<Double>) = apply {
            body.backendLatency(backendLatency)
        }

        /** The content type of the request */
        fun contentType(contentType: String) = apply { body.contentType(contentType) }

        /**
         * Sets [Builder.contentType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.contentType] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun contentType(contentType: JsonField<String>) = apply { body.contentType(contentType) }

        /** The latency introduced by the gateway in milliseconds */
        fun gatewayLatency(gatewayLatency: Double) = apply { body.gatewayLatency(gatewayLatency) }

        /**
         * Sets [Builder.gatewayLatency] to an arbitrary JSON value.
         *
         * You should usually call [Builder.gatewayLatency] with a well-typed [Double] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun gatewayLatency(gatewayLatency: JsonField<Double>) = apply {
            body.gatewayLatency(gatewayLatency)
        }

        /** The size of the response message in bytes */
        fun responseMessageSize(responseMessageSize: Long) = apply {
            body.responseMessageSize(responseMessageSize)
        }

        /**
         * Sets [Builder.responseMessageSize] to an arbitrary JSON value.
         *
         * You should usually call [Builder.responseMessageSize] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun responseMessageSize(responseMessageSize: JsonField<Long>) = apply {
            body.responseMessageSize(responseMessageSize)
        }

        /** The total duration of the request processing in milliseconds */
        fun totalDuration(totalDuration: Long) = apply { body.totalDuration(totalDuration) }

        /**
         * Sets [Builder.totalDuration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totalDuration] with a well-typed [Long] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun totalDuration(totalDuration: JsonField<Long>) = apply {
            body.totalDuration(totalDuration)
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
         * Returns an immutable instance of [ApiMeterResponseParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .responseCode()
         * .transactionId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ApiMeterResponseParams =
            ApiMeterResponseParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** The metadata for the API response */
    class Body
    private constructor(
        private val responseCode: JsonField<Long>,
        private val transactionId: JsonField<String>,
        private val backendLatency: JsonField<Double>,
        private val contentType: JsonField<String>,
        private val gatewayLatency: JsonField<Double>,
        private val responseMessageSize: JsonField<Long>,
        private val totalDuration: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("responseCode")
            @ExcludeMissing
            responseCode: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("transactionId")
            @ExcludeMissing
            transactionId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("backendLatency")
            @ExcludeMissing
            backendLatency: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("contentType")
            @ExcludeMissing
            contentType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("gatewayLatency")
            @ExcludeMissing
            gatewayLatency: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("responseMessageSize")
            @ExcludeMissing
            responseMessageSize: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("totalDuration")
            @ExcludeMissing
            totalDuration: JsonField<Long> = JsonMissing.of(),
        ) : this(
            responseCode,
            transactionId,
            backendLatency,
            contentType,
            gatewayLatency,
            responseMessageSize,
            totalDuration,
            mutableMapOf(),
        )

        /**
         * The HTTP status code of the response
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun responseCode(): Long = responseCode.getRequired("responseCode")

        /**
         * A client-supplied unique identifier used to correlate request and response pairs across
         * /meter/v2/apis/requests and /meter/v2/apis/response endpoints. Must be consistent between
         * related API calls to ensure proper usage tracking and analytics.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun transactionId(): String = transactionId.getRequired("transactionId")

        /**
         * The latency introduced by backend services in milliseconds
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun backendLatency(): Optional<Double> =
            Optional.ofNullable(backendLatency.getNullable("backendLatency"))

        /**
         * The content type of the request
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun contentType(): Optional<String> =
            Optional.ofNullable(contentType.getNullable("contentType"))

        /**
         * The latency introduced by the gateway in milliseconds
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun gatewayLatency(): Optional<Double> =
            Optional.ofNullable(gatewayLatency.getNullable("gatewayLatency"))

        /**
         * The size of the response message in bytes
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun responseMessageSize(): Optional<Long> =
            Optional.ofNullable(responseMessageSize.getNullable("responseMessageSize"))

        /**
         * The total duration of the request processing in milliseconds
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun totalDuration(): Optional<Long> =
            Optional.ofNullable(totalDuration.getNullable("totalDuration"))

        /**
         * Returns the raw JSON value of [responseCode].
         *
         * Unlike [responseCode], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("responseCode")
        @ExcludeMissing
        fun _responseCode(): JsonField<Long> = responseCode

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
         * Returns the raw JSON value of [backendLatency].
         *
         * Unlike [backendLatency], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("backendLatency")
        @ExcludeMissing
        fun _backendLatency(): JsonField<Double> = backendLatency

        /**
         * Returns the raw JSON value of [contentType].
         *
         * Unlike [contentType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("contentType")
        @ExcludeMissing
        fun _contentType(): JsonField<String> = contentType

        /**
         * Returns the raw JSON value of [gatewayLatency].
         *
         * Unlike [gatewayLatency], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("gatewayLatency")
        @ExcludeMissing
        fun _gatewayLatency(): JsonField<Double> = gatewayLatency

        /**
         * Returns the raw JSON value of [responseMessageSize].
         *
         * Unlike [responseMessageSize], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("responseMessageSize")
        @ExcludeMissing
        fun _responseMessageSize(): JsonField<Long> = responseMessageSize

        /**
         * Returns the raw JSON value of [totalDuration].
         *
         * Unlike [totalDuration], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("totalDuration")
        @ExcludeMissing
        fun _totalDuration(): JsonField<Long> = totalDuration

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
             * .responseCode()
             * .transactionId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var responseCode: JsonField<Long>? = null
            private var transactionId: JsonField<String>? = null
            private var backendLatency: JsonField<Double> = JsonMissing.of()
            private var contentType: JsonField<String> = JsonMissing.of()
            private var gatewayLatency: JsonField<Double> = JsonMissing.of()
            private var responseMessageSize: JsonField<Long> = JsonMissing.of()
            private var totalDuration: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                responseCode = body.responseCode
                transactionId = body.transactionId
                backendLatency = body.backendLatency
                contentType = body.contentType
                gatewayLatency = body.gatewayLatency
                responseMessageSize = body.responseMessageSize
                totalDuration = body.totalDuration
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The HTTP status code of the response */
            fun responseCode(responseCode: Long) = responseCode(JsonField.of(responseCode))

            /**
             * Sets [Builder.responseCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.responseCode] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun responseCode(responseCode: JsonField<Long>) = apply {
                this.responseCode = responseCode
            }

            /**
             * A client-supplied unique identifier used to correlate request and response pairs
             * across /meter/v2/apis/requests and /meter/v2/apis/response endpoints. Must be
             * consistent between related API calls to ensure proper usage tracking and analytics.
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

            /** The latency introduced by backend services in milliseconds */
            fun backendLatency(backendLatency: Double) =
                backendLatency(JsonField.of(backendLatency))

            /**
             * Sets [Builder.backendLatency] to an arbitrary JSON value.
             *
             * You should usually call [Builder.backendLatency] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun backendLatency(backendLatency: JsonField<Double>) = apply {
                this.backendLatency = backendLatency
            }

            /** The content type of the request */
            fun contentType(contentType: String) = contentType(JsonField.of(contentType))

            /**
             * Sets [Builder.contentType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contentType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun contentType(contentType: JsonField<String>) = apply {
                this.contentType = contentType
            }

            /** The latency introduced by the gateway in milliseconds */
            fun gatewayLatency(gatewayLatency: Double) =
                gatewayLatency(JsonField.of(gatewayLatency))

            /**
             * Sets [Builder.gatewayLatency] to an arbitrary JSON value.
             *
             * You should usually call [Builder.gatewayLatency] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun gatewayLatency(gatewayLatency: JsonField<Double>) = apply {
                this.gatewayLatency = gatewayLatency
            }

            /** The size of the response message in bytes */
            fun responseMessageSize(responseMessageSize: Long) =
                responseMessageSize(JsonField.of(responseMessageSize))

            /**
             * Sets [Builder.responseMessageSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.responseMessageSize] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun responseMessageSize(responseMessageSize: JsonField<Long>) = apply {
                this.responseMessageSize = responseMessageSize
            }

            /** The total duration of the request processing in milliseconds */
            fun totalDuration(totalDuration: Long) = totalDuration(JsonField.of(totalDuration))

            /**
             * Sets [Builder.totalDuration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalDuration] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalDuration(totalDuration: JsonField<Long>) = apply {
                this.totalDuration = totalDuration
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
             * .responseCode()
             * .transactionId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("responseCode", responseCode),
                    checkRequired("transactionId", transactionId),
                    backendLatency,
                    contentType,
                    gatewayLatency,
                    responseMessageSize,
                    totalDuration,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            responseCode()
            transactionId()
            backendLatency()
            contentType()
            gatewayLatency()
            responseMessageSize()
            totalDuration()
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
            (if (responseCode.asKnown().isPresent) 1 else 0) +
                (if (transactionId.asKnown().isPresent) 1 else 0) +
                (if (backendLatency.asKnown().isPresent) 1 else 0) +
                (if (contentType.asKnown().isPresent) 1 else 0) +
                (if (gatewayLatency.asKnown().isPresent) 1 else 0) +
                (if (responseMessageSize.asKnown().isPresent) 1 else 0) +
                (if (totalDuration.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && responseCode == other.responseCode && transactionId == other.transactionId && backendLatency == other.backendLatency && contentType == other.contentType && gatewayLatency == other.gatewayLatency && responseMessageSize == other.responseMessageSize && totalDuration == other.totalDuration && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(responseCode, transactionId, backendLatency, contentType, gatewayLatency, responseMessageSize, totalDuration, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{responseCode=$responseCode, transactionId=$transactionId, backendLatency=$backendLatency, contentType=$contentType, gatewayLatency=$gatewayLatency, responseMessageSize=$responseMessageSize, totalDuration=$totalDuration, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ApiMeterResponseParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ApiMeterResponseParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
