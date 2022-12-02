package com.kshired.common.error

data class BadRequestException(
    override val message: String
) : Exception(message)
