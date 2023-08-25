package com.curso.android.app.practica.appCompara

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.appCompara.view.MainViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {
   private lateinit var viewModel: MainViewModel

   /*Regla de que las tareas son instantaneas*/
   @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    /*Elemento que permite correr las subrutinas*/
    private val dispatcher = StandardTestDispatcher()

    /*Anotacion, antes de correr los test se llama esta funcion*/
    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    /*Anotacion para resetear el dispatcher*/
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    /*Testeo el estado inicial*/
    @Test
    fun mainViewModel_CheckInitialValue() = runTest{
        val value = viewModel.compara.value?.resultado

        assertEquals("",value)
    }

    /*Testeo que los datos ingresados son iguales*/
    @Test
    fun mainViewModel_TestCompararTextosIguales() = runTest{

        launch{
            viewModel.CompararTextos(text1 = "a", text2 = "a")
        }

        advanceUntilIdle()

        val value = viewModel.compara.value?.resultado
        assertEquals("iguales", value)

    }

    /*Testeo que los datos ingresados son distintos*/
    @Test
    fun mainViewModel_TestCompararTextosDistintos() = runTest{

        launch{
            viewModel.CompararTextos(text1 = "a", text2 = "b")
        }

        advanceUntilIdle()

        val value = viewModel.compara.value?.resultado
        assertEquals("distintos", value)

    }
}