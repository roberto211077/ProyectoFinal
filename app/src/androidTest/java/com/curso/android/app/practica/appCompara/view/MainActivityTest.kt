package com.curso.android.app.practica.appCompara.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.appCompara.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    private val text1 = "alfa"
    private val text2 = "beta"

    @Test
    fun mainActivity_CompararTextosDistintos(){

        //colocamos el valor en el textbox1
        Espresso.onView(
            ViewMatchers.withId(R.id.editText1)
        ).perform(
            ViewActions.typeText(text1)
        )

        //colocamos el valor en el textbox2
        Espresso.onView(
            ViewMatchers.withId(R.id.editText2)
        ).perform(
            ViewActions.typeText(text2)
        )

        //hacemos click en el boton compara
        Espresso.onView(
            ViewMatchers.withId(R.id.buttonCompara)
        ).perform(
            ViewActions.click()
        )

        //comparamos el resultaco con el esperado
        Espresso.onView(
            ViewMatchers.withId(R.id.TextViewResultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("distintos")
            )
        )
    }


}