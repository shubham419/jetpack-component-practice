package com.shubham.jetpackcomponent.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Insert
    suspend fun insertQuote(quote: Quote)

    @Query("SELECT * FROM quote_table")
    fun getQuote(): LiveData<List<Quote>>
}