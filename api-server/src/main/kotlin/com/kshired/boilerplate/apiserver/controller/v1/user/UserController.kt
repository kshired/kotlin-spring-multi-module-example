package com.kshired.boilerplate.apiserver.controller.v1.user

import com.kshired.boilerplate.apiserver.controller.v1.user.request.UserCreateRequest
import com.kshired.boilerplate.apiserver.controller.v1.user.response.UserResponse
import com.kshired.boilerplate.domain.user.UserService
import com.kshired.boilerplate.common.util.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping("/{id}")
    fun findUserById(
        @PathVariable("id") id: Long
    ): ApiResponse<UserResponse> {
        val findUser = userService.findById(id)
        return ApiResponse.success(UserResponse.fromDomain(findUser))
    }

    @PostMapping
    fun createUser(
        @RequestBody userCreateRequest: UserCreateRequest
    ): ApiResponse<Boolean> {
        userService.createUser(userCreateRequest.toDomain())
        return ApiResponse.success(true)
    }
}
