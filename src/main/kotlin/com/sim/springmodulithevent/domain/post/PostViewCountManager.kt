package com.sim.springmodulithevent.domain.post

import org.springframework.stereotype.Component

@Component
class PostViewCountManager(
    private val postRepository: PostRepository
) {
    fun increaseViewCount(id: String) {
        postRepository.incrementViewCount(id)
    }
}