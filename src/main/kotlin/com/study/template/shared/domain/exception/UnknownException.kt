package com.study.template.shared.domain.exception

class UnknownException(override val message: String) : AbstractServerException(message) {
}