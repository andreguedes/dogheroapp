package br.com.doghero.dhproject.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import br.com.doghero.dhproject.R
import br.com.doghero.dhproject.data.model.*
import br.com.doghero.dhproject.ui.holder.GenericViewHolder
import kotlinx.android.synthetic.main.activity_my_heroes.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MyHeroesActivityTest {

    @get:Rule
    var activityTestRule: ActivityTestRule<MyHeroesActivity> =
        ActivityTestRule(MyHeroesActivity::class.java)

    @Test
    fun verifyViews() {
        onView(withText(R.string.app_name)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_my_heroes)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldScrollMyHeroesListToLastAndReturnToFirstPosition() {
        onView(withId(R.id.rv_my_heroes))
            .perform(
                RecyclerViewActions.scrollToPosition<GenericViewHolder<HeroItem>>(
                activityTestRule.activity.rv_my_heroes.adapter?.itemCount?.minus(1)!!
            ))
        onView(withId(R.id.rv_my_heroes))
            .perform(RecyclerViewActions.scrollToPosition<GenericViewHolder<HeroItem>>(0))
    }

    @Test
    fun shouldScrollMyHeroesListAndVerifyIfAHeroExists() {
        onView(withId(R.id.rv_my_heroes))
            .perform(
                RecyclerViewActions.scrollToPosition<GenericViewHolder<HeroItem>>(
                    activityTestRule.activity.rv_my_heroes.adapter?.itemCount?.minus(1)!!
                ))
        onView(withId(R.id.rv_my_heroes))
            .check(matches(hasDescendant(withText("Marina"))))
    }

}