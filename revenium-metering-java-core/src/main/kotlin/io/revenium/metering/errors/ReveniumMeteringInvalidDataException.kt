package io.revenium.metering.errors

class ReveniumMeteringInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) :
    ReveniumMeteringException(message, cause)
