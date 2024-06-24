package com.sim.springmodulithevent.domain.post

import com.sim.springmodulithevent.common.ModelIdGenerator
import java.time.LocalDateTime

class Post(
    val id: String = ModelIdGenerator.generateId(),
    val title: String,
    val content: String,
    val author: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
}