package com.shubham.jetpackcomponent.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shubham.jetpackcomponent.model.QuoteList
import com.shubham.jetpackcomponent.api.QuoteService

class QuoteRepository(private val quoteService: QuoteService) {

    private val quoteLiveData = MutableLiveData<QuoteList>()

    val quote: LiveData<QuoteList>
    get() = quoteLiveData

    suspend fun getQuote(page:Int){

        val result = quoteService.getQuotes(1)
        if(result?.body() != null){
            quoteLiveData.postValue(result.body())
        }

    }

}