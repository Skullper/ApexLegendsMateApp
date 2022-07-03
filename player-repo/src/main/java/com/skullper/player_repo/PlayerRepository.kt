package com.skullper.player_repo

import com.skullper.mozambique_api.MozambiqueApiHelper
import com.skullper.mozambique_api.data.player.Platform
import com.skullper.player_repo.data.player.PlayerDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Provides whole information about a player
 */
class PlayerRepository internal constructor(
    private val api: MozambiqueApiHelper,
    private val dispatcher: CoroutineDispatcher,
    private val playerMapper: PlayerMapper,
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
    ): PlayerDTO = withContext(dispatcher) {
        val player = api.getPlayerInfo(playerName, platform)
        playerMapper.map(player)
    }
}
