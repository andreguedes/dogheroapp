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

    private fun loadMyHeroes(): ArrayList<HeroItem> {
        return arrayListOf(
            Header(R.string.header_recents),
            getHero(HeroStatus.RECENT, false, true),
            Header(R.string.header_favorites),
            getHero(HeroStatus.FAVORITE, true, true),
            getHero(HeroStatus.FAVORITE, true, false),
            getHero(HeroStatus.FAVORITE, true, false),
            getHero(HeroStatus.FAVORITE, true, true)
        )
    }

    private fun getHero(status: HeroStatus, favorite: Boolean, superhero: Boolean): Hero {
        val user = User(
            firstName = "Andre", imageUrl = "https://avatars1.githubusercontent.com/u/4925429?s=460&amp;v=4"
        )
        return Hero(
            id = 1, isFavorite = favorite, price = 45, addressNeighborhood = "Rua Teste, 45", user = user, isSuperhero = superhero, heroStatus = status
        )
    }

}