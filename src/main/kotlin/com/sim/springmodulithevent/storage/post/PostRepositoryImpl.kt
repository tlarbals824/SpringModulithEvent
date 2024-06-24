package com.sim.springmodulithevent.storage.post

import com.sim.springmodulithevent.domain.post.Post
import com.sim.springmodulithevent.domain.post.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class PostRepositoryImpl(
    private val postJpaRepository: PostJpaRepository
) : PostRepository{
    override fun save(post: Post) {
        postJpaRepository.save(PostMapper.toEntity(post))
    }

    override fun findById(id: String): Post? {
        return postJpaRepository.findByIdOrNull(id)?.let { PostMapper.toModel(it) }
    }

    override fun getViewCount(id: String): Int {
        return postJpaRepository.findByIdOrNull(id)?.viewCount ?: 0
    }
}