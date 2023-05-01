package com.study.template.todo.application.port.input

import com.study.template.shared.application.port.input.InputPort
import com.study.template.todo.domain.TodoId

interface DeleteTodoItemUsecase : InputPort {
    fun deleteTodoItem(command: DeleteTodoItemCommand)
    data class DeleteTodoItemCommand(val id: TodoId) {
        companion object {
            fun from(id: Long): DeleteTodoItemCommand {
                return DeleteTodoItemCommand(TodoId(id))
            }
        }
    }
}