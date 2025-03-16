package com.revenium_metering.api.errors

import com.revenium_metering.api.core.http.Headers

class PermissionDeniedException(headers: Headers, body: String, error: ReveniumMeteringError) :
    ReveniumMeteringServiceException(403, headers, body, error)
