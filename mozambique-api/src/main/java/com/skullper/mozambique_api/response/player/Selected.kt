package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Selected(
    val data: List<SelectedLegendData>,
    val gameInfo: SelectedLegendGameInfo,
    @Json(name = "ImgAssets") val imgAssets: ImgAssets,
    @Json(name = "LegendName") val legendName: String
)
