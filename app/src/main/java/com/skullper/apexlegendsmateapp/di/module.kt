package com.skullper.apexlegendsmateapp.di

import com.skullper.player_repo.di.playerRepoModule
import org.koin.dsl.module

val appModule = module {
    includes(playerRepoModule)
}
