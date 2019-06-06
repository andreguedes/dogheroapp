package br.com.doghero.dhproject.data.model

import com.google.gson.annotations.SerializedName

data class Hero(
        @field:SerializedName("id") val id: Int?,
        @field:SerializedName("is_superhero") val isSuperhero: Boolean,
        @field:SerializedName("user") val user: User?,
        @field:SerializedName("address_neighborhood") val addressNeighborhood: String,
        @field:SerializedName("price") val price: Double
)