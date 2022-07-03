package com.skullper.player_repo.data.player

import com.skullper.player_repo.data.arenas.ArenaDTO
import com.skullper.player_repo.data.badges.LegendBadgeDTO
import com.skullper.player_repo.data.battle_pass.BattlePassDTO
import com.skullper.player_repo.data.misc.BansInfoDTO
import com.skullper.player_repo.data.ranks.PlayerRankDTO

data class PlayerDataDTO(
    val arena: ArenaDTO,
    val avatar: String,
    val badges: List<LegendBadgeDTO>,
    val bans: BansInfoDTO,
    val battlePass: BattlePassDTO,
//    val internalUpdateCount: Int,
    val level: Int,
    val name: String,
    val platform: String,
    val rank: PlayerRankDTO,
    val toNextLevelPercent: Int,
)
