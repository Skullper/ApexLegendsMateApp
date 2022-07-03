package com.skullper.player_repo.data.legend.selected

import com.skullper.player_repo.data.badges.AccountBadgeDTO

data class SelectedLegendGameInfoDTO(
    val badges: List<AccountBadgeDTO>,
    val frame: String,
    val frameRarity: String,
    val intro: String,
    val introRarity: String,
    val pose: String,
    val poseRarity: String,
    val skin: String,
    val skinRarity: String
)
