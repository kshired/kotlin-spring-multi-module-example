package com.kshired.boilerplate.domain.user

import org.springframework.stereotype.Component

@Component
class UserCreator(
    private val userRepository: UserRepository
) {
    fun createUser(user: User) {
        userRepository.create(user)
    }
}