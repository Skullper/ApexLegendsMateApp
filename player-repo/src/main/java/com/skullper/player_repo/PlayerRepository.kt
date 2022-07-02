package com.skullper.player_repo

import com.skullper.mozambique_api.MozambiqueApiHelper
import com.skullper.mozambique_api.data.player.Platform
import com.skullper.mozambique_api.response.player.PlayerInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Provides whole information about a player
 */
class PlayerRepository(
    private val api: MozambiqueApiHelper,
    private val dispatcher: CoroutineDispatcher,
) {

    /**
     * @param playerName of the request player. If [Platform.PC] selected must be an Origin ID
     * @param platform where player was created
     *
     * @return all available information about player
     */
    suspend fun getPlayerInfo(
        playerName: String,
        platform: Platform = Platform.PC
    ): PlayerInfo = withContext(dispatcher) {
        api.getPlayerInfo(playerName, platform)
    }
}
