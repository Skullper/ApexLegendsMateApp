package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class History(
    val season1: Int,
    val season10: Int,
    val season11: Int,
    val season12: Int,
    val season13: Int,
    val season2: Int,
    val season3: Int,
    val season4: Int,
    val season5: Int,
    val season6: Int,
    val season7: Int,
    val season8: Int,
    val season9: Int
)
