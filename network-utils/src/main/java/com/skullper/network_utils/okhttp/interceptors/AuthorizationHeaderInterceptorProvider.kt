package com.skullper.network_utils.okhttp.interceptors

import com.skullper.network_utils.api.ApiKeyProvider
import okhttp3.Interceptor

internal class AuthorizationHeaderInterceptorProvider(private val apiKeyProvider: ApiKeyProvider) {

    fun provide(): Interceptor {
        val apiKey = apiKeyProvider.provide()
        return Interceptor { chain ->
            val request = chain
                .request()
                .newBuilder()
                .addHeader("Authorization", apiKey)
                .build()
            chain.proceed(request)
        }
    }
}
