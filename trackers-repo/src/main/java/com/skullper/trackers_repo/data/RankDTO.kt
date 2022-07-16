package com.skullper.trackers_repo.data

import androidx.room.ColumnInfo

/**
 * @param topPercent NEED MORE INFO
 */
data class RankDTO(
    @ColumnInfo(name = POSITION) val position: Int,
    @ColumnInfo(name = TOP_PERCENT) val topPercent: Double
) {

    companion object {

        const val POSITION = "position"
        const val TOP_PERCENT = "percent_of_top"
    }
}
