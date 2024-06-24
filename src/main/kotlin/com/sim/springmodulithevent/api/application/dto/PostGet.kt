package com.sim.springmodulithevent.api.application.dto

data class PostGetResponse(
    val id: String,
    val title: String,
    val content: String,
    val author: String,
    val createdAt: String,
    val viewCount: Int
)