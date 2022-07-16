package com.skullper.trackers_repo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface TrackersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTracker(tracker: TrackerDTO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrackers(trackers: List<TrackerDTO>)
}
