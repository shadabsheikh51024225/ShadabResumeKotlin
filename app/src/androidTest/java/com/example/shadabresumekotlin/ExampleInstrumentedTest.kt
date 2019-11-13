package com.example.shadabresumekotlin

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import android.content.Intent
import android.R
import android.R.attr.button
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import org.hamcrest.CoreMatchers.allOf


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {





    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @get:Rule
    val intentsTestRule = IntentsTestRule(CareerDetails::class.java)

    @Test fun validateIntentSentToPackage() {

        //CHECKING ENTRY TO RIGHT PACKAGE
        intended(toPackage("com.example.shadabresumekotlin"))
    }

    @Test
    fun triggerIntentTest() {
        intended(
            allOf(

                toPackage("com.example.shadabresumekotlin")
            )
        )
    }


    //IN CASE OF INSTANT DATA LOAD YOU CAN CHECK THE DATA HERE FOR YOUR MAIN ACTIVITY.
    @Test
    fun view_isCorrect() {
        onView(withText("SHADAB SHEIKH")).check(matches(isDisplayed()))
    }

    // To confirm the subview , this trick will be help full in dynamic creation of sub view to match the data.
    @Test
    fun view_isCorrect_Porfile() {
        onView(withText("Android Application Developer")).check(matches(isDisplayed()))
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.shadabresumekotlin", appContext.packageName)
    }




}
