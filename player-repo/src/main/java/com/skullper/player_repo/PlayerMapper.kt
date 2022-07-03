package com.skullper.player_repo

import com.skullper.mozambique_api.response.player.*
import com.skullper.player_repo.data.arenas.ArenaDTO
import com.skullper.player_repo.data.badges.AccountBadgeDTO
import com.skullper.player_repo.data.badges.LegendBadgeDTO
import com.skullper.player_repo.data.battle_pass.BattlePassDTO
import com.skullper.player_repo.data.battle_pass.BattlePassHistoryDTO
import com.skullper.player_repo.data.legend.LegendDTO
import com.skullper.player_repo.data.legend.LegendDataDTO
import com.skullper.player_repo.data.legend.LegendGameInfoDTO
import com.skullper.player_repo.data.legend.selected.SelectedLegendDTO
import com.skullper.player_repo.data.legend.selected.SelectedLegendDataDTO
import com.skullper.player_repo.data.legend.selected.SelectedLegendGameInfoDTO
import com.skullper.player_repo.data.misc.BansInfoDTO
import com.skullper.player_repo.data.misc.ImageAssetsDTO
import com.skullper.player_repo.data.player.PlayerDTO
import com.skullper.player_repo.data.player.PlayerDataDTO
import com.skullper.player_repo.data.player.PlayerStatusDTO
import com.skullper.player_repo.data.ranks.PlatformSpecificRankDTO
import com.skullper.player_repo.data.ranks.PlayerRankDTO
import com.skullper.player_repo.data.ranks.RankDTO

internal class PlayerMapper {

    fun map(origin: PlayerInfo): PlayerDTO = with(origin) {
        PlayerDTO(
            uid = global.uid,
            data = getPlayerData(global),
            legends = getLegends(legends),
            status = getPlayerStatus(realtime)
        )
    }

    private fun getPlayerData(origin: Global): PlayerDataDTO = with(origin) {
        PlayerDataDTO(
            arena = getArena(arena),
            avatar = avatar,
            badges = getPlayerBadges(badges),
            bans = getBansInfo(bans),
            battlePass = getBattlePassInfo(battlePass),
            level = level,
            name = name,
            platform = platform,
            rank = getPlayerRank(rank),
            toNextLevelPercent
        )
    }

    private fun getPlayerStatus(origin: Realtime): PlayerStatusDTO = with(origin) {
        PlayerStatusDTO(
            canJoin.toBoolean(),
            currentState,
            currentStateAsText,
            currentStateSinceTimestamp,
            isInGame.toBoolean(),
            isOnline.toBoolean(),
            lobbyState,
            partyFull.toBoolean(),
            selectedLegend
        )
    }

    private fun getArena(origin: Arena): ArenaDTO = with(origin) {
        ArenaDTO(
            ladderPosPlatform, rankDiv, rankImg, rankName, rankScore, rankedSeason
        )
    }

    private fun getPlayerBadges(origin: List<LegendBadge>): List<LegendBadgeDTO> = with(origin) {
        map(::getLegendBadge)
    }

    private fun getLegendBadge(origin: LegendBadge): LegendBadgeDTO = with(origin) {
        LegendBadgeDTO(name, value)
    }

    private fun getBansInfo(origin: Bans): BansInfoDTO = with(origin) {
        BansInfoDTO(isActive, lastBanReason, remainingSeconds)
    }

    private fun getBattlePassInfo(origin: BattlePass): BattlePassDTO = with(origin) {
        BattlePassDTO(history = getBattlePassHistory(history), level)
    }

    private fun getBattlePassHistory(origin: History): BattlePassHistoryDTO = with(origin) {
        BattlePassHistoryDTO(
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
            season9
        )
    }

    private fun getPlayerRank(origin: PlayerRank): PlayerRankDTO = with(origin) {
        PlayerRankDTO(ladderPosPlatform, rankDiv, rankImg, rankName, rankScore, rankedSeason)
    }

    private fun getLegends(origin: Legends): List<LegendDTO> = with(origin) {
        all
            .getLegends()
            .map { legend ->
                LegendDTO(
                    name = legend::class.java.simpleName,
                    imgAssets = getAssets(legend.assets),
                    data = getLegendData(legend.data),
                    gameInfo = getLegendGameInfo(legend.gameInfo),
                    selected = getSelectedLegend(legend, selected)
                )
            }
    }

    private fun getSelectedLegend(
        legend: Legend,
        selected: Selected
    ): SelectedLegendDTO? {
        val name = legend::class.java.simpleName
        return if (selected.legendName == name) {
            createSelectedLegend(selected)
        } else {
            null
        }
    }

    private fun createSelectedLegend(origin: Selected): SelectedLegendDTO = with(origin) {
        SelectedLegendDTO(
            data = data.map(::getSelectedLegendData),
            gameInfo = getSelectedLegendGameInfo(gameInfo),
            imgAssets = getAssets(imgAssets),
            legendName = legendName
        )
    }

    private fun getSelectedLegendData(origin: SelectedLegendData): SelectedLegendDataDTO = with(origin) {
        SelectedLegendDataDTO(global, key, name, value)
    }

    private fun getSelectedLegendGameInfo(origin: SelectedLegendGameInfo): SelectedLegendGameInfoDTO = with(origin) {
        SelectedLegendGameInfoDTO(
            badges.map(::getAccountBadge), frame, frameRarity, intro, introRarity, pose, poseRarity, skin, skinRarity
        )
    }

    private fun getAccountBadge(origin: AccountBadge): AccountBadgeDTO = with(origin) {
        AccountBadgeDTO(category, name, value)
    }

    private fun getAssets(origin: ImgAssets): ImageAssetsDTO = with(origin) {
        ImageAssetsDTO(banner, icon)
    }

    private fun getLegendGameInfo(origin: GameInfo?): LegendGameInfoDTO? {
        return origin?.let { LegendGameInfoDTO(it.badges.map(::getLegendBadge)) }
    }

    private fun getLegendData(list: List<Data>?): List<LegendDataDTO>? {
        return list?.map(::getLegendData)
    }

    private fun getLegendData(origin: Data): LegendDataDTO = with(origin) {
        LegendDataDTO(key, name, getLegendRank(rank), getLegendPlatformSpecificRank(origin.platformSpecificRank), value)
    }

    private fun getLegendRank(origin: Rank): RankDTO = with(origin) {
        RankDTO(rankPos, topPercent)
    }

    private fun getLegendPlatformSpecificRank(origin: RankPlatformSpecific): PlatformSpecificRankDTO = with(origin) {
        PlatformSpecificRankDTO(rankPos, topPercent)
    }

    private fun Int.toBoolean() = this == 1
}
