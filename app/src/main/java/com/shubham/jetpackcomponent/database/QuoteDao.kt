package com.shubham.jetpackcomponent.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.shubham.jetpackcomponent.model.Result

@Dao
interface QuoteDao {

    @Insert
    fun insertQuote(result : List<Result>)

    @Query("SELECT * FROM quote")
    fun getQuote(): List<Result>

}