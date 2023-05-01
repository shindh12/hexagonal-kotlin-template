package com.study.template.todo.adapter.input.web

import com.study.template.todo.application.port.input.*
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo")
class CreateTodoItemController(val usecase: CreateTodoItemUsecase) {

    @PostMapping
    fun getTodoItem(@RequestBody command: CreateTodoItemUsecase.CreateTodoItemCommand) {
        usecase.createTodoItem(command)
    }
}