// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.async

import com.revenium_metering.api.TestServerExtension
import com.revenium_metering.api.client.okhttp.ReveniumMeteringOkHttpClientAsync
import com.revenium_metering.api.core.JsonValue
import com.revenium_metering.api.models.events.EventCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EventServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            ReveniumMeteringOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val eventServiceAsync = client.events()

        val meteringResponseResourceFuture =
            eventServiceAsync.create(
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
            )

        val meteringResponseResource = meteringResponseResourceFuture.get()
        meteringResponseResource.validate()
    }
}
