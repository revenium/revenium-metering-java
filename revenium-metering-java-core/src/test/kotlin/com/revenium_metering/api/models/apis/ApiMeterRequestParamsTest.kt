// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.models.apis

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ApiMeterRequestParamsTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
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
            .sourceType(ApiMeterRequestParams.SourceType.UNKNOWN)
            .userAgent("Mozilla/5.0")
            .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun body() {
        val params =
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
                .sourceType(ApiMeterRequestParams.SourceType.UNKNOWN)
                .userAgent("Mozilla/5.0")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.transactionId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
        assertThat(body.contentType()).contains("application/json")
        assertThat(body.credential())
            .contains(
                "The credential used to access the API.  Visible on the subscriber credentials in page in the Revenium platform."
            )
        assertThat(body.method()).contains(ApiMeterRequestParams.Method.GET)
        assertThat(body.remoteHost()).contains("192.168.1.1")
        assertThat(body.requestMessageSize()).contains(1024L)
        assertThat(body.resource()).contains("https://api.example.com/resource")
        assertThat(body.sourceId()).contains("5Agqrm:c4917580-281d-48e1-a206-05e595f006ec")
        assertThat(body.sourceType()).contains(ApiMeterRequestParams.SourceType.UNKNOWN)
        assertThat(body.userAgent()).contains("Mozilla/5.0")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ApiMeterRequestParams.builder()
                .transactionId("123e4567-e89b-12d3-a456-426614174000")
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.transactionId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
    }
}
