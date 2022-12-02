package com.kshired.boilerplate.domain.user

interface UserRepository {
    fun findByIdOrNull(id: Long): User?

    fun create(user: User)
}