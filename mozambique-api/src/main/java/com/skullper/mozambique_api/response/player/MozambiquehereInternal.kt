package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MozambiquehereInternal(
    @Json(name = "APIAccessType") val aPIAccessType: String,
    val claimedBy: String,
    @Json(name = "ClusterID") val clusterID: String,
    val clusterSrv: String,
    val isNewToDB: Boolean,
    @Json(name = "rate_limit") val rateLimit: RateLimit
)
