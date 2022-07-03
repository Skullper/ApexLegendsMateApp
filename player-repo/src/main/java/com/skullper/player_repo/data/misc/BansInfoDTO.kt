package com.skullper.player_repo.data.misc

data class BansInfoDTO(
    val isActive: Boolean,
    val lastBanReason: String,
    val remainingSeconds: Int
)
