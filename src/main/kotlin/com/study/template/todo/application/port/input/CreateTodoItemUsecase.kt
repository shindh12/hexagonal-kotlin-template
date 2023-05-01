package com.study.template.todo.application.port.input

import com.study.template.shared.application.port.input.InputPort

interface CreateTodoItemUsecase: InputPort {

    fun createTodoItem(command: CreateTodoItemCommand)

    data class CreateTodoItemCommand(val contents: String)
}