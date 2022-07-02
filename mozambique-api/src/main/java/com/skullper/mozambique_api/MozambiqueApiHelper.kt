package com.skullper.mozambique_api

import com.skullper.mozambique_api.data.player.Platform
import com.skullper.mozambique_api.response.player.PlayerInfo
import com.skullper.network_utils.ServiceBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MozambiqueApiHelper(serviceBuilder: ServiceBuilder) {

    private val api: MozambiqueApi = serviceBuilder.build("https://api.mozambiquehe.re/")

    suspend fun getPlayerInfo(
        playerName: String,
        platform: Platform
    ): PlayerInfo = makeRequest { api.getPlayerProfile(playerName, platform) }

    private suspend fun <T> makeRequest(request: suspend () -> T): T {
        return withContext(Dispatchers.IO) {
            request()
        }
    }
}
