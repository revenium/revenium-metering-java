@file:JvmName("ErrorHandler")

package com.revenium_metering.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.revenium_metering.api.core.http.Headers
import com.revenium_metering.api.core.http.HttpResponse
import com.revenium_metering.api.core.http.HttpResponse.Handler
import com.revenium_metering.api.errors.BadRequestException
import com.revenium_metering.api.errors.InternalServerException
import com.revenium_metering.api.errors.NotFoundException
import com.revenium_metering.api.errors.PermissionDeniedException
import com.revenium_metering.api.errors.RateLimitException
import com.revenium_metering.api.errors.ReveniumMeteringError
import com.revenium_metering.api.errors.UnauthorizedException
import com.revenium_metering.api.errors.UnexpectedStatusCodeException
import com.revenium_metering.api.errors.UnprocessableEntityException
import java.io.ByteArrayInputStream
import java.io.InputStream

@JvmSynthetic
internal fun errorHandler(jsonMapper: JsonMapper): Handler<ReveniumMeteringError> {
    val handler = jsonHandler<ReveniumMeteringError>(jsonMapper)

    return object : Handler<ReveniumMeteringError> {
        override fun handle(response: HttpResponse): ReveniumMeteringError =
            try {
                handler.handle(response)
            } catch (e: Exception) {
                ReveniumMeteringError.builder().build()
            }
    }
}

@JvmSynthetic
internal fun <T> Handler<T>.withErrorHandler(
    errorHandler: Handler<ReveniumMeteringError>
): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            when (val statusCode = response.statusCode()) {
                in 200..299 -> {
                    return this@withErrorHandler.handle(response)
                }
                400 -> {
                    val buffered = response.buffered()
                    throw BadRequestException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                401 -> {
                    val buffered = response.buffered()
                    throw UnauthorizedException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                403 -> {
                    val buffered = response.buffered()
                    throw PermissionDeniedException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                404 -> {
                    val buffered = response.buffered()
                    throw NotFoundException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                422 -> {
                    val buffered = response.buffered()
                    throw UnprocessableEntityException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                429 -> {
                    val buffered = response.buffered()
                    throw RateLimitException(
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                in 500..599 -> {
                    val buffered = response.buffered()
                    throw InternalServerException(
                        statusCode,
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
                else -> {
                    val buffered = response.buffered()
                    throw UnexpectedStatusCodeException(
                        statusCode,
                        buffered.headers(),
                        stringHandler().handle(buffered),
                        errorHandler.handle(buffered),
                    )
                }
            }
        }
    }

private fun HttpResponse.buffered(): HttpResponse {
    val body = body().readBytes()

    return object : HttpResponse {
        override fun statusCode(): Int = this@buffered.statusCode()

        override fun headers(): Headers = this@buffered.headers()

        override fun body(): InputStream = ByteArrayInputStream(body)

        override fun close() = this@buffered.close()
    }
}
