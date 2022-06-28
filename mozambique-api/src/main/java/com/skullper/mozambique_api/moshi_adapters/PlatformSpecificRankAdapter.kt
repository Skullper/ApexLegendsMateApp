package com.skullper.mozambique_api.moshi_adapters

import com.skullper.mozambique_api.response.player.RankPlatformSpecific
import com.skullper.mozambique_api.response.player.RankPlatformSpecificNoCalculated
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson

/**
 * Sometimes API ranks can be not calculated yet.
 * If this happens the response for a [RankPlatformSpecific] model will looks like [RankPlatformSpecificNoCalculated].
 * This is fixed by [PlatformSpecificRankAdapter].
 * But because moshi codegen used in project we need to create a [JsonQualifier] for this case.
 */
@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class NotCalculatedRank

@Suppress("unused")
internal class PlatformSpecificRankAdapter {

    @NotCalculatedRank
    @FromJson
    fun fromJson(notCalculatedRank: RankPlatformSpecificNoCalculated): RankPlatformSpecific {
        val rankPos = notCalculatedRank.rankPos.toIntOrNull()
        val topPercent = notCalculatedRank.topPercent.toDoubleOrNull()
        return RankPlatformSpecific(rankPos, topPercent)
    }

    @Suppress("UNUSED_PARAMETER")
    @ToJson
    fun toJson(@NotCalculatedRank platformSpecific: RankPlatformSpecific): String {
        throw UnsupportedOperationException()
    }
}
