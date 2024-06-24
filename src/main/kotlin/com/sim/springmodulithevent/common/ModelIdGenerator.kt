package com.sim.springmodulithevent.common

import java.util.*

object ModelIdGenerator {

    fun generateId(): String{
        return UUID.randomUUID().toString()
    }
}