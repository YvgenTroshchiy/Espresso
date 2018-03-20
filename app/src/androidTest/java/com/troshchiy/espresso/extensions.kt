package com.troshchiy.espresso

import android.support.test.espresso.Espresso
import android.support.test.espresso.ViewAction
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.matcher.ViewMatchers

infix fun Int.perform(action: ViewAction): ViewInteraction = Espresso.onView(ViewMatchers.withId(this)).perform(action)
fun Int.perform2(action1: ViewAction, action2: ViewAction): ViewInteraction = Espresso.onView(ViewMatchers.withId(this)).perform(action1, action2)

//Espresso.onView(ViewMatchers.withId(R.id.edt_name)).perform(ViewActions.typeText(name), ViewActions.closeSoftKeyboard())

infix fun Int.check(action: ViewAssertion): ViewInteraction = Espresso.onView(ViewMatchers.withId(this)).check(action)