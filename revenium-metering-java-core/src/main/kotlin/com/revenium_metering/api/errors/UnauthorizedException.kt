package com.revenium_metering.api.errors

import com.revenium_metering.api.core.http.Headers

class UnauthorizedException(headers: Headers, body: String, error: ReveniumMeteringError) :
    ReveniumMeteringServiceException(401, headers, body, error)
