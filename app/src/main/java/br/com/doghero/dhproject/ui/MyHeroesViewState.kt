package br.com.doghero.dhproject.ui

import br.com.doghero.dhproject.data.model.HeroItem

sealed class MyHeroesViewState {

    data class MyHeroesList(val heroesList: ArrayList<HeroItem>): MyHeroesViewState()
    object EmptyHeroesList: MyHeroesViewState()

}