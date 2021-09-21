package com.sanikchar.vitattendancetracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity
data class ClassInfo(
    var subName: String?,
    var code: String?,
    var slot: String? = null,
    var stuCount: Int?,
    var startTime: Time? = null,
    var endTimeOfDay: Time? = null,
    var days: ArrayList<Int>? = null,
) {
    @PrimaryKey(autoGenerate = true)
    var id:Long =0
}