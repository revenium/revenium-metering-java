// File generated from our OpenAPI spec by Stainless.

package io.revenium.metering.errors

import io.revenium.metering.core.JsonValue
import io.revenium.metering.core.http.Headers

abstract class ReveniumMeteringServiceException
protected constructor(message: String, cause: Throwable? = null) :
    ReveniumMeteringException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
