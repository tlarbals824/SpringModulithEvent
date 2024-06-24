package com.sim.springmodulithevent.api.application.event

import com.sim.springmodulithevent.common.ModelIdGenerator
import java.util.UUID

data class PostGetEvent(
    val id: String,
    val userId: String = ModelIdGenerator.generateId()
) {
}