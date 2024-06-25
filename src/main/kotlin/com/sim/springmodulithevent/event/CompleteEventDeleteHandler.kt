package com.sim.springmodulithevent.event

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.modulith.events.CompletedEventPublications
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.Duration

private val logger = KotlinLogging.logger {  }

@Component
class CompleteEventDeleteHandler(
    private val completeEvent : CompletedEventPublications
) {
    companion object {
        const val DELETE_OLDER_THAN: Long = 1000 * 60 * 60 * 24 * 7 // 7 days
    }

    @Scheduled(cron = "0 0 0 * * ?") // 매일 0시 0분 0초에 실행
    fun deleteEvent() {
        logger.info { "Deleting old events" }
        completeEvent.deletePublicationsOlderThan(Duration.ofMillis(DELETE_OLDER_THAN))
    }
}