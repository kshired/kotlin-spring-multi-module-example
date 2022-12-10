package com.kshired.boilerplate.domain.user

import com.kshired.boilerplate.common.error.BadRequestException
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userReader: UserReader,
    private val userCreator: UserCreator
) {
    fun findById(id: Long): User {
        return userReader.findByIdOrNull(id)
            ?: throw BadRequestException("$id 를 가진 user를 찾을 수 없습니다.")
    }

    fun createUser(user: User) {
        userCreator.createUser(user)
    }
}