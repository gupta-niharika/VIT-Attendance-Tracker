package com.sanikchar.vitattendancetracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity
data class ClassInfo(
    var subName: String,
    var code: String,
    var slot: String? = null,
    var stuCount: Int = 0,
    var startTime: String? = null,
    var endTime: String? = null,
    var days: List<Int>? = null,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}