package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImgAssets(
    val banner: String,
    val icon: String
)
