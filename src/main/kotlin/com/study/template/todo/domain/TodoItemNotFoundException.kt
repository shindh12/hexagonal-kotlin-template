package com.study.template.todo.domain

import com.study.template.shared.domain.exception.AbstractNotFoundException

class TodoItemNotFoundException(override val message: String) : AbstractNotFoundException(message) {
}