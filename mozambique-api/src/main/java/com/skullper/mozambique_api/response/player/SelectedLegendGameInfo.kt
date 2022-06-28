package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SelectedLegendGameInfo(
    val badges: List<AccountBadge>,
    val frame: String,
    val frameRarity: String,
    val intro: String,
    val introRarity: String,
    val pose: String,
    val poseRarity: String,
    val skin: String,
    val skinRarity: String
)
