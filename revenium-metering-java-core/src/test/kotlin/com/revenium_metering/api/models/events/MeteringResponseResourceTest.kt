// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.models.events

import com.revenium_metering.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MeteringResponseResourceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createMeteringResponseResource() {
        val meteringResponseResource =
            MeteringResponseResource.builder()
                .id("abc123")
                .label("Metering Response")
                .object_("metering")
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
        assertThat(meteringResponseResource).isNotNull
        assertThat(meteringResponseResource.id()).isEqualTo("abc123")
        assertThat(meteringResponseResource.label()).isEqualTo("Metering Response")
        assertThat(meteringResponseResource.object_()).isEqualTo("metering")
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
}
