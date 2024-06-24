package com.sim.springmodulithevent.event.post

import com.sim.springmodulithevent.api.application.event.PostGetEvent
import com.sim.springmodulithevent.storage.post.PostJpaRepository
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class PostGetEventHandler(
    private val postJpaRepository: PostJpaRepository
) {

    @ApplicationModuleListener
    fun handle(event: PostGetEvent) {
        logger.info { "Handling event: $event" }
//        throw RuntimeException("This is a test exception")
        postJpaRepository.findByIdOrNull(event.id)?.let {
            it.incrementViewCount()
            postJpaRepository.save(it)
        }
    }
}