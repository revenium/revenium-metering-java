package io.revenium.metering.errors

class ReveniumMeteringIoException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) :
    ReveniumMeteringException(message, cause)
