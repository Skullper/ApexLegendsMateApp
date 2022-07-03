package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ash(
    override val data: List<Data>?,
    override val gameInfo: GameInfo?,
    @Json(name = "ImgAssets") override val assets: ImgAssets,
) : Legend
