package com.kshired.boilerplate.domain.user

import org.springframework.stereotype.Component

@Component
class UserReader(
    private val userRepository: UserRepository
) {
    fun findByIdOrNull(id: Long): User? {
        return userRepository.findByIdOrNull(id)
    }
}