package com.skullper.network_utils

import com.skullper.network_utils.okhttp.HttpClientProvider
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ServiceBuilder internal constructor(@PublishedApi internal val httpClientProvider: HttpClientProvider) {

    inline fun <reified T> build(baseUrl: String): T {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClientProvider.provide())
            .build()
        return retrofit.create(T::class.java)
    }
}
