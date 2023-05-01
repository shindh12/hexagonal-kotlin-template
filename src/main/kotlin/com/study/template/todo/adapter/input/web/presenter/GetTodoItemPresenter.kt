package com.study.template.todo.adapter.input.web.presenter

import com.study.template.todo.adapter.input.web.viewmodel.GetTodoItemViewModel
import com.study.template.todo.adapter.input.web.viewmodel.TodoItemDTO
import com.study.template.todo.domain.TodoItem
import org.springframework.stereotype.Component


@Component
class GetTodoItemPresenter {
    fun present(item: TodoItem): GetTodoItemViewModel {
        return GetTodoItemViewModel(TodoItemDTO(item.id!!.value, item.contents, item.status.toString()))
    }
}