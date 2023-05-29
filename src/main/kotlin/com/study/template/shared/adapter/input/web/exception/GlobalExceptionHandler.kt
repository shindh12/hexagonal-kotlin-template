package com.study.template.shared.adapter.input.web.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatusCode
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class GlobalExceptionHandler(
    val resolver: CustomExceptionResolver
) : ResponseEntityExceptionHandler() {
    @ExceptionHandler(Throwable::class)
    fun handleUnknownException(exception: Throwable): ProblemDetail {
        return resolver.resolve(exception);
    }

    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        statusCode: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val entity = super.handleExceptionInternal(ex, body, headers, statusCode, request)
        entity?.let {
            val pd = it.body
            if (pd is ProblemDetail) {
                val resolve = resolver.resolve(pd, ex)
                return ResponseEntity.status(it.statusCode)
                    .headers(it.headers)
                    .body(resolve)
            }
        }
        return entity
    }
}