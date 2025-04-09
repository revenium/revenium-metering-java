// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.services.blocking

import com.revenium_metering.api.TestServerExtension
import com.revenium_metering.api.client.okhttp.ReveniumMeteringOkHttpClient
import com.revenium_metering.api.models.apis.ApiMeterRequestParams
import com.revenium_metering.api.models.apis.ApiMeterResponseParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ApiServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun meterRequest() {
        val client =
            ReveniumMeteringOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
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

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun meterResponse() {
        val client =
            ReveniumMeteringOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val apiService = client.apis()

        val meteringResponseResource =
            apiService.meterResponse(
                ApiMeterResponseParams.builder()
                    .responseCode(200L)
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
