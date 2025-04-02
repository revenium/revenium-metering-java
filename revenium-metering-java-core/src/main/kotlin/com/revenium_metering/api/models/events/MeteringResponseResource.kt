// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.models.events

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.revenium_metering.api.core.ExcludeMissing
import com.revenium_metering.api.core.JsonField
import com.revenium_metering.api.core.JsonMissing
import com.revenium_metering.api.core.JsonValue
import com.revenium_metering.api.core.checkRequired
import com.revenium_metering.api.core.toImmutable
import com.revenium_metering.api.errors.ReveniumMeteringInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Metering response resource details for the metering API, providing metadata about response
 * creation and validation.
 */
class MeteringResponseResource
private constructor(
    private val id: JsonField<String>,
    private val label: JsonField<String>,
    private val object_: JsonField<String>,
    private val signature: JsonField<String>,
    private val _links: JsonField<_Links>,
    private val created: JsonField<String>,
    private val updated: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("label") @ExcludeMissing label: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<String> = JsonMissing.of(),
        @JsonProperty("signature") @ExcludeMissing signature: JsonField<String> = JsonMissing.of(),
        @JsonProperty("_links") @ExcludeMissing _links: JsonField<_Links> = JsonMissing.of(),
        @JsonProperty("created") @ExcludeMissing created: JsonField<String> = JsonMissing.of(),
        @JsonProperty("updated") @ExcludeMissing updated: JsonField<String> = JsonMissing.of(),
    ) : this(id, label, object_, signature, _links, created, updated, mutableMapOf())

    /**
     * Unique identifier for the metering response
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * A descriptive label for the metering response
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun label(): String = label.getRequired("label")

    /**
     * Type of the object, typically 'metering'
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun object_(): String = object_.getRequired("object")

    /**
     * Signature used for validating the response data
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun signature(): String = signature.getRequired("signature")

    /**
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun _links(): Optional<_Links> = Optional.ofNullable(_links.getNullable("_links"))

    /**
     * ISO8601 formatted timestamp when the response was created
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun created(): Optional<String> = Optional.ofNullable(created.getNullable("created"))

    /**
     * ISO8601 formatted timestamp when the response was last updated
     *
     * @throws ReveniumMeteringInvalidDataException if the JSON field has an unexpected type (e.g.
     *   if the server responded with an unexpected value).
     */
    fun updated(): Optional<String> = Optional.ofNullable(updated.getNullable("updated"))

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [label].
     *
     * Unlike [label], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("label") @ExcludeMissing fun _label(): JsonField<String> = label

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<String> = object_

    /**
     * Returns the raw JSON value of [signature].
     *
     * Unlike [signature], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("signature") @ExcludeMissing fun _signature(): JsonField<String> = signature

    /**
     * Returns the raw JSON value of [_links].
     *
     * Unlike [_links], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("_links") @ExcludeMissing fun __links(): JsonField<_Links> = _links

    /**
     * Returns the raw JSON value of [created].
     *
     * Unlike [created], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created") @ExcludeMissing fun _created(): JsonField<String> = created

    /**
     * Returns the raw JSON value of [updated].
     *
     * Unlike [updated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated") @ExcludeMissing fun _updated(): JsonField<String> = updated

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
         * Returns a mutable builder for constructing an instance of [MeteringResponseResource].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .label()
         * .object_()
         * .signature()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MeteringResponseResource]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var label: JsonField<String>? = null
        private var object_: JsonField<String>? = null
        private var signature: JsonField<String>? = null
        private var _links: JsonField<_Links> = JsonMissing.of()
        private var created: JsonField<String> = JsonMissing.of()
        private var updated: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(meteringResponseResource: MeteringResponseResource) = apply {
            id = meteringResponseResource.id
            label = meteringResponseResource.label
            object_ = meteringResponseResource.object_
            signature = meteringResponseResource.signature
            _links = meteringResponseResource._links
            created = meteringResponseResource.created
            updated = meteringResponseResource.updated
            additionalProperties = meteringResponseResource.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the metering response */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** A descriptive label for the metering response */
        fun label(label: String) = label(JsonField.of(label))

        /**
         * Sets [Builder.label] to an arbitrary JSON value.
         *
         * You should usually call [Builder.label] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun label(label: JsonField<String>) = apply { this.label = label }

        /** Type of the object, typically 'metering' */
        fun object_(object_: String) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

        /** Signature used for validating the response data */
        fun signature(signature: String) = signature(JsonField.of(signature))

        /**
         * Sets [Builder.signature] to an arbitrary JSON value.
         *
         * You should usually call [Builder.signature] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun signature(signature: JsonField<String>) = apply { this.signature = signature }

        fun _links(_links: _Links) = _links(JsonField.of(_links))

        /**
         * Sets [Builder._links] to an arbitrary JSON value.
         *
         * You should usually call [Builder._links] with a well-typed [_Links] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun _links(_links: JsonField<_Links>) = apply { this._links = _links }

        /** ISO8601 formatted timestamp when the response was created */
        fun created(created: String) = created(JsonField.of(created))

        /**
         * Sets [Builder.created] to an arbitrary JSON value.
         *
         * You should usually call [Builder.created] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun created(created: JsonField<String>) = apply { this.created = created }

        /** ISO8601 formatted timestamp when the response was last updated */
        fun updated(updated: String) = updated(JsonField.of(updated))

        /**
         * Sets [Builder.updated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updated] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun updated(updated: JsonField<String>) = apply { this.updated = updated }

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
         * Returns an immutable instance of [MeteringResponseResource].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .label()
         * .object_()
         * .signature()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MeteringResponseResource =
            MeteringResponseResource(
                checkRequired("id", id),
                checkRequired("label", label),
                checkRequired("object_", object_),
                checkRequired("signature", signature),
                _links,
                created,
                updated,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MeteringResponseResource = apply {
        if (validated) {
            return@apply
        }

        id()
        label()
        object_()
        signature()
        _links().ifPresent { it.validate() }
        created()
        updated()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (label.asKnown().isPresent) 1 else 0) +
            (if (object_.asKnown().isPresent) 1 else 0) +
            (if (signature.asKnown().isPresent) 1 else 0) +
            (_links.asKnown().getOrNull()?.validity() ?: 0) +
            (if (created.asKnown().isPresent) 1 else 0) +
            (if (updated.asKnown().isPresent) 1 else 0)

    class _Links
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [_Links]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [_Links]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(_links: _Links) = apply {
                additionalProperties = _links.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [_Links].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): _Links = _Links(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): _Links = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is _Links && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "_Links{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MeteringResponseResource && id == other.id && label == other.label && object_ == other.object_ && signature == other.signature && _links == other._links && created == other.created && updated == other.updated && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, label, object_, signature, _links, created, updated, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MeteringResponseResource{id=$id, label=$label, object_=$object_, signature=$signature, _links=$_links, created=$created, updated=$updated, additionalProperties=$additionalProperties}"
}
