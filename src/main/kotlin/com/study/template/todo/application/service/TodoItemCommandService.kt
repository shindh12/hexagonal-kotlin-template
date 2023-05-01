package com.study.template.todo.application.service

import com.study.template.todo.application.port.input.CreateTodoItemUsecase
import com.study.template.todo.application.port.input.DeleteTodoItemUsecase
import com.study.template.todo.application.port.input.UpdateTodoContentsUsecase
import com.study.template.todo.application.port.input.UpdateTodoStatusUsecase
import org.springframework.stereotype.Service

@Service
class TodoItemCommandService : CreateTodoItemUsecase, UpdateTodoContentsUsecase, DeleteTodoItemUsecase, UpdateTodoStatusUsecase {
    override fun createTodoItem(command: CreateTodoItemUsecase.CreateTodoItemCommand) {
        TODO("Not yet implemented")
    }

    override fun deleteTodoItem(command: DeleteTodoItemUsecase.DeleteTodoItemCommand) {
        TODO("Not yet implemented")
    }

    override fun updateContents(command: UpdateTodoContentsUsecase.UpdateTodoContentsCommand) {
        TODO("Not yet implemented")
    }

    override fun updateStatus(command: UpdateTodoStatusUsecase.UpdateTodoStatusCommand) {
        TODO("Not yet implemented")
    }

}