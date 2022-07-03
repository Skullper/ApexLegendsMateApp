package com.skullper.mozambique_api.response.player

import com.skullper.mozambique_api.moshi_adapters.NotCalculatedRank
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//@formatter:off
@JsonClass(generateAdapter = true)
data class Data(
    val key: String,
    val name: String,
    val rank: Rank,
    @NotCalculatedRank
    @Json(name = "rankPlatformSpecific")
    val platformSpecificRank: RankPlatformSpecific,
    val value: Int
)
//@formatter:on
