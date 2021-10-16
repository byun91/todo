package com.example.todo.viewmodel.todo

import com.example.todo.data.entity.ToDoEntity
import com.example.todo.domain.todo.InsertToDoListUseCase
import com.example.todo.presentation.ListViewModel
import com.example.todo.viewmodel.ViewModelTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.koin.core.inject

/**
 *
 *
 *
 * */
@ExperimentalCoroutinesApi
internal class ListViewModelTest : ViewModelTest(){

    private val viewModel: ListViewModel by inject()
    private val insertToDoListUseCase : InsertToDoListUseCase by inject()
    private val mockList = (0 until 10).map{
        ToDoEntity(
            id = it.toLong(),
            title = "title $it",
            description = "description $it",
            hasCompleted = false
        )
    }
    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlockingTest {
        insertToDoListUseCase(mockList)
    }

    //Test
    @Test
    fun test() : Unit = runBlockingTest {
        val testObservable = viewModel.todoListLiveData.test()
        viewModel.fetchData()
        testObservable.assertValueSequence(
            listOf(mockList)
        )
    }

}