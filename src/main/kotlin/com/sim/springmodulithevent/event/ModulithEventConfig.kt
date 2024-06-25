package com.sim.springmodulithevent.event

import org.springframework.beans.factory.ObjectProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.time.Clock
import java.time.ZoneId
import java.util.function.Consumer

@Configuration
class ModulithEventConfig {

    @Bean
    @Primary
    fun customClock() : Clock {
        return Clock.system(ZoneId.of("Asia/Seoul"))
    }


}