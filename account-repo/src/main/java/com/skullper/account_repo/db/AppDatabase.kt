package com.skullper.account_repo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.skullper.badge_repo.db.BadgeDTO
import com.skullper.badge_repo.db.BadgesDao
import com.skullper.legends_repo.db.LegendDTO
import com.skullper.legends_repo.db.LegendsDao
import com.skullper.player_repo.db.PlayerDao
import com.skullper.player_repo.db.entities.player.PlayerDTO
import com.skullper.trackers_repo.db.TrackerDTO
import com.skullper.trackers_repo.db.TrackersDao

@Database(
    entities = [PlayerDTO::class, LegendDTO::class, BadgeDTO::class, TrackerDTO::class],
    version = 1,
    exportSchema = false
)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao
    abstract fun legendsDao(): LegendsDao
    abstract fun badgesDao(): BadgesDao
    abstract fun trackersDao(): TrackersDao
    abstract fun accountDao(): AccountDao

    companion object {

        private const val DATABASE_NAME = "apex_status_db"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room
                .databaseBuilder(
                    context, AppDatabase::class.java, DATABASE_NAME
                )
                .build()
        }
    }
}
