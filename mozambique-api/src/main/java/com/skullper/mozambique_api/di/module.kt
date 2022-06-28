package com.skullper.mozambique_api.di

import com.skullper.mozambique_api.ApiKeyProviderImpl
import com.skullper.mozambique_api.MozambiqueApiHelper
import com.skullper.mozambique_api.moshi_adapters.PlatformSpecificRankAdapter
import com.skullper.mozambique_api.moshi_adapters.provider.MozambiqueTypeAdapterProvider
import com.skullper.network_utils.api.ApiKeyProvider
import com.skullper.network_utils.di.networkModule
import com.skullper.network_utils.moshi.TypeAdapterProvider
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val apiModule = module {

    includes(networkModule)

    factoryOf(::ApiKeyProviderImpl) { bind<ApiKeyProvider>() }
    factoryOf(::PlatformSpecificRankAdapter)
    factoryOf(::MozambiqueTypeAdapterProvider) { bind<TypeAdapterProvider>() }

    singleOf(::MozambiqueApiHelper)
}
