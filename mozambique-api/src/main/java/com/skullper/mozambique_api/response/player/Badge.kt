package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Badge(
    val name: String?,
    val value: Int,
    val category: String?,
)
