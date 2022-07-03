package com.skullper.player_repo.data.player

data class PlayerStatusDTO(
    val canJoin: Boolean,
    val currentState: String,
    val currentStateAsText: String,
    val currentStateSinceTimestamp: Int,
    val isInGame: Boolean,
    val isOnline: Boolean,
    val lobbyState: String,
    val partyFull: Boolean,
    val selectedLegend: String
)
