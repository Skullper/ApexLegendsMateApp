package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlayerRank(
    val ladderPosPlatform: Int,
    val rankDiv: Int,
    val rankImg: String,
    val rankName: String,
    val rankScore: Int,
    val rankedSeason: String
)
