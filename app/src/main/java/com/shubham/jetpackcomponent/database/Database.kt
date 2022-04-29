package com.shubham.jetpackcomponent.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Contact::class],  version = 1)
abstract class Database : RoomDatabase() {

    abstract fun contactDao() : ContactDao

}