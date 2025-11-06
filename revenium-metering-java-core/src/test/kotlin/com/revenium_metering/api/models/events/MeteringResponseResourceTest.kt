// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.models.events

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.revenium_metering.api.core.JsonValue
import com.revenium_metering.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MeteringResponseResourceTest {

    @Test
    fun create() {
        val meteringResponseResource =
            MeteringResponseResource.builder()
                .id("abc123")
                .label("metered-event")
                .resourceType("metered-event")
                .signature("signature123")
                ._links(
                    MeteringResponseResource._Links
                        .builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "deprecation" to "deprecation",
                                    "href" to "href",
                                    "hreflang" to "hreflang",
                                    "name" to "name",
                                    "profile" to "profile",
                                    "templated" to true,
                                    "title" to "title",
                                    "type" to "type",
                                )
                            ),
                        )
                        .build()
                )
                .created("2025-03-02T15:04:05Z")
                .updated("2025-03-02T15:04:06Z")
                .build()

        assertThat(meteringResponseResource.id()).isEqualTo("abc123")
        assertThat(meteringResponseResource.label()).isEqualTo("metered-event")
        assertThat(meteringResponseResource.resourceType()).isEqualTo("metered-event")
        assertThat(meteringResponseResource.signature()).isEqualTo("signature123")
        assertThat(meteringResponseResource._links())
            .contains(
                MeteringResponseResource._Links
                    .builder()
                    .putAdditionalProperty(
                        "foo",
                        JsonValue.from(
                            mapOf(
                                "deprecation" to "deprecation",
                                "href" to "href",
                                "hreflang" to "hreflang",
                                "name" to "name",
                                "profile" to "profile",
                                "templated" to true,
                                "title" to "title",
                                "type" to "type",
                            )
                        ),
                    )
                    .build()
            )
        assertThat(meteringResponseResource.created()).contains("2025-03-02T15:04:05Z")
        assertThat(meteringResponseResource.updated()).contains("2025-03-02T15:04:06Z")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val meteringResponseResource =
            MeteringResponseResource.builder()
                .id("abc123")
                .label("metered-event")
                .resourceType("metered-event")
                .signature("signature123")
                ._links(
                    MeteringResponseResource._Links
                        .builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "deprecation" to "deprecation",
                                    "href" to "href",
                                    "hreflang" to "hreflang",
                                    "name" to "name",
                                    "profile" to "profile",
                                    "templated" to true,
                                    "title" to "title",
                                    "type" to "type",
                                )
                            ),
                        )
                        .build()
                )
                .created("2025-03-02T15:04:05Z")
                .updated("2025-03-02T15:04:06Z")
                .build()

        val roundtrippedMeteringResponseResource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(meteringResponseResource),
                jacksonTypeRef<MeteringResponseResource>(),
            )

        assertThat(roundtrippedMeteringResponseResource).isEqualTo(meteringResponseResource)
    }
}
