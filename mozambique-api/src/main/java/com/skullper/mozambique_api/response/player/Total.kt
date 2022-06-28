package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Total(
    val kd: Kd,
    @Json(name = "specialEvent_damage") val specialEventDamage: SpecialEventDamage,
    @Json(name = "specialEvent_kills") val specialEventKills: SpecialEventKills,
    @Json(name = "specialEvent_wins") val specialEventWins: SpecialEventWins
)
