// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.async

import com.revenium_metering.api.TestServerExtension
import com.revenium_metering.api.client.okhttp.ReveniumMeteringOkHttpClientAsync
import com.revenium_metering.api.models.events.EventCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class EventServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
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
