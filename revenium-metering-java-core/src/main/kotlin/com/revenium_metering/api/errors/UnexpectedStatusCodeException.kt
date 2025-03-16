package com.revenium_metering.api.errors

import com.revenium_metering.api.core.http.Headers

class UnexpectedStatusCodeException(
    statusCode: Int,
    headers: Headers,
    body: String,
    error: ReveniumMeteringError,
) : ReveniumMeteringServiceException(statusCode, headers, body, error)
