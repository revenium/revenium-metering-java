package com.revenium_metering.api.errors

open class ReveniumMeteringException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
