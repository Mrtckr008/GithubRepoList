package com.example.githubrepolist.view

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.githubrepolist.R
import com.example.githubrepolist.adapter.UsersRepoAdapter
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.Exception


class MainActivityTest {

    @Rule @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testOwnerName(){
        onView(withId(R.id.search_editText)).perform(ViewActions.typeText("mrtckr008"))
        onView(
            withId(R.id.submit_button)).perform(click())

        onView(withId(R.id.recyclerview_repo)).check(matches(isDisplayed()))
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.recyclerview_repo)).check(matches(isDisplayed()))
        try {
            // In this line, you should be sure your phone is developer mode and
            // you should be sure set as off animation features from developer settings.
            onView(withId(R.id.recyclerview_repo)).perform(actionOnItemAtPosition<UsersRepoAdapter.FeedViewHolder>(0, viewAction(R.id.repo_name)))
        }
        catch (e:Exception){
        }
        onView(withId(R.id.user_name)).check(matches(withText("Mrtckr008")))

    }
    fun viewAction(viewId: Int): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isRoot()
            }

            override fun getDescription(): String {
                return ""
            }

            override fun perform(
                uiController: UiController,
                view: View
            )
            {
                val v:View = view.findViewById(viewId);
                v.performClick();
            }
        }
    }

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {

    }
}

