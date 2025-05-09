// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.models.apis

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ApiMeterResponseParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        ApiMeterResponseParams.builder()
            .responseCode(200)
            .transactionId("123e4567-e89b-12d3-a456-426614174000")
            .backendLatency(1200.0)
            .contentType("application/json")
            .gatewayLatency(50.0)
            .responseMessageSize(1024L)
            .totalDuration(1500L)
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
            ApiMeterResponseParams.builder()
                .responseCode(200)
                .transactionId("123e4567-e89b-12d3-a456-426614174000")
                .backendLatency(1200.0)
                .contentType("application/json")
                .gatewayLatency(50.0)
                .responseMessageSize(1024L)
                .totalDuration(1500L)
                .build()

        val body = params._body()

        assertThat(body.responseCode()).isEqualTo(200)
        assertThat(body.transactionId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.backendLatency()).contains(1200.0)
        assertThat(body.contentType()).contains("application/json")
        assertThat(body.gatewayLatency()).contains(50.0)
        assertThat(body.responseMessageSize()).contains(1024L)
        assertThat(body.totalDuration()).contains(1500L)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ApiMeterResponseParams.builder()
                .responseCode(200)
                .transactionId("123e4567-e89b-12d3-a456-426614174000")
                .build()

        val body = params._body()

        assertThat(body.responseCode()).isEqualTo(200)
        assertThat(body.transactionId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
    }
}
