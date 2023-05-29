package com.study.template.todo.application.port.output

import com.study.template.todo.domain.TodoId
import com.study.template.todo.domain.TodoItem

interface GetTodoItemPort {
    fun getTodoItems(): List<TodoItem>
    fun getTodoItem(id: TodoId): TodoItem?
}