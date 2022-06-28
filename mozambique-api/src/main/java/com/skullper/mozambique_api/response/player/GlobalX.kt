package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GlobalX(
    @Json(name = "ImgAssets") val imgAssets: ImgAssets
)
