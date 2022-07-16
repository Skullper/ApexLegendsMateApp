package com.skullper.account_repo.mapper

import com.skullper.badge_repo.db.BadgeDTO
import com.skullper.legends_repo.data.miscs.ImageAssetsDTO
import com.skullper.legends_repo.db.LegendDTO
import com.skullper.mozambique_api.response.player.*
import com.skullper.player_repo.data.battle_pass.BattlePassDTO
import com.skullper.player_repo.data.misc.BansInfoDTO
import com.skullper.player_repo.data.player.PlayerStatusDTO
import com.skullper.player_repo.data.ranks.PlayerRankDTO
import com.skullper.player_repo.db.entities.player.PlayerDTO
import com.skullper.trackers_repo.data.PlatformSpecificRankDTO
import com.skullper.trackers_repo.data.RankDTO
import com.skullper.trackers_repo.db.TrackerDTO

internal class AccountParser {

    fun getPlayer(origin: Account): PlayerDTO = with(origin) {
        PlayerDTO(
            uid = global.uid,
            arena = getArenaRank(global),
            avatar = global.avatar,
            bans = getBans(global),
            battlePass = getBattlePass(global),
            level = global.level,
            name = global.name,
            platform = global.platform,
            rank = getPlayerRank(global),
            toNextLevelPercent = global.toNextLevelPercent,
            status = getPlayerStatus(realtime),
            updated = System.currentTimeMillis(),
        )
    }

    fun getAccountBadges(origin: Account): List<BadgeDTO> = with(origin) {
        global.badges.map { badge -> badge.mapTo(global.uid, null) }
    }

    fun getLegends(origin: Account): List<LegendDTO> = with(origin.legends.all) {
        getLegends().map { legend ->
            val isSelected = legend::class.java.simpleName == origin.legends.selected.legendName
            val dto = LegendDTO(
                name = legend::class.java.simpleName,
                imgAssets = getAssets(legend.assets),
                isSelected = isSelected,
                playerId = origin.global.uid
            )
            if (isSelected) {
                dto.copy(
                    frame = origin.legends.selected.gameInfo.frame,
                    frameRarity = origin.legends.selected.gameInfo.frameRarity,
                    intro = origin.legends.selected.gameInfo.intro,
                    introRarity = origin.legends.selected.gameInfo.introRarity,
                    pose = origin.legends.selected.gameInfo.pose,
                    poseRarity = origin.legends.selected.gameInfo.poseRarity,
                    skin = origin.legends.selected.gameInfo.skin,
                    skinRarity = origin.legends.selected.gameInfo.skinRarity
                )
            } else {
                dto
            }
        }
    }

    fun getLegendTrackers(origin: Account): List<TrackerDTO> = with(origin.legends.all) {
        getLegends()
            .map { legend ->
                legend.data
                    ?.map { data ->
                        TrackerDTO(
                            0,
                            data.key,
                            data.value,
                            data.name,
                            data.rank.mapTo(),
                            data.platformSpecificRank.mapTo(),
                            legend::class.java.simpleName
                        )
                    }
                    .orEmpty()
            }
            .flatten()
    }

    fun getLegendBadges(origin: Account): List<BadgeDTO> = with(origin.legends.all) {
        getLegends()
            .map { legend ->
                legend.gameInfo?.badges
                    ?.map { badge -> badge.mapTo(origin.global.uid, legend::class.java.simpleName) }
                    .orEmpty()
            }
            .flatten()
    }

    private fun getArenaRank(origin: Global): PlayerRankDTO = with(origin.arena) {
        PlayerRankDTO(
            ladderPosPlatform, rankDiv, rankImg, rankName, rankScore, rankedSeason
        )
    }

    private fun getBans(origin: Global): BansInfoDTO = with(origin.bans) {
        BansInfoDTO(isActive, lastBanReason, remainingSeconds)
    }

    private fun getBattlePass(origin: Global): BattlePassDTO = with(origin.battlePass.history) {
        BattlePassDTO(
            season1,
            season10,
            season11,
            season12,
            season13,
            season2,
            season3,
            season4,
            season5,
            season6,
            season7,
            season8,
            season9,
            origin.battlePass.level
        )
    }

    private fun getPlayerRank(origin: Global): PlayerRankDTO = with(origin.rank) {
        PlayerRankDTO(ladderPosPlatform, rankDiv, rankImg, rankName, rankScore, rankedSeason)
    }

    private fun getPlayerStatus(origin: Realtime): PlayerStatusDTO = with(origin) {
        PlayerStatusDTO(
            canJoin.toBoolean(),
            currentState,
            currentStateSinceTimestamp,
            isInGame.toBoolean(),
            isOnline.toBoolean(),
            lobbyState,
            partyFull.toBoolean(),
            selectedLegend
        )
    }

    private fun Rank.mapTo(): RankDTO = RankDTO(rankPos, topPercent)

    private fun RankPlatformSpecific.mapTo(): PlatformSpecificRankDTO = PlatformSpecificRankDTO(rankPos, topPercent)

    private fun LegendBadge.mapTo(
        playerId: Long,
        legendName: String?
    ): BadgeDTO {
        return BadgeDTO(0L, name, value, null, playerId, legendName)
    }

    private fun getAssets(origin: ImgAssets): ImageAssetsDTO = with(origin) {
        ImageAssetsDTO(banner, icon)
    }

    private fun Int.toBoolean() = this == 1
}
