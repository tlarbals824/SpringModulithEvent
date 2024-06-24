package com.sim.springmodulithevent.api.presentation

import com.sim.springmodulithevent.api.application.PostCreateUseCase
import com.sim.springmodulithevent.api.application.PostGetUseCase
import com.sim.springmodulithevent.api.application.dto.PostCreateRequest
import com.sim.springmodulithevent.api.application.dto.PostGetResponse
import org.springframework.web.bind.annotation.*

@RestController
class PostController(
    private val postCreateUseCase: PostCreateUseCase,
    private val postGetUseCase: PostGetUseCase
) {

    @PostMapping("/api/posts")
    fun createPost(
        @RequestBody request: PostCreateRequest
    ) {
        postCreateUseCase.createPost(request)
    }

    @GetMapping("/api/posts/{id}")
    fun getPost(
        @PathVariable id: String
    ) : PostGetResponse{
        return postGetUseCase.getPost(id)
    }
}