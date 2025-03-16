package com.revenium_metering.api.errors

import com.revenium_metering.api.core.http.Headers

abstract class ReveniumMeteringServiceException
@JvmOverloads
constructor(
    private val statusCode: Int,
    private val headers: Headers,
    private val body: String,
    private val error: ReveniumMeteringError,
    message: String = "$statusCode: $error",
    cause: Throwable? = null,
) : ReveniumMeteringException(message, cause) {

    fun statusCode(): Int = statusCode

    fun headers(): Headers = headers

    fun body(): String = body

    fun error(): ReveniumMeteringError = error
}
