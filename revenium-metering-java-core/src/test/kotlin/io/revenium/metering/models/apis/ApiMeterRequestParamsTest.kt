// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.models.apis

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiMeterRequestParamsTest {

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
            .sourceType(ApiMeterRequestParams.SourceType.KONG)
            .userAgent("Mozilla/5.0")
            .build()
    }

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
                .sourceType(ApiMeterRequestParams.SourceType.KONG)
                .userAgent("Mozilla/5.0")
                .build()

        val body = params._body()

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
        assertThat(body.sourceType()).contains(ApiMeterRequestParams.SourceType.KONG)
        assertThat(body.userAgent()).contains("Mozilla/5.0")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ApiMeterRequestParams.builder()
                .transactionId("123e4567-e89b-12d3-a456-426614174000")
                .build()

        val body = params._body()

        assertThat(body.transactionId()).isEqualTo("123e4567-e89b-12d3-a456-426614174000")
    }
}
