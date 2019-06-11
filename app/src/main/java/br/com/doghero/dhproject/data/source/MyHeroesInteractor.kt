package br.com.doghero.dhproject.data.source

import br.com.doghero.dhproject.R
import br.com.doghero.dhproject.data.model.Header
import br.com.doghero.dhproject.data.model.HeroItem
import br.com.doghero.dhproject.data.model.HeroStatus
import br.com.doghero.dhproject.data.model.HeroesResponse
import br.com.doghero.dhproject.data.source.remote.ApiAnswer
import br.com.doghero.dhproject.data.source.remote.MyHeroes

class MyHeroesInteractor {

    fun getMyHeroes(): ArrayList<HeroItem> {
        return createHeroItemsList(MyHeroes.build(ApiAnswer.getMyHeroes()))
    }

    private fun createHeroItemsList(heroesResponse: HeroesResponse?): ArrayList<HeroItem> {
        val heroItemsList = arrayListOf<HeroItem>()
        heroesResponse?.let { heroes ->
            heroes.recents?.let {
                if (!it.isNullOrEmpty()) {
                    heroItemsList.add(Header(R.string.header_recents))
                    it.map { hero ->
                        hero.heroStatus = HeroStatus.RECENT
                        heroItemsList.add(hero)
                    }
                }
            }
            heroes.favorites?.let {
                if (!it.isNullOrEmpty()) {
                    heroItemsList.add(Header(R.string.header_favorites))
                    it.map { hero ->
                        hero.heroStatus = HeroStatus.FAVORITE
                        hero.isFavorite = true
                        heroItemsList.add(hero)
                    }
                }
            }
        }
        return heroItemsList
    }

}