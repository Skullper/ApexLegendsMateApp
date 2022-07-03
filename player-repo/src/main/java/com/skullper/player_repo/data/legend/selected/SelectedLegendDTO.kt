package com.skullper.player_repo.data.legend.selected

import com.skullper.player_repo.data.misc.ImageAssetsDTO

data class SelectedLegendDTO(
    val data: List<SelectedLegendDataDTO>,
    val gameInfo: SelectedLegendGameInfoDTO,
    val imgAssets: ImageAssetsDTO,
    val legendName: String
)
