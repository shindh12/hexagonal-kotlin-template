package com.study.template.shared.adapter.input.web.exception

import org.springframework.http.ProblemDetail

interface ErrorProcessor {
    fun process(problemDetail: ProblemDetail, throwable: Throwable)
}
