package com.troshchiy.espresso

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.MotionEvents.sendDown
import android.support.test.espresso.action.MotionEvents.sendUp
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.view.View
import org.hamcrest.Matcher


val isDisplayed: ViewAssertion = matches(isDisplayed())

infix fun Int.perform(action: ViewAction): ViewInteraction = onView(withId(this)).perform(action)
fun Int.perform2(action1: ViewAction, action2: ViewAction): ViewInteraction = onView(withId(this)).perform(action1, action2)

infix fun Int.check(action: ViewAssertion): ViewInteraction = onView(withId(this)).check(action)

fun touchDownAndUp(clickView: View): ViewAction =
        object : ViewAction {
            override fun getConstraints(): Matcher<View> = isDisplayed()
            override fun getDescription() = "Send touch down and up event"

            override fun perform(uiController: UiController, view: View) {
                val x = clickView.left + clickView.width / 2
                val y = clickView.top + clickView.height / 2

                // Get view absolute position
                val locationOnScreen = IntArray(2)
                view.getLocationOnScreen(locationOnScreen)

                // Offset coordinates by view position
                val coordinates = floatArrayOf(x.toFloat() + locationOnScreen[0], y.toFloat() + locationOnScreen[1])
                val precision = floatArrayOf(1f, 1f)

                // Send down event, pause, and send up
                val down = sendDown(uiController, coordinates, precision).down
                uiController.loopMainThreadForAtLeast(200)
                sendUp(uiController, down, coordinates)
            }
        }