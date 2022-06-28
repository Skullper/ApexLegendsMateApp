package com.skullper.mozambique_api.response.player

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SelectedLegendData(
    val global: Boolean,
    val key: String,
    val name: String,
    val value: Int
)
