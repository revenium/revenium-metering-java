// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services.blocking

import io.revenium.metering.client.okhttp.ReveniumMeteringOkHttpClient
import io.revenium.metering.models.events.EventCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class EventServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = ReveniumMeteringOkHttpClient.builder().apiKey("My API Key").build()
        val eventService = client.events()

        val meteringResponseResource =
            eventService.create(
                EventCreateParams.builder()
                    .payload("payload")
                    .sourceType(EventCreateParams.SourceType.UNKNOWN)
                    .transactionId("123e4567-e89b-12d3-a456-426614174000")
                    .sourceId("sourceId")
                    .subscriberCredentialId(
                        "The credential associated with the event.  Visible on the subscriber credentials in page in the Revenium platform."
                    )
                    .build()
            )

        meteringResponseResource.validate()
    }
}
