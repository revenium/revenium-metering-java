package com.revenium_metering.api.errors

import com.revenium_metering.api.core.http.Headers

class UnprocessableEntityException(headers: Headers, body: String, error: ReveniumMeteringError) :
    ReveniumMeteringServiceException(422, headers, body, error)
