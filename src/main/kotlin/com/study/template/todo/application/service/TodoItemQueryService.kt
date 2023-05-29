package com.study.template.todo.application.service

import com.study.template.todo.application.port.input.GetTodoItemUsecase
import com.study.template.todo.application.port.output.GetTodoItemPort
import com.study.template.todo.domain.TodoItem
import com.study.template.todo.domain.TodoItemNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoItemQueryService(val getTodoItemPort: GetTodoItemPort) : GetTodoItemUsecase {

    @Transactional(readOnly = true)
    override fun getTodoItems(): List<TodoItem> {
        return getTodoItemPort.getTodoItems()
    }

    @Transactional(readOnly = true)
    override fun getTodoItem(query: GetTodoItemUsecase.GetTodoItemQuery): TodoItem {
        return getTodoItemPort.getTodoItem(query.id) ?: throw TodoItemNotFoundException("Todo Item 을 찾지 못했습니다.")
    }

}