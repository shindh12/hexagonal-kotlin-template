package com.study.template.todo.application.port.input

import com.study.template.shared.application.port.input.InputPort
import com.study.template.todo.domain.TodoId
import com.study.template.todo.domain.TodoStatus

interface UpdateTodoStatusUsecase : InputPort {

    fun updateStatus(command: UpdateTodoStatusCommand)

    data class UpdateTodoStatusCommand(val id: TodoId, val status: TodoStatus) {
        companion object {
            fun from(id: Long, status: Int): UpdateTodoStatusCommand {
                return UpdateTodoStatusCommand(TodoId(id), TodoStatus.of(status))
            }
        }
    }
}