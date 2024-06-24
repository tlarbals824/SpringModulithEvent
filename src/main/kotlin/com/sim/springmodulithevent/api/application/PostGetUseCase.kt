package com.sim.springmodulithevent.api.application

import com.sim.springmodulithevent.api.application.dto.PostGetResponse
import com.sim.springmodulithevent.api.application.event.PostGetEvent
import com.sim.springmodulithevent.domain.post.PostRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PostGetUseCase(
    private val postRepository: PostRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun getPost(id: String): PostGetResponse {
        postRepository.findById(id)?.let {
            applicationEventPublisher.publishEvent(PostGetEvent(it.id))
            return PostGetResponse(
                id = it.id,
                title = it.title,
                content = it.content,
                author = it.author,
                createdAt = it.createdAt.toString(),
                viewCount = postRepository.getViewCount(id)
            )
        } ?: run {
            throw IllegalArgumentException("Post not found")
        }
    }
}