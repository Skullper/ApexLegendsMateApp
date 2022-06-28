package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Bans(
    val isActive: Boolean,
    @Json(name = "last_banReason") val lastBanReason: String,
    val remainingSeconds: Int
)
