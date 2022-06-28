package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RateLimit(
    @Json(name = "current_req") val currentReq: Any?,
    @Json(name = "max_per_second") val maxPerSecond: Int
)
