package com.troshchiy.espresso

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Rule @JvmField val mainActivity = ActivityTestRule(MainActivity::class.java)
    @Rule @JvmField val secondActivity = ActivityTestRule(SecondActivity::class.java)

    @Test fun shouldPassNameToTheSecondScreen() {
        val name = "Name to pass"
        Espresso.onView(ViewMatchers.withId(R.id.edt_name)).perform(ViewActions.typeText(name), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.btn_next)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.tv_name)).check(ViewAssertions.matches(ViewMatchers.withText(name)))
    }
}