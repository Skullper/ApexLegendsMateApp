package com.skullper.player_repo.di

import com.skullper.mozambique_api.di.apiModule
import com.skullper.player_repo.PlayerRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val playerRepoModule = module {
    includes(apiModule)

    factory { PlayerRepository(get(), Dispatchers.IO) }
}
