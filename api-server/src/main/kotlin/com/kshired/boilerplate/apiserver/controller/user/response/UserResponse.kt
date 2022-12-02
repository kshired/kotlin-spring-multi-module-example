package com.kshired.boilerplate.apiserver.controller.user.response

import com.kshired.boilerplate.domain.user.User

data class UserResponse(
    val id: Long,
    val username: String,
    val email: String
) {
    companion object {
        fun fromDomain(domain: User): UserResponse {
            return UserResponse(
                id = domain.id,
                username = domain.username,
                email = domain.email
            )
        }
    }
}
