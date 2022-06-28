package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    val key: String,
    val name: String,
    val rank: Rank,
    @Json(name = "rankPlatformSpecific") val platformSpecificRank: PlatformSpecificRank,
    val value: Int
)
