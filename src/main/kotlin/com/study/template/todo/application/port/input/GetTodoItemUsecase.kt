package com.study.template.todo.application.port.input

import com.study.template.shared.application.port.input.InputPort
import com.study.template.todo.domain.TodoId
import com.study.template.todo.domain.TodoItem

interface GetTodoItemUsecase : InputPort {
    fun getTodoItems(): List<TodoItem>
    fun getTodoItem(query: GetTodoItemQuery): TodoItem
    data class GetTodoItemQuery(val id: TodoId) {
        companion object {
            fun from(id: Long): GetTodoItemQuery {
                return GetTodoItemQuery(TodoId(id))
            }
        }
    }
}