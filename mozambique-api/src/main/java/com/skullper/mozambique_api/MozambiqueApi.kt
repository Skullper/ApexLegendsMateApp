package com.skullper.mozambique_api

import com.skullper.mozambique_api.data.player.Platform
import com.skullper.mozambique_api.response.player.Account
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MozambiqueApi {

    @GET("bridge")
    suspend fun getPlayerProfile(
        @Query("player") playerName: String,
        @Query("platform") platform: Platform
    ): Account
}
