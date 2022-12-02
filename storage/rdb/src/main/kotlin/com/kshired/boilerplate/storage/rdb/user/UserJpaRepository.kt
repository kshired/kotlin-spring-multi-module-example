package com.kshired.boilerplate.storage.rdb.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
internal interface UserJpaRepository : JpaRepository<UserEntity, Long>
