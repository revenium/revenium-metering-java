// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.revenium.metering.client.okhttp.ReveniumMeteringOkHttpClient
import io.revenium.metering.core.JsonValue
import io.revenium.metering.core.jsonMapper
import io.revenium.metering.models.events.MeteringResponseResource
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/revenium-metering-java-core.pro"
            )

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = ReveniumMeteringOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.events()).isNotNull()
        assertThat(client.apis()).isNotNull()
        assertThat(client.ai()).isNotNull()
    }

    @Test
    fun meteringResponseResourceRoundtrip() {
        val jsonMapper = jsonMapper()
        val meteringResponseResource =
            MeteringResponseResource.builder()
                .id("abc123")
                .label("Metering Response")
                .object_("metering")
                .signature("signature123")
                ._links(
                    MeteringResponseResource._Links
                        .builder()
                        .putAdditionalProperty(
                            "foo",
                            JsonValue.from(
                                mapOf(
                                    "deprecation" to "deprecation",
                                    "href" to "href",
                                    "hreflang" to "hreflang",
                                    "name" to "name",
                                    "profile" to "profile",
                                    "templated" to true,
                                    "title" to "title",
                                    "type" to "type",
                                )
                            ),
                        )
                        .build()
                )
                .created("2025-03-02T15:04:05Z")
                .updated("2025-03-02T15:04:06Z")
                .build()

        val roundtrippedMeteringResponseResource =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(meteringResponseResource),
                jacksonTypeRef<MeteringResponseResource>(),
            )

        assertThat(roundtrippedMeteringResponseResource).isEqualTo(meteringResponseResource)
    }
}
