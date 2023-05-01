package com.study.template.todo.domain

data class TodoItem(val id: TodoId? = null,
                    val contents: String,
                    val status: TodoStatus)
