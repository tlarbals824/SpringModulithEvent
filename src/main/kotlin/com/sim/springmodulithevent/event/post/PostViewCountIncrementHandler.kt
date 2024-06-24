package com.sim.springmodulithevent.event.post

import com.sim.springmodulithevent.api.application.event.PostGetEvent
import com.sim.springmodulithevent.storage.post.PostJpaRepository
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.data.repository.findByIdOrNull
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.modulith.events.EventPublication
import org.springframework.modulith.events.IncompleteEventPublications
import org.springframework.orm.ObjectOptimisticLockingFailureException
import org.springframework.stereotype.Component
import java.time.Duration
import java.util.function.Predicate

private val logger = KotlinLogging.logger {}

@Component
class PostViewCountIncrementHandler(
    private val postJpaRepository: PostJpaRepository
){

    @ApplicationModuleListener
    fun handle(event: PostGetEvent) {
        logger.info { "Handling event: $event" }
//        throw RuntimeException("This is a test exception")
        while(true){
            try{
                postJpaRepository.findByIdOrNull(event.id)?.let {
                    it.incrementViewCount()
                    postJpaRepository.save(it)
                }
                break;
            }catch (e: Exception){
                logger.error { "Error while incrementing view count: $e" }
                Thread.sleep(100)
            }
        }
    }
}