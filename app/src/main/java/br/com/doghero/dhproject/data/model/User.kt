package br.com.doghero.dhproject.data.model

import com.google.gson.annotations.SerializedName

data class User(
        @field:SerializedName("first_name") val firstName: String,
        @field:SerializedName("image_url") val imageUrl: String
)