package com.study.template.todo.application.service

import com.study.template.todo.application.port.input.CreateTodoItemUsecase
import com.study.template.todo.application.port.input.DeleteTodoItemUsecase
import com.study.template.todo.application.port.input.UpdateTodoContentsUsecase
import com.study.template.todo.application.port.input.UpdateTodoStatusUsecase
import com.study.template.todo.application.port.output.DeleteTodoItemPort
import com.study.template.todo.application.port.output.GetTodoItemPort
import com.study.template.todo.application.port.output.SaveTodoItemPort
import com.study.template.todo.domain.TodoItem
import com.study.template.todo.domain.TodoStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoItemCommandService(val getTodoItemPort: GetTodoItemPort,
                             val saveTodoItemPort: SaveTodoItemPort,
                             val deleteTodoItemPort: DeleteTodoItemPort) : CreateTodoItemUsecase, UpdateTodoContentsUsecase, DeleteTodoItemUsecase, UpdateTodoStatusUsecase {

    @Transactional
    override fun createTodoItem(command: CreateTodoItemUsecase.CreateTodoItemCommand) {
        val item = TodoItem(contents = command.contents, status = TodoStatus.TODO)
        saveTodoItemPort.save(item)
    }

    @Transactional
    override fun deleteTodoItem(command: DeleteTodoItemUsecase.DeleteTodoItemCommand) {
        deleteTodoItemPort.delete(command.id)
    }

    @Transactional
    override fun updateContents(command: UpdateTodoContentsUsecase.UpdateTodoContentsCommand) {
        val before = getTodoItemPort.getTodoItem(command.id)
        val after = TodoItem(before.id, command.contents, before.status)
        saveTodoItemPort.save(after)
    }

    @Transactional
    override fun updateStatus(command: UpdateTodoStatusUsecase.UpdateTodoStatusCommand) {
        val before = getTodoItemPort.getTodoItem(command.id)
        val after = TodoItem(before.id, before.contents, command.status)
        saveTodoItemPort.save(after)
    }

}