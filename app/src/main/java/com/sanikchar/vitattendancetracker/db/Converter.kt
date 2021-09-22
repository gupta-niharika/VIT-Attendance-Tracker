package com.sanikchar.vitattendancetracker.db

import androidx.room.TypeConverter


class Converter {

    @TypeConverter
    fun stringFromList(value:List<Int>):String{
        return value.joinToString(",")
    }

    @TypeConverter
    fun listFromString(value:String):List<Int>{
        return value.split(",").map{Integer.parseInt(it)}
    }

}