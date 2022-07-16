package com.skullper.badge_repo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BadgesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBadge(badge: BadgeDTO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBadges(badges: List<BadgeDTO>)
}
