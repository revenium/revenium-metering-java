package io.revenium.metering.errors

open class ReveniumMeteringException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
