package com.troshchiy.espresso

import android.support.test.espresso.Espresso
import android.support.test.espresso.ViewAction
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed

val isDisplayed: ViewAssertion = ViewAssertions.matches(isDisplayed())

infix fun Int.perform(action: ViewAction): ViewInteraction = Espresso.onView(ViewMatchers.withId(this)).perform(action)
fun Int.perform2(action1: ViewAction, action2: ViewAction): ViewInteraction = Espresso.onView(ViewMatchers.withId(this)).perform(action1, action2)

infix fun Int.check(action: ViewAssertion): ViewInteraction = Espresso.onView(ViewMatchers.withId(this)).check(action)