package br.com.doghero.dhproject.data.model

import com.google.gson.annotations.SerializedName

data class HeroesResponse(
        @field:SerializedName("recents") val recents: List<Hero>?,
        @field:SerializedName("favorites") val favorites: List<Hero>?
)