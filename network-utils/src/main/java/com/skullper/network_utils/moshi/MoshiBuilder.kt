package com.skullper.network_utils.moshi

import com.squareup.moshi.Moshi

@PublishedApi
internal class MoshiBuilder(private val adapterProvider: TypeAdapterProvider) {

    fun build(): Moshi {
        val builder = Moshi.Builder()
        adapterProvider
            .provide()
            .forEach(builder::add)
        return builder.build()
    }
}
