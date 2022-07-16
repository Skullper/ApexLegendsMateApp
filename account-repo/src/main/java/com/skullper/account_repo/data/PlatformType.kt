package com.skullper.account_repo.data

import com.skullper.mozambique_api.data.player.Platform

/**
 * List of supported platforms by the mozambique api
 */
enum class PlatformType {

    /**
     * Origin and Steam
     */
    PC,

    XBOX,

    /**
     * Supports a PS 4 and 5 versions
     */
    PS,
}

/**
 * A mapper to mozambique api type
 */
fun PlatformType.mapTo(): Platform = when (this) {
    PlatformType.PC -> Platform.PC
    PlatformType.XBOX -> Platform.XBOX
    PlatformType.PS -> Platform.PS
}
