package com.example.todo.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.entity.ToDoEntity
import com.example.todo.domain.todo.GetToDoListUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class ListViewModel(
    private val getToDoListUseCase: GetToDoListUseCase
) : ViewModel() {
    private val _toDoListLiveData = MutableLiveData<List<ToDoEntity>>()
    val todoListLiveData : LiveData<List<ToDoEntity>> = _toDoListLiveData

    fun fetchData() : Job = viewModelScope.launch {
        _toDoListLiveData.postValue(getToDoListUseCase()!!)
    }
}