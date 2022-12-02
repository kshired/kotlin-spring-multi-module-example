package com.kshired.boilerplate.storage.rdb.user

import com.kshired.boilerplate.domain.user.User
import com.kshired.boilerplate.storage.rdb.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "users")
internal class UserEntity(
    @Column(name = "username")
    val username: String,

    @Column(name = "email")
    val email: String
) : BaseEntity() {
    companion object {
        fun fromDomain(domain: User) : UserEntity {
            return UserEntity(
                username = domain.username,
                email = domain.email
            )
        }
    }

    fun toDomain(): User {
        return User(
            id = id,
            username = username,
            email = email
        )
    }
}
