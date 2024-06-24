package com.sim.springmodulithevent.api.application

import com.sim.springmodulithevent.api.application.dto.PostCreateRequest
import com.sim.springmodulithevent.domain.post.PostRepository
import org.springframework.boot.env.SpringApplicationJsonEnvironmentPostProcessor
import org.springframework.stereotype.Service

@Service
class PostCreateUseCase(
    private val postRepository: PostRepository
) {

    fun createPost(request: PostCreateRequest) {
        postRepository.save(request.toPost())
    }
}