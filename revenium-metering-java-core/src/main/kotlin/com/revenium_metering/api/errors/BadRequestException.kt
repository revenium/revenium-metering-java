package com.revenium_metering.api.errors

import com.revenium_metering.api.core.http.Headers

class BadRequestException(headers: Headers, body: String, error: ReveniumMeteringError) :
    ReveniumMeteringServiceException(400, headers, body, error)
