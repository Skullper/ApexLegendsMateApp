package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameInfo(
    val badges: List<LegendBadge>
)
