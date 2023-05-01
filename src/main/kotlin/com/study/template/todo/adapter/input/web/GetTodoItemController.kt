package com.study.template.todo.adapter.input.web

import com.study.template.todo.adapter.input.web.presenter.GetTodoItemPresenter
import com.study.template.todo.adapter.input.web.presenter.GetTodoItemsPresenter
import com.study.template.todo.adapter.input.web.viewmodel.GetTodoItemViewModel
import com.study.template.todo.adapter.input.web.viewmodel.GetTodoItemsViewModel
import com.study.template.todo.application.port.input.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo")
class GetTodoItemController(val usecase: GetTodoItemUsecase, val itemsPresenter: GetTodoItemsPresenter, val itemPresenter: GetTodoItemPresenter) {

    @GetMapping
    fun getAllTodoItems(): GetTodoItemsViewModel {
        val items = usecase.getTodoItems()
        return itemsPresenter.present(items)
    }

    @GetMapping("{id}")
    fun getTodoItem(@PathVariable id: Long): GetTodoItemViewModel {
        val item = usecase.getTodoItem(GetTodoItemUsecase.GetTodoItemQuery.from(id))
        return itemPresenter.present(item)
    }

}