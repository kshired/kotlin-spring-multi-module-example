package com.kshired.boilerplate.storage.rdb.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["com.kshired.boilerplate.storage.rdb"])
@EnableJpaRepositories(basePackages = ["com.kshired.boilerplate.storage.rdb"])
internal class MainJpaConfig
