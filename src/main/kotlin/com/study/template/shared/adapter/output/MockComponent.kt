package com.study.template.shared.adapter.output

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@ConditionalOnProperty(value = ["mock.enabled"], matchIfMissing = true)
@Primary
@Component
annotation class MockComponent(val value: String = "")
