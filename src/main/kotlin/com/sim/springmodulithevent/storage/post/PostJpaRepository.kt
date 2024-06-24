package com.sim.springmodulithevent.storage.post

import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query

interface PostJpaRepository : JpaRepository<PostEntity, String> {

    @Query("SELECT viewCount FROM PostEntity WHERE id = :id")
    fun getViewCountById(id: String): Int
}