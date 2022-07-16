package com.skullper.legends_repo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LegendsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLegend(legend: LegendDTO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLegends(legends: List<LegendDTO>)

    @Query("SELECT * FROM ${LegendDTO.TABLE_NAME} where ${LegendDTO.NAME} = :name")
    suspend fun getLegend(name: String): LegendDTO

    @Query(
        "SELECT * FROM ${LegendDTO.TABLE_NAME} " +
            "where ${LegendDTO.NAME} = :name AND ${LegendDTO.KEY_PLAYER_ID} = :playerId"
    )
    suspend fun getLegendForPlayer(
        name: String,
        playerId: Long
    ): LegendDTO

    @Query("SELECT * FROM ${LegendDTO.TABLE_NAME}")
    suspend fun getAllLegends(): List<LegendDTO>
}
