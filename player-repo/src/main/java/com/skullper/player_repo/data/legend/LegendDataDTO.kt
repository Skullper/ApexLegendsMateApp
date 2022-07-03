package com.skullper.player_repo.data.legend

import com.skullper.player_repo.data.ranks.PlatformSpecificRankDTO
import com.skullper.player_repo.data.ranks.RankDTO

data class LegendDataDTO(
    val key: String,
    val name: String,
    val rank: RankDTO,
    val platformSpecificRank: PlatformSpecificRankDTO,
    val value: Int
)
