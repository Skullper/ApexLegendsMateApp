package com.skullper.network_utils.okhttp.interceptors

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

internal class LoggingInterceptorProvider {

    fun provide(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor { message ->
            Log.e("HTTP", message)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        interceptor.redactHeader("Authorization")
        return interceptor
    }
}
