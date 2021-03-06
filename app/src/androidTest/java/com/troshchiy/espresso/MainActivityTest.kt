package com.troshchiy.espresso

import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.Button
import com.troshchiy.espresso.ui.MainActivity
import com.troshchiy.espresso.ui.SecondActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Rule @JvmField val mainActivityRule = ActivityTestRule(MainActivity::class.java)
    @Rule @JvmField val secondActivityRule = ActivityTestRule(SecondActivity::class.java)

    @Test fun shouldPassNameToTheSecondScreen() {
        val name = "Name to pass"

        R.id.edt_name.perform2(typeText(name), closeSoftKeyboard())

        val btnNext = mainActivityRule.activity.findViewById<Button>(R.id.btn_next)
        R.id.constraintLayout perform touchDownAndUp(btnNext)
//        R.id.btn_next perform click()

        R.id.tv_name check isDisplayed
        R.id.tv_name check matches(withText(name))
    }
}