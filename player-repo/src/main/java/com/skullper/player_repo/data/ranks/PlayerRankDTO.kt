package com.skullper.player_repo.data.ranks

import androidx.room.ColumnInfo

/**
 * @param position on the ladder between other player on same platform. -1 if unknown
 * @param rankDiv ???
 */
data class PlayerRankDTO(
    @ColumnInfo(name = POSITION) val position: Int,
    @ColumnInfo(name = RANK) val rankDiv: Int,
    @ColumnInfo(name = RANK_IMG) val rankImg: String,
    @ColumnInfo(name = RANK_NAME) val rankName: String,
    @ColumnInfo(name = RANK_SCORE) val rankScore: Int,
    @ColumnInfo(name = SEASON_NAME) val rankedSeason: String
) {

    companion object {

        const val POSITION = "position"
        const val RANK = "rank_division"
        const val RANK_IMG = "rank_img"
        const val RANK_NAME = "rank_name"
        const val RANK_SCORE = "rank_score"
        const val SEASON_NAME = "season_name"
    }
}
