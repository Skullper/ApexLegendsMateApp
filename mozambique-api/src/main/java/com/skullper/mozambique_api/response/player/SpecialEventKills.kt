package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpecialEventKills(
    val name: String,
    val value: Int
)
