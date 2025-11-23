@file:JvmName("JsonHandler")

package io.revenium.metering.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import io.revenium.metering.core.http.HttpResponse
import io.revenium.metering.core.http.HttpResponse.Handler
import io.revenium.metering.errors.ReveniumMeteringInvalidDataException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw ReveniumMeteringInvalidDataException("Error reading response", e)
            }
    }
