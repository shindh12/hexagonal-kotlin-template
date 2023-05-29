package com.study.template.shared.adapter.input.web.exception

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExceptionHandlingConfiguration {
    @Bean
    fun customExceptionResolver(processors: List<ErrorProcessor>): CustomExceptionResolver {
        return CustomExceptionResolver(processors)
    }

    // FIXME : 개발용에만 적용
    @Bean
    fun debugErrorProcessor(): DebugErrorProcessor {
        return DebugErrorProcessor()
    }


}