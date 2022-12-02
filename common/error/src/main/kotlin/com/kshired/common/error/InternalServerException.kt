package com.kshired.common.error

class InternalServerException(
    override val message: String
) : Exception(message)
