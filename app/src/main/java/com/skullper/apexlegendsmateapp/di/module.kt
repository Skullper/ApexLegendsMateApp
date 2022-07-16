package com.skullper.apexlegendsmateapp.di

import com.skullper.account_repo.di.accountRepoModule
import org.koin.dsl.module

val appModule = module {
    includes(accountRepoModule)
}
