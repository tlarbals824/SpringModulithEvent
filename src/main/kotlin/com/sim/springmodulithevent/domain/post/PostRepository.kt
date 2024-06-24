package com.sim.springmodulithevent.domain.post

interface PostRepository {
    fun save(post: Post)

    fun findById(id: String): Post?

    fun getViewCount(id: String): Int
}