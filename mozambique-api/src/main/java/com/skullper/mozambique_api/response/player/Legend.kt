package com.skullper.mozambique_api.response.player

/**
 * Marker interface to unify all legends
 */
interface Legend {

    val data: List<Data>?
    val gameInfo: GameInfo?
    val assets: ImgAssets
}
