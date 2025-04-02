// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.models.apis

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

/** Meter an API request */
class ApiMeterRequestParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

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
     * The content type of the request
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun contentType(): Optional<String> = body.contentType()

    /**
     * The unique identifier of the credential
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun credential(): Optional<String> = body.credential()

    /**
     * The HTTP method of the request
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun method(): Optional<Method> = body.method()

    /**
     * The IP address for the origin of the request. Used by Revenium to report API usage by
     * geography.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun remoteHost(): Optional<String> = body.remoteHost()

    /**
     * The size of the request message in bytes
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun requestMessageSize(): Optional<Long> = body.requestMessageSize()

    /**
     * Visible in the ‘resource’ field when viewing sources in the revenium application. The
     * resource field (often a full URL or relative URI) can be used to auto-match transactions to
     * existing sources based on the URL/URI accessed in the API call.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun resource(): Optional<String> = body.resource()

    /**
     * Sources are typically individual API endpoints. For existing sources, the ID can be found in
     * the Revenium platform on the sources page or retrieved programmatically via the list sources
     * endpoint. A sourceId is created automatically for new sources.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun sourceId(): Optional<String> = body.sourceId()

    /**
     * Specifies the originating platform or gateway of the metered API traffic. This helps Revenium
     * properly process and categorize incoming metrics according to their source system
     * architecture. If not specified, defaults to 'UNKNOWN'.
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun sourceType(): Optional<SourceType> = body.sourceType()

    /**
     * The user agent of the request
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun userAgent(): Optional<String> = body.userAgent()

    /**
     * Returns the raw JSON value of [transactionId].
     *
     * Unlike [transactionId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _transactionId(): JsonField<String> = body._transactionId()

    /**
     * Returns the raw JSON value of [contentType].
     *
     * Unlike [contentType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _contentType(): JsonField<String> = body._contentType()

    /**
     * Returns the raw JSON value of [credential].
     *
     * Unlike [credential], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _credential(): JsonField<String> = body._credential()

    /**
     * Returns the raw JSON value of [method].
     *
     * Unlike [method], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _method(): JsonField<Method> = body._method()

    /**
     * Returns the raw JSON value of [remoteHost].
     *
     * Unlike [remoteHost], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _remoteHost(): JsonField<String> = body._remoteHost()

    /**
     * Returns the raw JSON value of [requestMessageSize].
     *
     * Unlike [requestMessageSize], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _requestMessageSize(): JsonField<Long> = body._requestMessageSize()

    /**
     * Returns the raw JSON value of [resource].
     *
     * Unlike [resource], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _resource(): JsonField<String> = body._resource()

    /**
     * Returns the raw JSON value of [sourceId].
     *
     * Unlike [sourceId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sourceId(): JsonField<String> = body._sourceId()

    /**
     * Returns the raw JSON value of [sourceType].
     *
     * Unlike [sourceType], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sourceType(): JsonField<SourceType> = body._sourceType()

    /**
     * Returns the raw JSON value of [userAgent].
     *
     * Unlike [userAgent], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _userAgent(): JsonField<String> = body._userAgent()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ApiMeterRequestParams].
         *
         * The following fields are required:
         * ```java
         * .transactionId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ApiMeterRequestParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(apiMeterRequestParams: ApiMeterRequestParams) = apply {
            body = apiMeterRequestParams.body.toBuilder()
            additionalHeaders = apiMeterRequestParams.additionalHeaders.toBuilder()
            additionalQueryParams = apiMeterRequestParams.additionalQueryParams.toBuilder()
        }

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

        /** The unique identifier of the credential */
        fun credential(credential: String) = apply { body.credential(credential) }

        /**
         * Sets [Builder.credential] to an arbitrary JSON value.
         *
         * You should usually call [Builder.credential] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun credential(credential: JsonField<String>) = apply { body.credential(credential) }

        /** The HTTP method of the request */
        fun method(method: Method) = apply { body.method(method) }

        /**
         * Sets [Builder.method] to an arbitrary JSON value.
         *
         * You should usually call [Builder.method] with a well-typed [Method] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun method(method: JsonField<Method>) = apply { body.method(method) }

        /**
         * The IP address for the origin of the request. Used by Revenium to report API usage by
         * geography.
         */
        fun remoteHost(remoteHost: String) = apply { body.remoteHost(remoteHost) }

        /**
         * Sets [Builder.remoteHost] to an arbitrary JSON value.
         *
         * You should usually call [Builder.remoteHost] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun remoteHost(remoteHost: JsonField<String>) = apply { body.remoteHost(remoteHost) }

        /** The size of the request message in bytes */
        fun requestMessageSize(requestMessageSize: Long) = apply {
            body.requestMessageSize(requestMessageSize)
        }

        /**
         * Sets [Builder.requestMessageSize] to an arbitrary JSON value.
         *
         * You should usually call [Builder.requestMessageSize] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun requestMessageSize(requestMessageSize: JsonField<Long>) = apply {
            body.requestMessageSize(requestMessageSize)
        }

        /**
         * Visible in the ‘resource’ field when viewing sources in the revenium application. The
         * resource field (often a full URL or relative URI) can be used to auto-match transactions
         * to existing sources based on the URL/URI accessed in the API call.
         */
        fun resource(resource: String) = apply { body.resource(resource) }

        /**
         * Sets [Builder.resource] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resource] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun resource(resource: JsonField<String>) = apply { body.resource(resource) }

        /**
         * Sources are typically individual API endpoints. For existing sources, the ID can be found
         * in the Revenium platform on the sources page or retrieved programmatically via the list
         * sources endpoint. A sourceId is created automatically for new sources.
         */
        fun sourceId(sourceId: String) = apply { body.sourceId(sourceId) }

        /**
         * Sets [Builder.sourceId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sourceId(sourceId: JsonField<String>) = apply { body.sourceId(sourceId) }

        /**
         * Specifies the originating platform or gateway of the metered API traffic. This helps
         * Revenium properly process and categorize incoming metrics according to their source
         * system architecture. If not specified, defaults to 'UNKNOWN'.
         */
        fun sourceType(sourceType: SourceType) = apply { body.sourceType(sourceType) }

        /**
         * Sets [Builder.sourceType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sourceType] with a well-typed [SourceType] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun sourceType(sourceType: JsonField<SourceType>) = apply { body.sourceType(sourceType) }

        /** The user agent of the request */
        fun userAgent(userAgent: String) = apply { body.userAgent(userAgent) }

        /**
         * Sets [Builder.userAgent] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userAgent] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun userAgent(userAgent: JsonField<String>) = apply { body.userAgent(userAgent) }

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
         * Returns an immutable instance of [ApiMeterRequestParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .transactionId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ApiMeterRequestParams =
            ApiMeterRequestParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** The metadata for the API request */
    class Body
    private constructor(
        private val transactionId: JsonField<String>,
        private val contentType: JsonField<String>,
        private val credential: JsonField<String>,
        private val method: JsonField<Method>,
        private val remoteHost: JsonField<String>,
        private val requestMessageSize: JsonField<Long>,
        private val resource: JsonField<String>,
        private val sourceId: JsonField<String>,
        private val sourceType: JsonField<SourceType>,
        private val userAgent: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("transactionId")
            @ExcludeMissing
            transactionId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("contentType")
            @ExcludeMissing
            contentType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("credential")
            @ExcludeMissing
            credential: JsonField<String> = JsonMissing.of(),
            @JsonProperty("method") @ExcludeMissing method: JsonField<Method> = JsonMissing.of(),
            @JsonProperty("remoteHost")
            @ExcludeMissing
            remoteHost: JsonField<String> = JsonMissing.of(),
            @JsonProperty("requestMessageSize")
            @ExcludeMissing
            requestMessageSize: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("resource")
            @ExcludeMissing
            resource: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sourceId")
            @ExcludeMissing
            sourceId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sourceType")
            @ExcludeMissing
            sourceType: JsonField<SourceType> = JsonMissing.of(),
            @JsonProperty("userAgent")
            @ExcludeMissing
            userAgent: JsonField<String> = JsonMissing.of(),
        ) : this(
            transactionId,
            contentType,
            credential,
            method,
            remoteHost,
            requestMessageSize,
            resource,
            sourceId,
            sourceType,
            userAgent,
            mutableMapOf(),
        )

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
         * The content type of the request
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun contentType(): Optional<String> =
            Optional.ofNullable(contentType.getNullable("contentType"))

        /**
         * The unique identifier of the credential
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun credential(): Optional<String> =
            Optional.ofNullable(credential.getNullable("credential"))

        /**
         * The HTTP method of the request
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun method(): Optional<Method> = Optional.ofNullable(method.getNullable("method"))

        /**
         * The IP address for the origin of the request. Used by Revenium to report API usage by
         * geography.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun remoteHost(): Optional<String> =
            Optional.ofNullable(remoteHost.getNullable("remoteHost"))

        /**
         * The size of the request message in bytes
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun requestMessageSize(): Optional<Long> =
            Optional.ofNullable(requestMessageSize.getNullable("requestMessageSize"))

        /**
         * Visible in the ‘resource’ field when viewing sources in the revenium application. The
         * resource field (often a full URL or relative URI) can be used to auto-match transactions
         * to existing sources based on the URL/URI accessed in the API call.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun resource(): Optional<String> = Optional.ofNullable(resource.getNullable("resource"))

        /**
         * Sources are typically individual API endpoints. For existing sources, the ID can be found
         * in the Revenium platform on the sources page or retrieved programmatically via the list
         * sources endpoint. A sourceId is created automatically for new sources.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun sourceId(): Optional<String> = Optional.ofNullable(sourceId.getNullable("sourceId"))

        /**
         * Specifies the originating platform or gateway of the metered API traffic. This helps
         * Revenium properly process and categorize incoming metrics according to their source
         * system architecture. If not specified, defaults to 'UNKNOWN'.
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun sourceType(): Optional<SourceType> =
            Optional.ofNullable(sourceType.getNullable("sourceType"))

        /**
         * The user agent of the request
         *
         * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type
         *   (e.g. if the server responded with an unexpected value).
         */
        fun userAgent(): Optional<String> = Optional.ofNullable(userAgent.getNullable("userAgent"))

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
         * Returns the raw JSON value of [contentType].
         *
         * Unlike [contentType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("contentType")
        @ExcludeMissing
        fun _contentType(): JsonField<String> = contentType

        /**
         * Returns the raw JSON value of [credential].
         *
         * Unlike [credential], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("credential")
        @ExcludeMissing
        fun _credential(): JsonField<String> = credential

        /**
         * Returns the raw JSON value of [method].
         *
         * Unlike [method], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("method") @ExcludeMissing fun _method(): JsonField<Method> = method

        /**
         * Returns the raw JSON value of [remoteHost].
         *
         * Unlike [remoteHost], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("remoteHost")
        @ExcludeMissing
        fun _remoteHost(): JsonField<String> = remoteHost

        /**
         * Returns the raw JSON value of [requestMessageSize].
         *
         * Unlike [requestMessageSize], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("requestMessageSize")
        @ExcludeMissing
        fun _requestMessageSize(): JsonField<Long> = requestMessageSize

        /**
         * Returns the raw JSON value of [resource].
         *
         * Unlike [resource], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("resource") @ExcludeMissing fun _resource(): JsonField<String> = resource

        /**
         * Returns the raw JSON value of [sourceId].
         *
         * Unlike [sourceId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sourceId") @ExcludeMissing fun _sourceId(): JsonField<String> = sourceId

        /**
         * Returns the raw JSON value of [sourceType].
         *
         * Unlike [sourceType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sourceType")
        @ExcludeMissing
        fun _sourceType(): JsonField<SourceType> = sourceType

        /**
         * Returns the raw JSON value of [userAgent].
         *
         * Unlike [userAgent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("userAgent") @ExcludeMissing fun _userAgent(): JsonField<String> = userAgent

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
             * .transactionId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var transactionId: JsonField<String>? = null
            private var contentType: JsonField<String> = JsonMissing.of()
            private var credential: JsonField<String> = JsonMissing.of()
            private var method: JsonField<Method> = JsonMissing.of()
            private var remoteHost: JsonField<String> = JsonMissing.of()
            private var requestMessageSize: JsonField<Long> = JsonMissing.of()
            private var resource: JsonField<String> = JsonMissing.of()
            private var sourceId: JsonField<String> = JsonMissing.of()
            private var sourceType: JsonField<SourceType> = JsonMissing.of()
            private var userAgent: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                transactionId = body.transactionId
                contentType = body.contentType
                credential = body.credential
                method = body.method
                remoteHost = body.remoteHost
                requestMessageSize = body.requestMessageSize
                resource = body.resource
                sourceId = body.sourceId
                sourceType = body.sourceType
                userAgent = body.userAgent
                additionalProperties = body.additionalProperties.toMutableMap()
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

            /** The unique identifier of the credential */
            fun credential(credential: String) = credential(JsonField.of(credential))

            /**
             * Sets [Builder.credential] to an arbitrary JSON value.
             *
             * You should usually call [Builder.credential] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun credential(credential: JsonField<String>) = apply { this.credential = credential }

            /** The HTTP method of the request */
            fun method(method: Method) = method(JsonField.of(method))

            /**
             * Sets [Builder.method] to an arbitrary JSON value.
             *
             * You should usually call [Builder.method] with a well-typed [Method] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun method(method: JsonField<Method>) = apply { this.method = method }

            /**
             * The IP address for the origin of the request. Used by Revenium to report API usage by
             * geography.
             */
            fun remoteHost(remoteHost: String) = remoteHost(JsonField.of(remoteHost))

            /**
             * Sets [Builder.remoteHost] to an arbitrary JSON value.
             *
             * You should usually call [Builder.remoteHost] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun remoteHost(remoteHost: JsonField<String>) = apply { this.remoteHost = remoteHost }

            /** The size of the request message in bytes */
            fun requestMessageSize(requestMessageSize: Long) =
                requestMessageSize(JsonField.of(requestMessageSize))

            /**
             * Sets [Builder.requestMessageSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestMessageSize] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestMessageSize(requestMessageSize: JsonField<Long>) = apply {
                this.requestMessageSize = requestMessageSize
            }

            /**
             * Visible in the ‘resource’ field when viewing sources in the revenium application. The
             * resource field (often a full URL or relative URI) can be used to auto-match
             * transactions to existing sources based on the URL/URI accessed in the API call.
             */
            fun resource(resource: String) = resource(JsonField.of(resource))

            /**
             * Sets [Builder.resource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.resource] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun resource(resource: JsonField<String>) = apply { this.resource = resource }

            /**
             * Sources are typically individual API endpoints. For existing sources, the ID can be
             * found in the Revenium platform on the sources page or retrieved programmatically via
             * the list sources endpoint. A sourceId is created automatically for new sources.
             */
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
             * Specifies the originating platform or gateway of the metered API traffic. This helps
             * Revenium properly process and categorize incoming metrics according to their source
             * system architecture. If not specified, defaults to 'UNKNOWN'.
             */
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

            /** The user agent of the request */
            fun userAgent(userAgent: String) = userAgent(JsonField.of(userAgent))

            /**
             * Sets [Builder.userAgent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userAgent] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userAgent(userAgent: JsonField<String>) = apply { this.userAgent = userAgent }

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
             * .transactionId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("transactionId", transactionId),
                    contentType,
                    credential,
                    method,
                    remoteHost,
                    requestMessageSize,
                    resource,
                    sourceId,
                    sourceType,
                    userAgent,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            transactionId()
            contentType()
            credential()
            method().ifPresent { it.validate() }
            remoteHost()
            requestMessageSize()
            resource()
            sourceId()
            sourceType().ifPresent { it.validate() }
            userAgent()
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
            (if (transactionId.asKnown().isPresent) 1 else 0) +
                (if (contentType.asKnown().isPresent) 1 else 0) +
                (if (credential.asKnown().isPresent) 1 else 0) +
                (method.asKnown().getOrNull()?.validity() ?: 0) +
                (if (remoteHost.asKnown().isPresent) 1 else 0) +
                (if (requestMessageSize.asKnown().isPresent) 1 else 0) +
                (if (resource.asKnown().isPresent) 1 else 0) +
                (if (sourceId.asKnown().isPresent) 1 else 0) +
                (sourceType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (userAgent.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && transactionId == other.transactionId && contentType == other.contentType && credential == other.credential && method == other.method && remoteHost == other.remoteHost && requestMessageSize == other.requestMessageSize && resource == other.resource && sourceId == other.sourceId && sourceType == other.sourceType && userAgent == other.userAgent && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(transactionId, contentType, credential, method, remoteHost, requestMessageSize, resource, sourceId, sourceType, userAgent, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{transactionId=$transactionId, contentType=$contentType, credential=$credential, method=$method, remoteHost=$remoteHost, requestMessageSize=$requestMessageSize, resource=$resource, sourceId=$sourceId, sourceType=$sourceType, userAgent=$userAgent, additionalProperties=$additionalProperties}"
    }

    /** The HTTP method of the request */
    class Method @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val GET = of("GET")

            @JvmField val POST = of("POST")

            @JvmField val PUT = of("PUT")

            @JvmField val DELETE = of("DELETE")

            @JvmField val PATCH = of("PATCH")

            @JvmField val OPTIONS = of("OPTIONS")

            @JvmField val HEAD = of("HEAD")

            @JvmStatic fun of(value: String) = Method(JsonField.of(value))
        }

        /** An enum containing [Method]'s known values. */
        enum class Known {
            GET,
            POST,
            PUT,
            DELETE,
            PATCH,
            OPTIONS,
            HEAD,
        }

        /**
         * An enum containing [Method]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Method] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            GET,
            POST,
            PUT,
            DELETE,
            PATCH,
            OPTIONS,
            HEAD,
            /** An enum member indicating that [Method] was instantiated with an unknown value. */
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
                GET -> Value.GET
                POST -> Value.POST
                PUT -> Value.PUT
                DELETE -> Value.DELETE
                PATCH -> Value.PATCH
                OPTIONS -> Value.OPTIONS
                HEAD -> Value.HEAD
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
                GET -> Known.GET
                POST -> Known.POST
                PUT -> Known.PUT
                DELETE -> Known.DELETE
                PATCH -> Known.PATCH
                OPTIONS -> Known.OPTIONS
                HEAD -> Known.HEAD
                else -> throw ReveniumMeteringInvalidDataException("Unknown Method: $value")
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

        fun validate(): Method = apply {
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

            return /* spotless:off */ other is Method && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Specifies the originating platform or gateway of the metered API traffic. This helps Revenium
     * properly process and categorize incoming metrics according to their source system
     * architecture. If not specified, defaults to 'UNKNOWN'.
     */
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

            return /* spotless:off */ other is SourceType && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ApiMeterRequestParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ApiMeterRequestParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
