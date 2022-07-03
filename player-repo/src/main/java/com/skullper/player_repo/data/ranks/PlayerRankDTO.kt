package com.skullper.player_repo.data.ranks

data class PlayerRankDTO(
    val ladderPositionPlatform: Int,
    val rankDiv: Int,
    val rankImg: String,
    val rankName: String,
    val rankScore: Int,
    val rankedSeason: String
)
