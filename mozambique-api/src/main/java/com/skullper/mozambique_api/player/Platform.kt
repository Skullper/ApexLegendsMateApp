package com.skullper.mozambique_api.player

import com.squareup.moshi.Json

/**
 * List of supported platforms by the mozambique api
 */
enum class Platform {

    @Json(name = "PC")
    PC,

    @Json(name = "X1")
    XBOX,

    /**
     * Supports a PS 4 and 5 versions
     */
    @Json(name = "PS4")
    PS,
}
