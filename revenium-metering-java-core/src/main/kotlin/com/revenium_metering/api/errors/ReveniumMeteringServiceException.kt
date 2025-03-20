// File generated from our OpenAPI spec by Stainless.

package com.revenium_metering.api.errors

import com.revenium_metering.api.core.JsonValue
import com.revenium_metering.api.core.http.Headers

abstract class ReveniumMeteringServiceException
protected constructor(message: String, cause: Throwable? = null) :
    ReveniumMeteringException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
