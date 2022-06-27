package com.skullper.network_utils.okhttp

import com.skullper.network_utils.okhttp.interceptors.AuthorizationHeaderInterceptorProvider
import com.skullper.network_utils.okhttp.interceptors.LoggingInterceptorProvider
import okhttp3.OkHttpClient

@PublishedApi
internal class HttpClientProvider(
    private val authInterceptorProvider: AuthorizationHeaderInterceptorProvider,
    private val loggingInterceptorProvider: LoggingInterceptorProvider,
) {

    fun provide(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor(authInterceptorProvider.provide())
        client.addInterceptor(loggingInterceptorProvider.provide())
        return client.build()
    }
}
