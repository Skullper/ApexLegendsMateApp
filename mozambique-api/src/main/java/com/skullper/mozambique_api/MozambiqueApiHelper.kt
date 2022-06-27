package com.skullper.mozambique_api

import android.util.Log
import com.skullper.mozambique_api.player.Platform
import com.skullper.network_utils.ServiceBuilder
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MozambiqueApiHelper(serviceBuilder: ServiceBuilder) {

    private val api: MozambiqueApi = serviceBuilder.build("https://api.mozambiquehe.re/")

    fun getPlayerInfo(
        playerName: String,
        platform: Platform = Platform.PC
    ) {
        api.getPlayerProfile(playerName, platform)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    Log.e("TAGA", "Result: ${response.isSuccessful}")
                }

                override fun onFailure(
                    call: Call<ResponseBody>,
                    t: Throwable
                ) {
                    Log.e("TAGA", "Failure", t)
                }
            })
    }
}
