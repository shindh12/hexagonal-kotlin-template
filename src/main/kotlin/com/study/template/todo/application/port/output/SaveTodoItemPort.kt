package com.study.template.todo.application.port.output

import com.study.template.todo.domain.TodoItem

interface SaveTodoItemPort {

    fun save(item: TodoItem)
}