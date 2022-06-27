package com.skullper.mozambique_api

import com.skullper.mozambique_api.player.Platform
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MozambiqueApi {

    @GET("bridge")
    fun getPlayerProfile(
        @Query("player") playerName: String,
        @Query("platform") platform: Platform
    ): Call<ResponseBody>
}
