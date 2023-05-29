package com.study.template.shared.adapter.input.web.exception

import org.springframework.core.Ordered
import org.springframework.http.ProblemDetail


class DebugErrorProcessor : ErrorProcessor, Ordered {
    companion object {
        const val DEBUG_PROPERTY_NAME = "debug"
    }

    override fun process(problemDetail: ProblemDetail, throwable: Throwable) {
        problemDetail.setProperty(DEBUG_PROPERTY_NAME, throwable.stackTraceToString())
    }

    override fun getOrder(): Int {
        return Ordered.LOWEST_PRECEDENCE
    }
}