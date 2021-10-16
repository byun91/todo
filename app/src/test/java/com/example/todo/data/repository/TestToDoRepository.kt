package com.example.todo.data.repository

import com.example.todo.data.entity.ToDoEntity
import kotlinx.coroutines.CoroutineDispatcher

class TestToDoRepository(): ToDoRepository {

    private val toDoList : MutableList<ToDoEntity> = mutableListOf()

    override suspend fun getToDoList(): List<ToDoEntity> = toDoList
    override suspend fun getToDoItem(id: Long): ToDoEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun insertToDoItem(toDoEntity: ToDoEntity): Long {
        TODO("Not yet implemented")
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        this.toDoList.addAll(toDoList)
    }

    override suspend fun updateToDoItem(toDoEntity: ToDoEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteToDoItem(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }
}
