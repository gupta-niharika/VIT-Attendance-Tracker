package com.sanikchar.vitattendancetracker.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sanikchar.vitattendancetracker.model.ClassInfo

@Database(entities = [ClassInfo::class,], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AttendanceDb :RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: AttendanceDb? = null

        fun getInstance(context: Context): AttendanceDb =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AttendanceDb::class.java, "Attendance.db"
            ).build()
    }
}