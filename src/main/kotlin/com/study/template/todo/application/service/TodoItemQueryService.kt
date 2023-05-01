package com.study.template.todo.application.service

import com.study.template.todo.application.port.input.GetTodoItemUsecase
import com.study.template.todo.domain.TodoItem
import org.springframework.stereotype.Service

@Service
class TodoItemQueryService : GetTodoItemUsecase {
    override fun getTodoItems(): List<TodoItem> {
        TODO("Not yet implemented")
    }

    override fun getTodoItem(query: GetTodoItemUsecase.GetTodoItemQuery): TodoItem {
        TODO("Not yet implemented")
    }

}