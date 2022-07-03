package com.skullper.player_repo.data.legend

import com.skullper.player_repo.data.legend.selected.SelectedLegendDTO
import com.skullper.player_repo.data.misc.ImageAssetsDTO

/**
 * @property selected is not null if legend is currently selected(visible in lobby)
 */
data class LegendDTO(
    val name: String,
    val imgAssets: ImageAssetsDTO,
    val data: List<LegendDataDTO>? = null,
    val gameInfo: LegendGameInfoDTO? = null,
    val selected: SelectedLegendDTO? = null
)
