package com.study.template.todo.application.port.input

import com.study.template.shared.application.port.input.InputPort
import com.study.template.todo.domain.TodoId

interface UpdateTodoContentsUsecase : InputPort {

    fun updateContents(command: UpdateTodoContentsCommand)

    data class UpdateTodoContentsCommand(val id: TodoId, val contents: String) {
        companion object {
            fun from(id: Long, contents: String): UpdateTodoContentsCommand {
                return UpdateTodoContentsCommand(TodoId(id), contents)
            }
        }
    }
}