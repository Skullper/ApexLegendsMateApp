package com.skullper.account_repo

import com.skullper.account_repo.data.AccountInfo
import com.skullper.account_repo.data.LegendInfo
import com.skullper.account_repo.data.PlatformType
import com.skullper.account_repo.data.mapTo
import com.skullper.account_repo.db.AccountDao
import com.skullper.account_repo.db.AccountStorage
import com.skullper.mozambique_api.MozambiqueApiHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AccountRepository internal constructor(
    private val api: MozambiqueApiHelper,
    private val accountDao: AccountDao,
    private val accountStorage: AccountStorage,
    private val dispatcher: CoroutineDispatcher,
) {

    /**
     * @param playerName of the request player. If [PlatformType.PC] selected must be an Origin ID
     * @param platform where player was created
     *
     * @return all available information about player
     */
    suspend fun getAccountInfo(
        playerName: String,
        platform: PlatformType = PlatformType.PC
    ): AccountInfo = withContext(dispatcher) {
        val account = api.getAccount(playerName, platform.mapTo())
        accountStorage.storeAccount(account)
        accountDao.getAccount(account.global.uid)
    }

    /**
     * @return only the last cached account information
     */
    suspend fun getCachedAccountInfo(): AccountInfo = accountDao.getLastCachedAccount()

    /**
     * @return all cached legends
     */
    suspend fun getLegendsInfo(): List<LegendInfo> = withContext(dispatcher) {
        accountDao.getLegends()
    }
}
