package com.sanikchar.vitattendancetracker.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sanikchar.vitattendancetracker.model.ClassInfo

@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addClassInfo(classInfo: ClassInfo):Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateClassInfo(classInfo: ClassInfo)

    @Query("SELECT * FROM ClassInfo ORDER BY :orderBy")
    fun getClassesOrdered(orderBy:String ) : LiveData<List<ClassInfo>>

    @Delete
    suspend fun deleteClassInfo(classInfo: ClassInfo)

    @Query("DELETE FROM ClassInfo")
    suspend fun deleteAllClasses()
}