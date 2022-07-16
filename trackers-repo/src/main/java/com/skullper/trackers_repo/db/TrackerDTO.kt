package com.skullper.trackers_repo.db

import androidx.room.*
import com.skullper.legends_repo.db.LegendDTO
import com.skullper.trackers_repo.data.PlatformSpecificRankDTO
import com.skullper.trackers_repo.data.RankDTO
import com.skullper.trackers_repo.db.TrackerDTO.Companion.KEY_LEGEND_NAME

@Entity(
    tableName = TrackerDTO.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = LegendDTO::class,
            parentColumns = arrayOf(LegendDTO.NAME),
            childColumns = arrayOf(KEY_LEGEND_NAME)
        )
    ]
)
data class TrackerDTO(
    @PrimaryKey(autoGenerate = true) val uid: Long = 0L,
    @ColumnInfo(name = KEY) val key: String,
    @ColumnInfo(name = VALUE) val value: Int,
    @ColumnInfo(name = NAME) val name: String,
    @Embedded(prefix = RANK) val rank: RankDTO,
    @Embedded(prefix = RANK_PLATFORM) val platformSpecificRank: PlatformSpecificRankDTO?,
    @ColumnInfo(name = KEY_LEGEND_NAME, index = true) val legendName: String,
) {

    companion object {

        const val TABLE_NAME = "trackers"

        const val KEY = "key"
        const val VALUE = "value"
        const val NAME = "name"
        const val RANK = "rank"
        const val RANK_PLATFORM = "platform_specific_rank"

        const val KEY_LEGEND_NAME = "legend_name"
    }
}
