package com.sanikchar.vitattendancetracker.model

import androidx.room.Entity
import java.sql.Time

@Entity
data class ClassInfo(
    val name: String,
    val code: String,
    val slot: String,
    val stuCount: Int,
    val startTime: Time,
    val endTimeOfDay: Time,
    val days: ArrayList<Int>,
) {
}