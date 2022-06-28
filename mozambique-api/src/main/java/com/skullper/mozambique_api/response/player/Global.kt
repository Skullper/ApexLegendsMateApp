package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Global(
    val arena: Arena,
    val avatar: String,
    val badges: List<LegendBadge>,
    val bans: Bans,
    val battlepass: Battlepass,
    val internalUpdateCount: Int,
    val level: Int,
    val name: String,
    val platform: String,
    val playerRank: PlayerRank,
    val toNextLevelPercent: Int,
    val uid: Long
)
