package com.example.todo.di

import com.example.todo.data.repository.TestToDoRepository
import com.example.todo.data.repository.ToDoRepository
import com.example.todo.domain.todo.GetToDoListUseCase
import com.example.todo.domain.todo.InsertToDoListUseCase
import com.example.todo.presentation.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

// 내부 패키지에서만 사용
internal val appTestModule = module { // kotlin extension

    viewModel {ListViewModel(get())}

    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }

    // [left->return] [right->real]
    single<ToDoRepository> {
        TestToDoRepository()
    }

}