package com.kshired.boilerplate.apiserver.controller.v1.example

import com.kshired.boilerplate.apiserver.controller.v1.example.response.CatFactResponse
import com.kshired.boilerplate.clients.client.example.ExampleClient
import com.kshired.boilerplate.common.util.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/example")
class ExampleController(
    // (예시용) 보통 client를 controller에서 직접 사용하지는 않습니다. service 혹은 구현 계층에서 사용하는게 일반적입니다.
    private val exampleClient: ExampleClient
) {
    @GetMapping("/cat/fact")
    fun getCatFact(): ApiResponse<CatFactResponse> {
        return ApiResponse.success(CatFactResponse(exampleClient.getCatFacts()))
    }
}
