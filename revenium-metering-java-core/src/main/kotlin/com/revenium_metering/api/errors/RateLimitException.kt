package com.revenium_metering.api.errors

import com.revenium_metering.api.core.http.Headers

class RateLimitException(headers: Headers, body: String, error: ReveniumMeteringError) :
    ReveniumMeteringServiceException(429, headers, body, error)
