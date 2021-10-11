package com.example.todo.viewmodel

import android.app.Application
import com.example.todo.di.appTestModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@ExperimentalCoroutinesApi
internal class ViewModelTest : KoinTest{

    @get: Rule
    val mockitoRule : MockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var context : Application

    //코루틴테스트를 할 때 스레드를 쉽게 바꿀수 있도록 (ex. 메인스레드에서 io스레드로 넘어가도록)
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        startKoin {
            androidContext(context)
            modules(appTestModule)
        }
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        stopKoin() // free memory
        Dispatchers.resetMain()// MainDispatcher를 초기화 해주어야 메모리 누수가 발생하지 않음
    }


}