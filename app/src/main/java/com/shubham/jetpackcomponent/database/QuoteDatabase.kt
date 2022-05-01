package com.shubham.jetpackcomponent.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shubham.jetpackcomponent.model.Result

@Database(entities = [Result::class], version = 1)
abstract class QuoteDatabase :RoomDatabase() {

    abstract fun quoteDoa() : QuoteDao

    companion object{
        @Volatile
        private var INSTANCE : QuoteDatabase? = null

        fun getInstance(context: Context) : QuoteDatabase{
            if(INSTANCE == null){
                synchronized(this){
                INSTANCE = Room.databaseBuilder(context,QuoteDatabase::class.java,"quote-db").build()
             }
            }
            return INSTANCE!!
        }

    }

}