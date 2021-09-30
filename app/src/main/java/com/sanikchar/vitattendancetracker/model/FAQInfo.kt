package com.sanikchar.vitattendancetracker.model

import androidx.room.PrimaryKey

data class FAQInfo(
    var question: String,
    var answer: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
