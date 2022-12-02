package com.kshired.boilerplate.clients.client.example

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["com.kshired.boilerplate.clients.client.example"])
@Configuration
internal class ExampleApiConfig
