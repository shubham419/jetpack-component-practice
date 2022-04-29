package com.shubham.jetpackcomponent

import androidx.lifecycle.LiveData
import com.shubham.jetpackcomponent.database.Quote
import com.shubham.jetpackcomponent.database.QuoteDao

class Repository (val quoteDao : QuoteDao){


    fun getQuote(): LiveData<List<Quote>>{
        return quoteDao.getQuote()
    }

    suspend fun insertQuote(quote : Quote){
        quoteDao.insertQuote(quote)
    }


}