package com.skullper.network_utils.di

import com.skullper.network_utils.ServiceBuilder
import com.skullper.network_utils.okhttp.HttpClientProvider
import com.skullper.network_utils.okhttp.interceptors.AuthorizationHeaderInterceptorProvider
import com.skullper.network_utils.okhttp.interceptors.LoggingInterceptorProvider
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {

    factoryOf(::AuthorizationHeaderInterceptorProvider)
    factoryOf(::LoggingInterceptorProvider)
    factoryOf(::HttpClientProvider)

    singleOf(::ServiceBuilder)
}
