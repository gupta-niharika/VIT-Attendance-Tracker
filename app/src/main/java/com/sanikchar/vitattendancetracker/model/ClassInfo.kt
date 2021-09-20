package com.sanikchar.vitattendancetracker.model

import androidx.room.Entity
import java.sql.Time

@Entity
data class ClassInfo(
    var subName: String?,
    var code: String?,
    var slot: String?,
    var stuCount: Int?,
    var startTime: Time?,
    var endTimeOfDay: Time?,
    var days: ArrayList<Int>?,
) {
    constructor(
        subName: String?,
        code: String?,
        stuCount: Int?,
        startTime: Time?,
    ) :this(subName, code, null, stuCount, startTime, null, null){
        this.subName = subName
        this.code = code
        this.stuCount = stuCount
        this.startTime = startTime
    }
}