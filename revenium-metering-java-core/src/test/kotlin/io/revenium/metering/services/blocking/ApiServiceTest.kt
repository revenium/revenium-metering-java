// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.services.blocking

import io.revenium.metering.client.okhttp.ReveniumMeteringOkHttpClient
import io.revenium.metering.models.apis.ApiMeterRequestParams
import io.revenium.metering.models.apis.ApiMeterResponseParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ApiServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun meterRequest() {
        val client = ReveniumMeteringOkHttpClient.builder().apiKey("My API Key").build()
        val apiService = client.apis()

        val meteringResponseResource =
            apiService.meterRequest(
                ApiMeterRequestParams.builder()
                    .transactionId("123e4567-e89b-12d3-a456-426614174000")
                    .contentType("application/json")
                    .credential(
                        "The credential used to access the API.  Visible on the subscriber credentials in page in the Revenium platform."
                    )
                    .method(ApiMeterRequestParams.Method.GET)
                    .remoteHost("192.168.1.1")
                    .requestMessageSize(1024L)
                    .resource("https://api.example.com/resource")
                    .sourceId("5Agqrm:c4917580-281d-48e1-a206-05e595f006ec")
                    .sourceType(ApiMeterRequestParams.SourceType.KONG)
                    .userAgent("Mozilla/5.0")
                    .build()
            )

        meteringResponseResource.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun meterResponse() {
        val client = ReveniumMeteringOkHttpClient.builder().apiKey("My API Key").build()
        val apiService = client.apis()

        val meteringResponseResource =
            apiService.meterResponse(
                ApiMeterResponseParams.builder()
                    .responseCode(200)
                    .transactionId("123e4567-e89b-12d3-a456-426614174000")
                    .backendLatency(1200.0)
                    .contentType("application/json")
                    .gatewayLatency(50.0)
                    .responseMessageSize(1024L)
                    .totalDuration(1500L)
                    .build()
            )

        meteringResponseResource.validate()
    }
}
