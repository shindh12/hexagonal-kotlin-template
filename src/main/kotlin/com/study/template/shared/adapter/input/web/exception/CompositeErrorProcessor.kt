package com.study.template.shared.adapter.input.web.exception

import org.springframework.core.annotation.AnnotationAwareOrderComparator
import org.springframework.http.ProblemDetail

class CompositeErrorProcessor : ErrorProcessor {
    private val processors: List<ErrorProcessor>

    constructor(processors: List<ErrorProcessor>) {
        this.processors = processors.sortedWith(AnnotationAwareOrderComparator.INSTANCE.reversed())
    }

    override fun process(problemDetail: ProblemDetail, throwable: Throwable) {
        processors.forEach { it.process(problemDetail, throwable) }
    }
}