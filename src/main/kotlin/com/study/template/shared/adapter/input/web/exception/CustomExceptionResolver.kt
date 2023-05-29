package com.study.template.shared.adapter.input.web.exception

import com.study.template.shared.domain.exception.CustomException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ProblemDetail
import org.springframework.web.ErrorResponse

class CustomExceptionResolver(
    processors: List<ErrorProcessor>
) {
    private val log: Logger
    private val processor: ErrorProcessor

    init {
        processor = CompositeErrorProcessor(processors)
        log = LoggerFactory.getLogger(javaClass)
    }

    fun resolve(exception: Throwable): ProblemDetail {
        var problemDetail: ProblemDetail
        when (exception) {
            is ErrorResponse -> problemDetail = exception.body
            is CustomException -> {
                problemDetail = ProblemDetail.forStatus(exception.status)
                problemDetail.type = exception.type()
                problemDetail.title = exception.reason
            }

            else -> {
                problemDetail = ProblemDetail.forStatus(500)
                problemDetail.title = exception.message
            }
        }
        return resolve(problemDetail, exception);
    }

    fun resolve(problemDetail: ProblemDetail, throwable: Throwable): ProblemDetail {
        processor.process(problemDetail, throwable)
        log.debug("error : {}", problemDetail, throwable)
        return problemDetail
    }
}