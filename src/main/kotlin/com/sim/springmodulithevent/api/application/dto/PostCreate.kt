package com.sim.springmodulithevent.api.application.dto

import com.sim.springmodulithevent.domain.post.Post

data class PostCreateRequest(
    val title: String,
    val content: String,
    val author: String
){
    fun toPost(): Post {
        return Post(
            title = title,
            content = content,
            author = author
        )
    }
}


