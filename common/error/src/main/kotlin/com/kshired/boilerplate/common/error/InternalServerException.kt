package com.kshired.boilerplate.common.error

class InternalServerException(
    override val message: String
) : Exception(message)
