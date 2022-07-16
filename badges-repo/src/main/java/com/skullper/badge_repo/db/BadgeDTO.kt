package com.skullper.badge_repo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.skullper.badge_repo.db.BadgeDTO.Companion.KEY_LEGEND_NAME
import com.skullper.badge_repo.db.BadgeDTO.Companion.KEY_PLAYER_ID
import com.skullper.legends_repo.db.LegendDTO
import com.skullper.player_repo.db.entities.player.PlayerDTO

/**
 * @param playerId is a foreign key for [PlayerDTO]
 * @param legendName is a foreign key for [LegendDTO]
 */
@Entity(
    tableName = BadgeDTO.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = PlayerDTO::class,
            parentColumns = arrayOf(PlayerDTO.ID),
            childColumns = arrayOf(KEY_PLAYER_ID)
        ),
        ForeignKey(
            entity = LegendDTO::class,
            parentColumns = arrayOf(LegendDTO.NAME),
            childColumns = arrayOf(KEY_LEGEND_NAME)
        ),
    ]
)
data class BadgeDTO(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = ID) val id: Long,
    @ColumnInfo(name = NAME) val name: String?,
    @ColumnInfo(name = VALUE) val value: Int,
    @ColumnInfo(name = CATEGORY) val category: String?,
    @ColumnInfo(name = KEY_PLAYER_ID, index = true) val playerId: Long, // as foreign key
    @ColumnInfo(name = KEY_LEGEND_NAME, index = true) val legendName: String?, // as foreign key
) {

    companion object {

        const val TABLE_NAME = "badges"

        const val ID = "id"
        const val NAME = "name"
        const val VALUE = "value"
        const val CATEGORY = "category"

        const val KEY_PLAYER_ID = "player_id_fk"
        const val KEY_LEGEND_NAME = "legend_name_fk"
    }
}
