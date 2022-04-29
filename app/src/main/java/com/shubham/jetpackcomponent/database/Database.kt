package com.shubham.jetpackcomponent.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Contact::class],  version = 1)
@TypeConverters(ConvertDate::class)
abstract class Database : RoomDatabase() {

    abstract fun contactDao() : ContactDao

    companion object{
        @Volatile
        private var DATABASE : com.shubham.jetpackcomponent.database.Database ? = null

        fun getDatabase(context : Context) : com.shubham.jetpackcomponent.database.Database{
            if(DATABASE == null) {
                synchronized(this) {
                    DATABASE = Room.databaseBuilder(
                        context,
                        com.shubham.jetpackcomponent.database.Database::class.java, "Database"
                    ).build()
                }
            }
        return DATABASE!!
        }
    }

}