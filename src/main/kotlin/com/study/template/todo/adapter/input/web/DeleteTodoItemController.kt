package com.study.template.todo.adapter.input.web

import com.study.template.todo.application.port.input.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class DeleteTodoItemController(val usecase: DeleteTodoItemUsecase) {

    @DeleteMapping("{id}")
    fun getTodoItem(@PathVariable id: Long) {
        usecase.deleteTodoItem(DeleteTodoItemUsecase.DeleteTodoItemCommand.from(id))
    }

}