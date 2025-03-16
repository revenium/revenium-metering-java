package com.revenium_metering.api.errors

class ReveniumMeteringInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) :
    ReveniumMeteringException(message, cause)
