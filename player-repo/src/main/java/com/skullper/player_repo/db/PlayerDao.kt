package com.skullper.player_repo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.skullper.player_repo.db.entities.player.PlayerDTO

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlayerInfo(player: PlayerDTO)
}
