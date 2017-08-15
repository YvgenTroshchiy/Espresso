package com.troshchiy.espresso

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class FirstTest {

    @Rule public var mainActivity: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    @Rule public var secondactivity: ActivityTestRule<SecondActivity> = ActivityTestRule(SecondActivity::class.java)

    @Before fun setUp() {}

    @After fun tearDown() {}

    @Test fun passNameToSecondScreen() {
        val name = "Tra tata"
        onView(withId(R.id.edt_name)).perform(typeText(name), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.btn_next)).perform(click())

        onView(withId(R.id.tv_name)).check(matches(withText(name)))
    }
}