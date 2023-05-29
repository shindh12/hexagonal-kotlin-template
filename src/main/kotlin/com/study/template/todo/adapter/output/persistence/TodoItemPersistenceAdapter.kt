package com.study.template.todo.adapter.output.persistence

import com.study.template.todo.application.port.output.DeleteTodoItemPort
import com.study.template.todo.application.port.output.GetTodoItemPort
import com.study.template.todo.application.port.output.SaveTodoItemPort
import com.study.template.todo.domain.TodoId
import com.study.template.todo.domain.TodoItem
import org.springframework.stereotype.Repository

@Repository
class TodoItemPersistenceAdapter : SaveTodoItemPort, GetTodoItemPort, DeleteTodoItemPort {
    override fun delete(id: TodoId) {
        TODO("Not yet implemented")
    }

    override fun getTodoItems(): List<TodoItem> {
        TODO("Not yet implemented")
    }

    override fun getTodoItem(id: TodoId): TodoItem? {
        TODO("Not yet implemented")
    }

    override fun save(item: TodoItem) {
        TODO("Not yet implemented")
    }

}