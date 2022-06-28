package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Mirage(
    @Json(name = "ImgAssets") val imgAssets: ImgAssets
)
