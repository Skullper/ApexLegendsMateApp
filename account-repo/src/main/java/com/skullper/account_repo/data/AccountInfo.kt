package com.skullper.account_repo.data

import androidx.room.Embedded
import androidx.room.Relation
import com.skullper.badge_repo.db.BadgeDTO
import com.skullper.legends_repo.db.LegendDTO
import com.skullper.player_repo.db.entities.player.PlayerDTO
import com.skullper.trackers_repo.db.TrackerDTO

/**
 * A local representation of account
 */
data class AccountInfo(
    @Embedded val player: PlayerDTO,
    @Relation(
        parentColumn = PlayerDTO.ID, entityColumn = LegendDTO.KEY_PLAYER_ID
    ) val legends: List<LegendDTO>,
)

/**
 * Local representation of a legend
 */
data class LegendInfo(
    @Embedded val legendDTO: LegendDTO,
    @Relation(
        parentColumn = LegendDTO.NAME, entityColumn = TrackerDTO.KEY_LEGEND_NAME
    ) val trackers: List<TrackerDTO>,
    @Relation(
        parentColumn = LegendDTO.NAME, entityColumn = BadgeDTO.KEY_LEGEND_NAME
    ) val badges: List<BadgeDTO>,
)
