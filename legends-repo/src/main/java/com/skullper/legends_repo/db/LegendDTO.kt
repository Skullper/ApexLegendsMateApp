package com.skullper.legends_repo.db

import androidx.room.*
import com.skullper.legends_repo.data.miscs.ImageAssetsDTO
import com.skullper.legends_repo.db.LegendDTO.Companion.KEY_PLAYER_ID
import com.skullper.legends_repo.db.LegendDTO.Companion.TABLE_NAME
import com.skullper.player_repo.db.entities.player.PlayerDTO

/**
 * @property isSelected if this legend is displayed in the lobby
 * @property playerId is a foreign key for [PlayerDTO] table
 */
@Entity(
    tableName = TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = PlayerDTO::class,
            parentColumns = arrayOf(PlayerDTO.ID),
            childColumns = arrayOf(KEY_PLAYER_ID),
        )
    ]
)
data class LegendDTO(
    @PrimaryKey @ColumnInfo(name = NAME) val name: String,
    @Embedded(prefix = IMG_ASSETS) val imgAssets: ImageAssetsDTO,
    @ColumnInfo(name = IS_SELECTED) val isSelected: Boolean,
    @ColumnInfo(name = FRAME) val frame: String? = null,
    @ColumnInfo(name = F_RARITY) val frameRarity: String? = null,
    @ColumnInfo(name = INTRO) val intro: String? = null,
    @ColumnInfo(name = I_RARITY) val introRarity: String? = null,
    @ColumnInfo(name = POSE) val pose: String? = null,
    @ColumnInfo(name = P_RARITY) val poseRarity: String? = null,
    @ColumnInfo(name = SKIN) val skin: String? = null,
    @ColumnInfo(name = S_RARITY) val skinRarity: String? = null,
    @ColumnInfo(name = KEY_PLAYER_ID, index = true) val playerId: Long, // as foreign key
) {

    companion object {

        const val TABLE_NAME = "legend"

        const val NAME = "name"
        const val IMG_ASSETS = "img_assets"
        const val IS_SELECTED = "is_selected"
        const val FRAME = "frame"
        const val F_RARITY = "frame_rarity"
        const val INTRO = "intro"
        const val I_RARITY = "intro_rarity"
        const val POSE = "pose"
        const val P_RARITY = "pose_rarity"
        const val SKIN = "skin"
        const val S_RARITY = "skin_rarity"

        const val KEY_PLAYER_ID = "player_id_fk"
    }
}
