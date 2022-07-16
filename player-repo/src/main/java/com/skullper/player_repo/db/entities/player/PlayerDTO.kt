package com.skullper.player_repo.db.entities.player

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.skullper.player_repo.data.battle_pass.BattlePassDTO
import com.skullper.player_repo.data.misc.BansInfoDTO
import com.skullper.player_repo.data.player.PlayerStatusDTO
import com.skullper.player_repo.data.ranks.PlayerRankDTO
import com.skullper.player_repo.db.entities.player.PlayerDTO.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class PlayerDTO(
    @PrimaryKey @ColumnInfo(name = ID) val uid: Long,
    @Embedded(prefix = ARENA) val arena: PlayerRankDTO,
    @ColumnInfo(name = AVATAR) val avatar: String,
    @Embedded(prefix = BANS) val bans: BansInfoDTO,
    @Embedded(prefix = BATTLEPASS) val battlePass: BattlePassDTO,
    @ColumnInfo(name = LEVEL) val level: Int,
    @ColumnInfo(name = NAME) val name: String,
    @ColumnInfo(name = PLATFORM) val platform: String,
    @Embedded(prefix = RANK) val rank: PlayerRankDTO,
    @ColumnInfo(name = PERCENT_TO_NEXT_LVL) val toNextLevelPercent: Int,
    @Embedded(prefix = STATUS) val status: PlayerStatusDTO,
    @ColumnInfo(name = UPDATED) val updated: Long,
) {

    companion object {

        const val TABLE_NAME = "player_info"

        const val ID = "id"
        const val ARENA = "arena"
        const val AVATAR = "avatar"
        const val BANS = "bans"
        const val BATTLEPASS = "battlepass"
        const val LEVEL = "level"
        const val NAME = "name"
        const val PLATFORM = "platform"
        const val RANK = "rank"
        const val PERCENT_TO_NEXT_LVL = "percent_to_next_lvl"
        const val STATUS = "status"
        const val UPDATED = "updated"
    }
}
