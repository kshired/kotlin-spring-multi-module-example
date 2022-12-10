package com.kshired.boilerplate.apiserver.support.error

import com.kshired.boilerplate.common.error.BadRequestException
import com.kshired.boilerplate.common.error.InternalServerException
import com.kshired.boilerplate.common.util.response.ApiResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {
    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(e: BadRequestException): ApiResponse<Unit> {
        logger.warn(e.message, e)
        return ApiResponse.fail(e.message)
    }

    @ExceptionHandler(InternalServerException::class)
    fun handleInternalServerException(e: InternalServerException): ApiResponse<Unit> {
        logger.error(e.message, e)
        return ApiResponse.error(e.message)
    }

    @ExceptionHandler(Exception::class)
    fun handleUnknownException(e: Exception): ApiResponse<Unit> {
        logger.error(e.message, e)
        return ApiResponse.error("서버에서 알 수 없는 에러가 발생했습니다.")
    }
}