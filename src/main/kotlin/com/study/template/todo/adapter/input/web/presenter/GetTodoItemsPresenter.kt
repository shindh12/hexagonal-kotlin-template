package com.study.template.todo.adapter.input.web.presenter

import com.study.template.todo.adapter.input.web.viewmodel.GetTodoItemsViewModel
import com.study.template.todo.adapter.input.web.viewmodel.TodoItemDTO
import com.study.template.todo.domain.TodoItem
import org.springframework.stereotype.Component


@Component
class GetTodoItemsPresenter {
    fun present(items: List<TodoItem>): GetTodoItemsViewModel {
        val dtos = items.map { TodoItemDTO(it.id.value, it.contents, it.status.toString()) }.toList()
        return GetTodoItemsViewModel(dtos)
    }
}