package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Realtime(
    val canJoin: Int,
    val currentState: String,
    val currentStateAsText: String,
    val currentStateSinceTimestamp: Int,
    val isInGame: Int,
    val isOnline: Int,
    val lobbyState: String,
    val partyFull: Int,
    val selectedLegend: String
)
