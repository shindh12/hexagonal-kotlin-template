package com.study.template.shared.domain.exception

abstract class AbstractUnautorizedException(override val message: String) : CustomException(401, message) {
}