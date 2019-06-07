package br.com.doghero.dhproject.data.source

import br.com.doghero.dhproject.data.model.HeroesResponse
import com.google.gson.Gson

object MyHeroes {

    fun build(json: String): HeroesResponse? {
        return Gson().fromJson(json, HeroesResponse::class.java)
    }

}