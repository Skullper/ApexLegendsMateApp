package com.skullper.account_repo.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.skullper.account_repo.data.AccountInfo
import com.skullper.account_repo.data.LegendInfo
import com.skullper.legends_repo.db.LegendDTO
import com.skullper.player_repo.db.entities.player.PlayerDTO

@Dao
interface AccountDao {

    @Transaction
    @Query("SELECT * FROM ${PlayerDTO.TABLE_NAME} WHERE ${PlayerDTO.ID} = :id")
    suspend fun getAccount(id: Long): AccountInfo

    @Transaction
    @Query("SELECT * FROM ${PlayerDTO.TABLE_NAME} ORDER BY ${PlayerDTO.ID} DESC LIMIT 1")
    suspend fun getLastCachedAccount(): AccountInfo

    @Transaction
    @Query("SELECT * FROM ${LegendDTO.TABLE_NAME}")
    suspend fun getLegends(): List<LegendInfo>

    @Transaction
    @Query("SELECT * FROM ${LegendDTO.TABLE_NAME} WHERE ${LegendDTO.KEY_PLAYER_ID} = :playerId")
    suspend fun getLegends(playerId: Long): List<LegendInfo>
}
