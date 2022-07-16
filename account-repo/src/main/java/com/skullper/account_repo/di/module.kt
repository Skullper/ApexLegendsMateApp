package com.skullper.account_repo.di

import com.skullper.account_repo.AccountRepository
import com.skullper.account_repo.db.AccountStorage
import com.skullper.account_repo.db.AppDatabase
import com.skullper.account_repo.mapper.AccountParser
import com.skullper.mozambique_api.di.apiModule
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val accountRepoModule = module {

    includes(apiModule)

    factoryOf(::AccountParser)
    factory { AccountRepository(get(), get(), get(), Dispatchers.IO) }
    factory { get<AppDatabase>().playerDao() }
    factory { get<AppDatabase>().legendsDao() }
    factory { get<AppDatabase>().badgesDao() }
    factory { get<AppDatabase>().trackersDao() }
    factory { get<AppDatabase>().accountDao() }
    factoryOf(::AccountStorage)

    singleOf(AppDatabase::getInstance)
}
