package com.kshired.boilerplate.common.error

data class BadRequestException(
    override val message: String
) : Exception(message)
