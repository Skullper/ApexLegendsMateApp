package com.skullper.player_repo.data.misc

import androidx.room.ColumnInfo

data class BansInfoDTO(
    @ColumnInfo(name = ACTIVE) val isActive: Boolean,
    @ColumnInfo(name = REASON) val lastBanReason: String,
    @ColumnInfo(name = TIME_LEFT) val remainingSeconds: Int
) {

    companion object {

        const val ACTIVE = "is_active"

        /**
         * Of the last ban
         */
        const val REASON = "last_ban_reason"

        /**
         * How much seconds left to be unbanned
         */
        const val TIME_LEFT = "seconds_remaining"
    }
}
