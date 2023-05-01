package com.study.template.todo.adapter.output.persistence

import com.study.template.shared.adapter.output.MockComponent
import com.study.template.todo.domain.TodoId
import com.study.template.todo.domain.TodoItem
import com.study.template.todo.domain.TodoStatus

@MockComponent
class MockTodoItemPersistenceAdapter : TodoItemPersistenceAdapter() {

    override fun getTodoItems(): List<TodoItem> {
        return listOf(TodoItem(TodoId(1L), "fake contents", TodoStatus.TODO))
    }

    override fun getTodoItem(id: TodoId): TodoItem {
        return TodoItem(id, "fake contents", TodoStatus.TODO)
    }

    override fun save(item: TodoItem) {
        // do nothing
    }

    override fun delete(id: TodoId) {
        // do nothing
    }

}