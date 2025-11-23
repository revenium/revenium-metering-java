// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.models.events

import io.revenium.metering.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EventCreateParamsTest {

    @Test
    fun create() {
        EventCreateParams.builder()
            .payload(
                EventCreateParams.Payload.builder()
                    .putAdditionalProperty("storageGB", JsonValue.from("bar"))
                    .putAdditionalProperty("apiCalls", JsonValue.from("bar"))
                    .putAdditionalProperty("computeMinutes", JsonValue.from("bar"))
                    .build()
            )
            .transactionId("123e4567-e89b-12d3-a456-426614174000")
            .sourceId("5Agqrm:c4917580-281d-48e1-a206-05e595f006ec")
            .sourceType(EventCreateParams.SourceType.KONG)
            .subscriberCredential("cust_abc123def456")
            .build()
    }

    @Test
    fun body() {
        val params =
            EventCreateParams.builder()
                .payload(
                    EventCreateParams.Payload.builder()
                        .putAdditionalProperty("storageGB", JsonValue.from("bar"))
                        .putAdditionalProperty("apiCalls", JsonValue.from("bar"))
                        .putAdditionalProperty("computeMinutes", JsonValue.from("bar"))
                        .build()
                )
                .transactionId("123e4567-e89b-12d3-a456-426614174000")
                .sourceId("5Agqrm:c4917580-281d-48e1-a206-05e595f006ec")
                .sourceType(EventCreateParams.SourceType.KONG)
                .subscriberCredential("cust_abc123def456")
                .build()

        val body = params._body()

        assertThat(body.payload())
            .isEqualTo(
                EventCreateParams.Payload.builder()
                    .putAdditionalProperty("storageGB", JsonValue.from("bar"))
                    .putAdditionalProperty("apiCalls", JsonValue.from("bar"))
                    .putAdditionalProperty("computeMinutes", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.transactionId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.sourceId()).contains("5Agqrm:c4917580-281d-48e1-a206-05e595f006ec")
        assertThat(body.sourceType()).contains(EventCreateParams.SourceType.KONG)
        assertThat(body.subscriberCredential()).contains("cust_abc123def456")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            EventCreateParams.builder()
                .payload(
                    EventCreateParams.Payload.builder()
                        .putAdditionalProperty("storageGB", JsonValue.from("bar"))
                        .putAdditionalProperty("apiCalls", JsonValue.from("bar"))
                        .putAdditionalProperty("computeMinutes", JsonValue.from("bar"))
                        .build()
                )
                .transactionId("123e4567-e89b-12d3-a456-426614174000")
                .build()

        val body = params._body()

        assertThat(body.payload())
            .isEqualTo(
                EventCreateParams.Payload.builder()
                    .putAdditionalProperty("storageGB", JsonValue.from("bar"))
                    .putAdditionalProperty("apiCalls", JsonValue.from("bar"))
                    .putAdditionalProperty("computeMinutes", JsonValue.from("bar"))
                    .build()
            )
        assertThat(body.transactionId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
    }
}
