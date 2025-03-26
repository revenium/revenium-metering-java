@file:JvmName("JsonHandler")

package com.revenium_metering.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.revenium_metering.api.core.http.HttpResponse
import com.revenium_metering.api.core.http.HttpResponse.Handler
import com.revenium_metering.api.errors.ReveniumMeteringInvalidDataException

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
