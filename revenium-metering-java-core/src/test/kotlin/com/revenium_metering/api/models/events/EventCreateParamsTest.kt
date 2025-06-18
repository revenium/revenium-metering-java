// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.models.events

import com.revenium_metering.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class EventCreateParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        EventCreateParams.builder()
            .payload(
                EventCreateParams.Payload.builder()
                    .putAdditionalProperty("requestTokens", JsonValue.from(mapOf<String, Any>()))
                    .putAdditionalProperty("responseTokens", JsonValue.from(mapOf<String, Any>()))
                    .build()
            )
            .sourceType(EventCreateParams.SourceType.UNKNOWN)
            .transactionId("123e4567-e89b-12d3-a456-426614174000")
            .sourceId("sourceId")
            .subscriberCredential(
                "The credential associated with the event.  Visible on the subscriber credentials in page in the Revenium platform."
            )
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            EventCreateParams.builder()
                .payload(
                    EventCreateParams.Payload.builder()
                        .putAdditionalProperty(
                            "requestTokens",
                            JsonValue.from(mapOf<String, Any>()),
                        )
                        .putAdditionalProperty(
                            "responseTokens",
                            JsonValue.from(mapOf<String, Any>()),
                        )
                        .build()
                )
                .sourceType(EventCreateParams.SourceType.UNKNOWN)
                .transactionId("123e4567-e89b-12d3-a456-426614174000")
                .sourceId("sourceId")
                .subscriberCredential(
                    "The credential associated with the event.  Visible on the subscriber credentials in page in the Revenium platform."
                )
                .build()

        val body = params._body()

        assertThat(body.payload())
            .isEqualTo(
                EventCreateParams.Payload.builder()
                    .putAdditionalProperty("requestTokens", JsonValue.from(mapOf<String, Any>()))
                    .putAdditionalProperty("responseTokens", JsonValue.from(mapOf<String, Any>()))
                    .build()
            )
        assertThat(body.sourceType()).isEqualTo(EventCreateParams.SourceType.UNKNOWN)
        assertThat(body.transactionId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.sourceId()).contains("sourceId")
        assertThat(body.subscriberCredential())
            .contains(
                "The credential associated with the event.  Visible on the subscriber credentials in page in the Revenium platform."
            )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            EventCreateParams.builder()
                .payload(
                    EventCreateParams.Payload.builder()
                        .putAdditionalProperty(
                            "requestTokens",
                            JsonValue.from(mapOf<String, Any>()),
                        )
                        .putAdditionalProperty(
                            "responseTokens",
                            JsonValue.from(mapOf<String, Any>()),
                        )
                        .build()
                )
                .sourceType(EventCreateParams.SourceType.UNKNOWN)
                .transactionId("123e4567-e89b-12d3-a456-426614174000")
                .build()

        val body = params._body()

        assertThat(body.payload())
            .isEqualTo(
                EventCreateParams.Payload.builder()
                    .putAdditionalProperty("requestTokens", JsonValue.from(mapOf<String, Any>()))
                    .putAdditionalProperty("responseTokens", JsonValue.from(mapOf<String, Any>()))
                    .build()
            )
        assertThat(body.sourceType()).isEqualTo(EventCreateParams.SourceType.UNKNOWN)
        assertThat(body.transactionId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
    }
}
