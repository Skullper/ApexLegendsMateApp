package com.skullper.mozambique_api.moshi_adapters

import android.util.Log
import com.skullper.mozambique_api.response.player.PlatformSpecificRank
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

internal class PlatformSpecificRankAdapter {

    @FromJson
    fun fromJson(json: String): PlatformSpecificRank {
        val rankPos = json[0]
        val percent = json[1]
        Log.e("TAGA", "Rank: $rankPos | percent: $percent")
        return PlatformSpecificRank(
            0, 0.toDouble()
        )
    }

    @ToJson
    fun toJson(platformSpecific: PlatformSpecificRank): String {
        return platformSpecific.rankPos.toString()
    }
}
