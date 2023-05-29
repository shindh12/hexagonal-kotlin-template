package com.study.template.shared.domain.exception

abstract class AbstractServerException(override val message: String) : CustomException(500, message) {
}