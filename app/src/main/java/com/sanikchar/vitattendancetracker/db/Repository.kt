package com.sanikchar.vitattendancetracker.db

import android.content.Context
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.sanikchar.vitattendancetracker.model.ClassInfo
import com.sanikchar.vitattendancetracker.model.Result

class Repository(private val context: Context) {
    private val databaseDao: DatabaseDao by lazy { AttendanceDb.getInstance(context).databaseDao() }

    fun getClassesOrder(orderBy: String = "subName ASC") = liveData {
        try {
            emitSource(databaseDao.getClassesOrdered(orderBy).map {
                Result.Success(it)
            })
        } catch (e: Exception) {
            emitSource(databaseDao.getClassesOrdered(orderBy).map {
                Result.Error(e)
            })
        }
    }

    suspend fun addClassInfo(classInfo: ClassInfo): Boolean =
        databaseDao.addClassInfo(classInfo) != -1L
}