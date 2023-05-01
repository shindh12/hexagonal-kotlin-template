package com.study.template.todo.application.port.output

import com.study.template.todo.domain.TodoId

interface DeleteTodoItemPort {
    fun delete(id: TodoId)
}