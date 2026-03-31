// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services.async

import io.revenium.metering.client.okhttp.ReveniumMeteringOkHttpClientAsync
import io.revenium.metering.models.events.EventCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class EventServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = ReveniumMeteringOkHttpClientAsync.builder().apiKey("My API Key").build()
        val eventServiceAsync = client.events()

        val meteringResponseResourceFuture =
            eventServiceAsync.create(
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

        val meteringResponseResource = meteringResponseResourceFuture.get()
        meteringResponseResource.validate()
    }
}
