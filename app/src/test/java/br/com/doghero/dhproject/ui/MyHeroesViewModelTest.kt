package br.com.doghero.dhproject.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.doghero.dhproject.data.model.HeroItem
import br.com.doghero.dhproject.data.source.MyHeroesInteractor
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers.Unconfined
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MyHeroesViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val interactorMock = mockk<MyHeroesInteractor>()
    private val viewModel = MyHeroesViewModel(interactorMock, Unconfined)

    @Test
    fun shouldReturnHeroesResponseResult_WhenViewModelExposeHeroesListViewState() {
        val heroItem = mockk<HeroItem>()
        val heroItemsList = arrayListOf(
            heroItem, heroItem, heroItem, heroItem, heroItem
        )

        val expectedHeroItemListState = MyHeroesViewState.MyHeroesList(heroItemsList)

        coEvery { interactorMock.getMyHeroes() } returns heroItemsList

        viewModel.getMyHeroes()

        assertEquals(viewModel.viewState.value, expectedHeroItemListState)
    }

    @Test
    fun shouldReturnHeroesEmptyResult_WhenViewModelExposeHeroesListEmptyViewState() {
        val heroEmptyList = arrayListOf<HeroItem>()

        val expectedHeroItemListState = MyHeroesViewState.EmptyHeroesList

        coEvery { interactorMock.getMyHeroes() } returns heroEmptyList

        viewModel.getMyHeroes()

        assertEquals(viewModel.viewState.value, expectedHeroItemListState)
    }

}