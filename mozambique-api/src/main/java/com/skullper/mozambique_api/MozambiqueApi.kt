package com.skullper.mozambique_api

import com.skullper.mozambique_api.data.player.Platform
import com.skullper.mozambique_api.response.player.PlayerInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MozambiqueApi {

    @GET("bridge")
    fun getPlayerProfile(
        @Query("player") playerName: String,
        @Query("platform") platform: Platform
    ): Call<PlayerInfo>
}
