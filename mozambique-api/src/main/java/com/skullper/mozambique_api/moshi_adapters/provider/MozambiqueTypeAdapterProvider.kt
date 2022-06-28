package com.skullper.mozambique_api.moshi_adapters.provider

import com.skullper.mozambique_api.moshi_adapters.PlatformSpecificRankAdapter
import com.skullper.network_utils.moshi.TypeAdapterProvider

class MozambiqueTypeAdapterProvider internal constructor(
    private val platformSpecificRankAdapter: PlatformSpecificRankAdapter,
) : TypeAdapterProvider {

    override fun provide(): List<Any> = listOf(platformSpecificRankAdapter)
}
