package com.skullper.mozambique_api.di

import com.skullper.mozambique_api.ApiKeyProviderImpl
import com.skullper.mozambique_api.MozambiqueApiHelper
import com.skullper.network_utils.api.ApiKeyProvider
import com.skullper.network_utils.di.networkModule
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val apiModule = module {

    includes(networkModule)

    factoryOf(::ApiKeyProviderImpl) { bind<ApiKeyProvider>() }
    singleOf(::MozambiqueApiHelper)
}
