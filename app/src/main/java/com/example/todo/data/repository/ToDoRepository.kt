package com.example.todo.data.repository

import com.example.todo.data.entity.ToDoEntity

interface ToDoRepository {
    //why interface?
    // repository pattern으로 추상화함으로서 remote, local cache든 공통적으로 불러오기위해ㅑ

    suspend fun getToDoList(): List<ToDoEntity>

    suspend fun getToDoItem(id: Long): ToDoEntity?

    suspend fun insertToDoItem(toDoEntity: ToDoEntity): Long

    suspend fun insertToDoList(toDoList: List<ToDoEntity>)

    suspend fun updateToDoItem(toDoEntity: ToDoEntity)

    suspend fun deleteToDoItem(id: Long)

    suspend fun deleteAll()

}
