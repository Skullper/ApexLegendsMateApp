package com.skullper.network_utils

import com.skullper.network_utils.moshi.MoshiBuilder
import com.skullper.network_utils.okhttp.HttpClientProvider
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ServiceBuilder internal constructor(
    @PublishedApi internal val httpClientProvider: HttpClientProvider,
    @PublishedApi internal val moshiBuilder: MoshiBuilder,
) {

    inline fun <reified T> build(baseUrl: String): T {
        val moshi = moshiBuilder.build()
        val converterFactory = MoshiConverterFactory.create(moshi)
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(httpClientProvider.provide())
            .build()
        return retrofit.create(T::class.java)
    }
}
