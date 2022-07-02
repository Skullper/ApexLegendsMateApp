package com.skullper.player_repo.di

import com.skullper.mozambique_api.di.apiModule
import com.skullper.player_repo.PlayerRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val playerRepoModule = module {
    includes(apiModule)

    factoryOf(::PlayerRepository)
}
