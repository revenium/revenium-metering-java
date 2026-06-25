// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.models.events

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

/** Meter an event */
class EventCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The rating payload as a JSON object. For example, if you are sending key value pairs of
     * 'requestTokens' and 'responseTokens' with values of '1' and '2' respectively, the payload
     * would be { "requestTokens": "1", "responseTokens": "2"}. If these keys do not already exist
     * in Revenium, each key you send will be configured as a metering element on the relevant data
     * source.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun payload(): String = body.payload()

    /**
     * the source type
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun sourceType(): SourceType = body.sourceType()

    /**
     * The unique identifier of the metering event
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun transactionId(): String = body.transactionId()

    /**
     * the sourceId
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun sourceId(): Optional<String> = body.sourceId()

    /**
     * The unique identifier of the credential
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun subscriberCredentialId(): Optional<String> = body.subscriberCredentialId()

    /**
     * Returns the raw JSON value of [payload].
     *
     * Unlike [payload], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _payload(): JsonField<String> = body._payload()

    /**
     * Returns the raw JSON value of [sourceType].
     *
     * Unlike [sourceType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sourceType(): JsonField<SourceType> = body._sourceType()

    /**
     * Returns the raw JSON value of [transactionId].
     *
     * Unlike [transactionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _transactionId(): JsonField<String> = body._transactionId()

    /**
     * Returns the raw JSON value of [sourceId].
     *
     * Unlike [sourceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sourceId(): JsonField<String> = body._sourceId()

    /**
     * Returns the raw JSON value of [subscriberCredentialId].
     *
     * Unlike [subscriberCredentialId], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    fun _subscriberCredentialId(): JsonField<String> = body._subscriberCredentialId()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [EventCreateParams].
         *
         * The following fields are required:
         * ```java
         * .payload()
         * .sourceType()
         * .transactionId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EventCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(eventCreateParams: EventCreateParams) = apply {
            body = eventCreateParams.body.toBuilder()
            additionalHeaders = eventCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = eventCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [payload]
         * - [sourceType]
         * - [transactionId]
         * - [sourceId]
         * - [subscriberCredentialId]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The rating payload as a JSON object. For example, if you are sending key value pairs of
         * 'requestTokens' and 'responseTokens' with values of '1' and '2' respectively, the payload
         * would be { "requestTokens": "1", "responseTokens": "2"}. If these keys do not already
         * exist in Revenium, each key you send will be configured as a metering element on the
         * relevant data source.
         */
        fun payload(payload: String) = apply { body.payload(payload) }

        /**
         * Sets [Builder.payload] to an arbitrary JSON value.
         *
         * You should usually call [Builder.payload] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun payload(payload: JsonField<String>) = apply { body.payload(payload) }

        /** the source type */
        fun sourceType(sourceType: SourceType) = apply { body.sourceType(sourceType) }

        /**
         * Sets [Builder.sourceType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceType] with a well-typed [SourceType] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sourceType(sourceType: JsonField<SourceType>) = apply { body.sourceType(sourceType) }

        /** The unique identifier of the metering event */
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

        /** the sourceId */
        fun sourceId(sourceId: String) = apply { body.sourceId(sourceId) }

        /**
         * Sets [Builder.sourceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sourceId(sourceId: JsonField<String>) = apply { body.sourceId(sourceId) }

        /** The unique identifier of the credential */
        fun subscriberCredentialId(subscriberCredentialId: String) = apply {
            body.subscriberCredentialId(subscriberCredentialId)
        }

        /**
         * Sets [Builder.subscriberCredentialId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subscriberCredentialId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun subscriberCredentialId(subscriberCredentialId: JsonField<String>) = apply {
            body.subscriberCredentialId(subscriberCredentialId)
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
         * Returns an immutable instance of [EventCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .payload()
         * .sourceType()
         * .transactionId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EventCreateParams =
            EventCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** The metering event */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val payload: JsonField<String>,
        private val sourceType: JsonField<SourceType>,
        private val transactionId: JsonField<String>,
        private val sourceId: JsonField<String>,
        private val subscriberCredentialId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("payload") @ExcludeMissing payload: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sourceType")
            @ExcludeMissing
            sourceType: JsonField<SourceType> = JsonMissing.of(),
            @JsonProperty("transactionId")
            @ExcludeMissing
            transactionId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sourceId")
            @ExcludeMissing
            sourceId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("subscriberCredentialId")
            @ExcludeMissing
            subscriberCredentialId: JsonField<String> = JsonMissing.of(),
        ) : this(
            payload,
            sourceType,
            transactionId,
            sourceId,
            subscriberCredentialId,
            mutableMapOf(),
        )

        /**
         * The rating payload as a JSON object. For example, if you are sending key value pairs of
         * 'requestTokens' and 'responseTokens' with values of '1' and '2' respectively, the payload
         * would be { "requestTokens": "1", "responseTokens": "2"}. If these keys do not already
         * exist in Revenium, each key you send will be configured as a metering element on the
         * relevant data source.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun payload(): String = payload.getRequired("payload")

        /**
         * the source type
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun sourceType(): SourceType = sourceType.getRequired("sourceType")

        /**
         * The unique identifier of the metering event
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or
         *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
         *   value).
         */
        fun transactionId(): String = transactionId.getRequired("transactionId")

        /**
         * the sourceId
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun sourceId(): Optional<String> = sourceId.getOptional("sourceId")

        /**
         * The unique identifier of the credential
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun subscriberCredentialId(): Optional<String> =
            subscriberCredentialId.getOptional("subscriberCredentialId")

        /**
         * Returns the raw JSON value of [payload].
         *
         * Unlike [payload], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("payload") @ExcludeMissing fun _payload(): JsonField<String> = payload

        /**
         * Returns the raw JSON value of [sourceType].
         *
         * Unlike [sourceType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sourceType")
        @ExcludeMissing
        fun _sourceType(): JsonField<SourceType> = sourceType

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
         * Returns the raw JSON value of [sourceId].
         *
         * Unlike [sourceId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sourceId") @ExcludeMissing fun _sourceId(): JsonField<String> = sourceId

        /**
         * Returns the raw JSON value of [subscriberCredentialId].
         *
         * Unlike [subscriberCredentialId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("subscriberCredentialId")
        @ExcludeMissing
        fun _subscriberCredentialId(): JsonField<String> = subscriberCredentialId

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
             * .payload()
             * .sourceType()
             * .transactionId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var payload: JsonField<String>? = null
            private var sourceType: JsonField<SourceType>? = null
            private var transactionId: JsonField<String>? = null
            private var sourceId: JsonField<String> = JsonMissing.of()
            private var subscriberCredentialId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                payload = body.payload
                sourceType = body.sourceType
                transactionId = body.transactionId
                sourceId = body.sourceId
                subscriberCredentialId = body.subscriberCredentialId
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The rating payload as a JSON object. For example, if you are sending key value pairs
             * of 'requestTokens' and 'responseTokens' with values of '1' and '2' respectively, the
             * payload would be { "requestTokens": "1", "responseTokens": "2"}. If these keys do not
             * already exist in Revenium, each key you send will be configured as a metering element
             * on the relevant data source.
             */
            fun payload(payload: String) = payload(JsonField.of(payload))

            /**
             * Sets [Builder.payload] to an arbitrary JSON value.
             *
             * You should usually call [Builder.payload] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun payload(payload: JsonField<String>) = apply { this.payload = payload }

            /** the source type */
            fun sourceType(sourceType: SourceType) = sourceType(JsonField.of(sourceType))

            /**
             * Sets [Builder.sourceType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sourceType] with a well-typed [SourceType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sourceType(sourceType: JsonField<SourceType>) = apply {
                this.sourceType = sourceType
            }

            /** The unique identifier of the metering event */
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

            /** the sourceId */
            fun sourceId(sourceId: String) = sourceId(JsonField.of(sourceId))

            /**
             * Sets [Builder.sourceId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sourceId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sourceId(sourceId: JsonField<String>) = apply { this.sourceId = sourceId }

            /** The unique identifier of the credential */
            fun subscriberCredentialId(subscriberCredentialId: String) =
                subscriberCredentialId(JsonField.of(subscriberCredentialId))

            /**
             * Sets [Builder.subscriberCredentialId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subscriberCredentialId] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun subscriberCredentialId(subscriberCredentialId: JsonField<String>) = apply {
                this.subscriberCredentialId = subscriberCredentialId
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
             * .payload()
             * .sourceType()
             * .transactionId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("payload", payload),
                    checkRequired("sourceType", sourceType),
                    checkRequired("transactionId", transactionId),
                    sourceId,
                    subscriberCredentialId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            payload()
            sourceType().validate()
            transactionId()
            sourceId()
            subscriberCredentialId()
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
            (if (payload.asKnown().isPresent) 1 else 0) +
                (sourceType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (transactionId.asKnown().isPresent) 1 else 0) +
                (if (sourceId.asKnown().isPresent) 1 else 0) +
                (if (subscriberCredentialId.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                payload == other.payload &&
                sourceType == other.sourceType &&
                transactionId == other.transactionId &&
                sourceId == other.sourceId &&
                subscriberCredentialId == other.subscriberCredentialId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                payload,
                sourceType,
                transactionId,
                sourceId,
                subscriberCredentialId,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{payload=$payload, sourceType=$sourceType, transactionId=$transactionId, sourceId=$sourceId, subscriberCredentialId=$subscriberCredentialId, additionalProperties=$additionalProperties}"
    }

    /** the source type */
    class SourceType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val UNKNOWN = of("UNKNOWN")

            @JvmField val AI = of("AI")

            @JvmField val SDK_PYTHON = of("SDK_PYTHON")

            @JvmField val SDK_JS = of("SDK_JS")

            @JvmField val SDK_JVM = of("SDK_JVM")

            @JvmField val SDK_SPRING = of("SDK_SPRING")

            @JvmField val SDK_DOTNET = of("SDK_DOTNET")

            @JvmField val SDK_GOLANG = of("SDK_GOLANG")

            @JvmField val SDK_RUST = of("SDK_RUST")

            @JvmField val EBPF = of("EBPF")

            @JvmField val AWS = of("AWS")

            @JvmField val AZURE = of("AZURE")

            @JvmField val SNOWFLAKE = of("SNOWFLAKE")

            @JvmField val KONG = of("KONG")

            @JvmField val GRAVITEE = of("GRAVITEE")

            @JvmField val MULESOFT = of("MULESOFT")

            @JvmField val BOOMI = of("BOOMI")

            @JvmField val REVENIUM = of("REVENIUM")

            @JvmField val INTERNAL = of("INTERNAL")

            @JvmStatic fun of(value: String) = SourceType(JsonField.of(value))
        }

        /** An enum containing [SourceType]'s known values. */
        enum class Known {
            UNKNOWN,
            AI,
            SDK_PYTHON,
            SDK_JS,
            SDK_JVM,
            SDK_SPRING,
            SDK_DOTNET,
            SDK_GOLANG,
            SDK_RUST,
            EBPF,
            AWS,
            AZURE,
            SNOWFLAKE,
            KONG,
            GRAVITEE,
            MULESOFT,
            BOOMI,
            REVENIUM,
            INTERNAL,
        }

        /**
         * An enum containing [SourceType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [SourceType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            UNKNOWN,
            AI,
            SDK_PYTHON,
            SDK_JS,
            SDK_JVM,
            SDK_SPRING,
            SDK_DOTNET,
            SDK_GOLANG,
            SDK_RUST,
            EBPF,
            AWS,
            AZURE,
            SNOWFLAKE,
            KONG,
            GRAVITEE,
            MULESOFT,
            BOOMI,
            REVENIUM,
            INTERNAL,
            /**
             * An enum member indicating that [SourceType] was instantiated with an unknown value.
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
                UNKNOWN -> Value.UNKNOWN
                AI -> Value.AI
                SDK_PYTHON -> Value.SDK_PYTHON
                SDK_JS -> Value.SDK_JS
                SDK_JVM -> Value.SDK_JVM
                SDK_SPRING -> Value.SDK_SPRING
                SDK_DOTNET -> Value.SDK_DOTNET
                SDK_GOLANG -> Value.SDK_GOLANG
                SDK_RUST -> Value.SDK_RUST
                EBPF -> Value.EBPF
                AWS -> Value.AWS
                AZURE -> Value.AZURE
                SNOWFLAKE -> Value.SNOWFLAKE
                KONG -> Value.KONG
                GRAVITEE -> Value.GRAVITEE
                MULESOFT -> Value.MULESOFT
                BOOMI -> Value.BOOMI
                REVENIUM -> Value.REVENIUM
                INTERNAL -> Value.INTERNAL
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
                UNKNOWN -> Known.UNKNOWN
                AI -> Known.AI
                SDK_PYTHON -> Known.SDK_PYTHON
                SDK_JS -> Known.SDK_JS
                SDK_JVM -> Known.SDK_JVM
                SDK_SPRING -> Known.SDK_SPRING
                SDK_DOTNET -> Known.SDK_DOTNET
                SDK_GOLANG -> Known.SDK_GOLANG
                SDK_RUST -> Known.SDK_RUST
                EBPF -> Known.EBPF
                AWS -> Known.AWS
                AZURE -> Known.AZURE
                SNOWFLAKE -> Known.SNOWFLAKE
                KONG -> Known.KONG
                GRAVITEE -> Known.GRAVITEE
                MULESOFT -> Known.MULESOFT
                BOOMI -> Known.BOOMI
                REVENIUM -> Known.REVENIUM
                INTERNAL -> Known.INTERNAL
                else -> throw ReveniumMeteringInvalidDataException("Unknown SourceType: $value")
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

        fun validate(): SourceType = apply {
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

            return other is SourceType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EventCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "EventCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
