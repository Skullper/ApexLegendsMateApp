package com.skullper.apexlegendsmateapp.di

import com.skullper.mozambique_api.di.apiModule
import org.koin.dsl.module

val appModule = module {
    includes(apiModule)
}
