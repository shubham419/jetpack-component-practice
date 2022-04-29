package com.shubham.jetpackcomponent.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class],  version = 2)
@TypeConverters(ConvertDate::class)
abstract class Database : RoomDatabase() {

    abstract fun contactDao() : ContactDao

    companion object{
        @Volatile
        private var DATABASE : com.shubham.jetpackcomponent.database.Database ? = null

        val migration_1_2 = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }

        fun getDatabase(context : Context) : com.shubham.jetpackcomponent.database.Database{
            if(DATABASE == null) {
                synchronized(this) {
                    DATABASE = Room.databaseBuilder(
                        context.applicationContext,
                        com.shubham.jetpackcomponent.database.Database::class.java, "Database"
                    ).addMigrations(migration_1_2).build()
                }
            }
        return DATABASE!!
        }
    }

}