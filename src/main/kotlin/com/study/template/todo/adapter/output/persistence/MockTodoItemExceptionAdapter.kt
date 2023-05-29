package com.study.template.todo.adapter.output.persistence

import com.study.template.shared.adapter.output.MockComponent
import com.study.template.todo.domain.TodoId
import com.study.template.todo.domain.TodoItem
import com.study.template.todo.domain.TodoItemNotFoundException

@MockComponent
class MockTodoItemExceptionAdapter : MockTodoItemPersistenceAdapter() {
    override fun getTodoItem(id: TodoId): TodoItem? {
        if (id.value == 2L) {
            throw TodoItemNotFoundException("Mock 에러")
        }
        return super.getTodoItem(id)
    }

}