package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

// TODO(10.07.2022) Try to replace with Badge
@JsonClass(generateAdapter = true)
data class LegendBadge(
    val name: String?,
    val value: Int
)
