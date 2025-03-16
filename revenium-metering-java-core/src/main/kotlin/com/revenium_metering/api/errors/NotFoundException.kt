package com.revenium_metering.api.errors

import com.revenium_metering.api.core.http.Headers

class NotFoundException(headers: Headers, body: String, error: ReveniumMeteringError) :
    ReveniumMeteringServiceException(404, headers, body, error)
