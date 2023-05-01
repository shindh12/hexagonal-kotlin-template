package com.study.template.todo.domain

data class TodoItem(val id: TodoId, val contents:String, val status: TodoStatus)
