package com.skullper.player_repo.data.player

import com.skullper.player_repo.data.legend.LegendDTO

data class PlayerDTO(
    val uid: Long,
//    val aLS: ALS,
    val data: PlayerDataDTO,
    val legends: List<LegendDTO>,
//    val mozambiqueHereInternal: MozambiquehereInternal,
    val status: PlayerStatusDTO,
//    val total: Total
)
