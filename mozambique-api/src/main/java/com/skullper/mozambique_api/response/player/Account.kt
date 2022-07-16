package com.skullper.mozambique_api.response.player

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Account(
    @Json(name = "ALS") val aLS: ALS,
    val global: Global,
    val legends: Legends,
    @Json(name = "mozambiquehere_internal") val mozambiquehereInternal: MozambiquehereInternal,
    val realtime: Realtime,
    val total: Total
)
