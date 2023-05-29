package com.study.template.shared.domain.exception

abstract class AbstractNotFoundException(override val message: String) : CustomException(404, message) {
}