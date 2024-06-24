package com.sim.springmodulithevent.storage.post

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Version
import java.time.LocalDateTime

@Entity
@Table(name = "post")
class PostEntity(
    id: String,
    title: String,
    content: String,
    author: String,
    createdAt: LocalDateTime,
    updatedAt: LocalDateTime
) {

    @Id
    @Column(name = "id")
    val id: String = id

    @Column(name = "title")
    val title: String = title

    @Column(name = "content")
    val content: String = content

    @Column(name = "author")
    val author: String = author

    @Column(name = "created_at")
    val createdAt: LocalDateTime = createdAt

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = updatedAt

    var viewCount: Int = 0
        protected set

    @Version
    var version: Int = 0
        protected set

    fun incrementViewCount() {
        viewCount++
    }
}