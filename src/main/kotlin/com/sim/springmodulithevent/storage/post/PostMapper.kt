package com.sim.springmodulithevent.storage.post

import com.sim.springmodulithevent.domain.post.Post

object PostMapper {

    fun toEntity(post: Post): PostEntity {
        return PostEntity(
            id = post.id,
            title = post.title,
            content = post.content,
            author = post.author,
            createdAt = post.createdAt,
            updatedAt = post.updatedAt
        )
    }

    fun toModel(postEntity: PostEntity): Post {
        return Post(
            id = postEntity.id,
            title = postEntity.title,
            content = postEntity.content,
            author = postEntity.author,
            createdAt = postEntity.createdAt,
            updatedAt = postEntity.updatedAt
        )
    }
}