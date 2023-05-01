package com.study.template.todo.domain

enum class TodoStatus(val code: Int) {
    TODO(0), DOING(1), DONE(2);


    companion object {
        fun of(status: Int): TodoStatus {
            return TodoStatus.values().find { it.code == status } ?: TODO
        }
    }

    override fun toString(): String {
        return super.name
    }
}
