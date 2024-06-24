package com.sim.springmodulithevent.event

import org.springframework.modulith.events.IncompleteEventPublications
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class IncompleteEventRepublicationHandler(
    private val applicationEventMulticaster: IncompleteEventPublications
) {

    // 매 분마다 실행
    @Scheduled(fixedRate = 60000)
    fun resubmitIncompletePublications() {
        applicationEventMulticaster.resubmitIncompletePublications { true }
    }

}