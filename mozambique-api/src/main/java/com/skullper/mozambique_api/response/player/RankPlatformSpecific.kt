package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

data class RankPlatformSpecific(
    val rankPos: Int?,
    val topPercent: Double?
)

@JsonClass(generateAdapter = true)
data class RankPlatformSpecificNoCalculated(
    val rankPos: String,
    val topPercent: String
)
