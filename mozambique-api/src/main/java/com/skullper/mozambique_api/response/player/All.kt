package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class All(
    @Json(name = "Ash") val ash: Ash,
    @Json(name = "Bangalore") val bangalore: Bangalore,
    @Json(name = "Bloodhound") val bloodhound: Bloodhound,
    @Json(name = "Caustic") val caustic: Caustic,
    @Json(name = "Crypto") val crypto: Crypto,
    @Json(name = "Fuse") val fuse: Fuse,
    @Json(name = "Gibraltar") val gibraltar: Gibraltar,
    @Json(name = "Global") val global: GlobalX,
    @Json(name = "Horizon") val horizon: Horizon,
    @Json(name = "Lifeline") val lifeline: Lifeline,
    @Json(name = "Loba") val loba: Loba,
    @Json(name = "Mad Maggie") val madMaggie: MadMaggie,
    @Json(name = "Mirage") val mirage: Mirage,
    @Json(name = "Newcastle") val newcastle: Newcastle,
    @Json(name = "Octane") val octane: Octane,
    @Json(name = "Pathfinder") val pathfinder: Pathfinder,
    @Json(name = "Rampart") val rampart: Rampart,
    @Json(name = "Revenant") val revenant: Revenant,
    @Json(name = "Seer") val seer: Seer,
    @Json(name = "Valkyrie") val valkyrie: Valkyrie,
    @Json(name = "Wattson") val wattson: Wattson,
    @Json(name = "Wraith") val wraith: Wraith
)
