package com.shubham.jetpackcomponent.database

import androidx.room.TypeConverter
import java.util.*

class ConvertDate {

    @TypeConverter
    fun dateToLong (date: Date) : Long{
        return date.time
    }

    @TypeConverter
    fun longToDate (long : Long) : Date{
        return Date(long)
    }

}