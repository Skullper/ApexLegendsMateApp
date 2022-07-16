package com.skullper.player_repo.data.player

import androidx.room.ColumnInfo

/**
 * @param isFree if other players can join the lobby
 */
data class PlayerStatusDTO(
    @ColumnInfo(name = FREE) val isFree: Boolean,
    @ColumnInfo(name = STATE) val currentState: String, // TODO(10.07.2022) Add enum
    @ColumnInfo(name = SINCE) val currentStateSinceTimestamp: Long,
    @ColumnInfo(name = IN_GAME) val isInGame: Boolean,
    @ColumnInfo(name = ONLINE) val isOnline: Boolean,
    @ColumnInfo(name = STATE_LOBBY) val lobbyState: String,
    @ColumnInfo(name = PARTY_FULL) val isPartyFull: Boolean,
    @ColumnInfo(name = LEGEND) val selectedLegend: String
) {

    companion object {

        /**
         * If __true__ other players can join the lobby
         */
        const val FREE = "is_free"
        const val STATE = "current_state"
        const val SINCE = "at_current_state_since"
        const val IN_GAME = "in_game"
        const val ONLINE = "is_online"
        const val STATE_LOBBY = "lobby_state"
        const val PARTY_FULL = "is_party_full"
        const val LEGEND = "selected_legend"
    }
}
