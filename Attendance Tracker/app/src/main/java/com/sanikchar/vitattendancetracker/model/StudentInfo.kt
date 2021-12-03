package com.sanikchar.vitattendancetracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentInfo(
    var stuName: String,
    var regNo: String,
    var presence: Boolean? = true
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
