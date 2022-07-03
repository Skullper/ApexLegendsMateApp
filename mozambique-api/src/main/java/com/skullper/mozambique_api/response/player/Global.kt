package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Global(
    val arena: Arena,
    val avatar: String,
    val badges: List<LegendBadge>,
    val bans: Bans,
    @Json(name = "battlepass") val battlePass: BattlePass,
    val internalUpdateCount: Int,
    val level: Int,
    val name: String,
    val platform: String,
    val rank: PlayerRank,
    val toNextLevelPercent: Int,
    val uid: Long
)
