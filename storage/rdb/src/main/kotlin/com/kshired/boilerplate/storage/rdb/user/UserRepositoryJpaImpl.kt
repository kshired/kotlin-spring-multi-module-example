package com.kshired.boilerplate.storage.rdb.user

import com.kshired.boilerplate.domain.user.User
import com.kshired.boilerplate.domain.user.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
internal class UserRepositoryJpaImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {
    override fun findByIdOrNull(id: Long): User? {
        return userJpaRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun create(user: User) {
        userJpaRepository.save(UserEntity.fromDomain(user))
    }
}