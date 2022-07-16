package com.skullper.account_repo.db

import com.skullper.account_repo.mapper.AccountParser
import com.skullper.badge_repo.db.BadgesDao
import com.skullper.legends_repo.db.LegendsDao
import com.skullper.mozambique_api.response.player.Account
import com.skullper.player_repo.db.PlayerDao
import com.skullper.trackers_repo.db.TrackersDao

/**
 * Helper class for storing fetched account information to the database
 */
internal class AccountStorage(
    private val accountParser: AccountParser,
    private val playerDao: PlayerDao,
    private val legendsDao: LegendsDao,
    private val badgesDao: BadgesDao,
    private val trackersDao: TrackersDao,
) {

    suspend fun storeAccount(account: Account) {
        val player = accountParser.getPlayer(account)
        val legends = accountParser.getLegends(account)
        val trackers = accountParser.getLegendTrackers(account)
        val accountBadges = accountParser.getAccountBadges(account)
        val legendBadges = accountParser.getLegendBadges(account)
        playerDao.addPlayerInfo(player)
        legendsDao.addLegends(legends)
        trackersDao.addTrackers(trackers)
        badgesDao.addBadges(legendBadges)
        badgesDao.addBadges(accountBadges)
    }
}
