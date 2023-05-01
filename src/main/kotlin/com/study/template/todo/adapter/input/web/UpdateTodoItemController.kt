package com.study.template.todo.adapter.input.web

import com.study.template.todo.adapter.input.web.request.UpdateTodoContentsRequestBody
import com.study.template.todo.adapter.input.web.request.UpdateTodoStatusRequestBody
import com.study.template.todo.application.port.input.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class UpdateTodoItemController(val updateTodoContentsUsecase: UpdateTodoContentsUsecase, val updateTodoStatusUsecase: UpdateTodoStatusUsecase) {

    @PatchMapping("/{id}/contents")
    fun updateTodoContents(@PathVariable id: Long, @RequestBody request: UpdateTodoContentsRequestBody) {
        updateTodoContentsUsecase.updateContents(UpdateTodoContentsUsecase.UpdateTodoContentsCommand.from(id, request.contents))
    }

    @PatchMapping("/{id}/status")
    fun updateTodoStatus(@PathVariable id: Long, @RequestBody request: UpdateTodoStatusRequestBody) {
        updateTodoStatusUsecase.updateStatus(UpdateTodoStatusUsecase.UpdateTodoStatusCommand.from(id, request.status))
    }
}