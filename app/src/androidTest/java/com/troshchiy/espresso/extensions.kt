package com.troshchiy.espresso

import android.support.test.espresso.Espresso
import android.support.test.espresso.ViewAction
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.matcher.ViewMatchers

infix fun Int.perform(action: ViewAction): ViewInteraction = Espresso.onView(ViewMatchers.withId(this)).perform(action)
fun Int.perform(vararg actions: ViewAction): ViewInteraction = Espresso.onView(ViewMatchers.withId(this)).perform(*actions)

infix fun Int.check(action: ViewAssertion): ViewInteraction = Espresso.onView(ViewMatchers.withId(this)).check(action)