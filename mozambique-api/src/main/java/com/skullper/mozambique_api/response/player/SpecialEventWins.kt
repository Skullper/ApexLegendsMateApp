package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpecialEventWins(
    val name: String,
    val value: Int
)
