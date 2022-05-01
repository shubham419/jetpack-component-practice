package com.shubham.jetpackcomponent.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shubham.jetpackcomponent.model.QuoteList
import com.shubham.jetpackcomponent.api.QuoteService
import com.shubham.jetpackcomponent.database.QuoteDatabase
import com.shubham.jetpackcomponent.utils.NetworkUtils

class QuoteRepository(
    private val quoteService: QuoteService,
    private val database: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quoteLiveData = MutableLiveData<QuoteList>()

    val quote: LiveData<QuoteList>
    get() = quoteLiveData

    suspend fun getQuote(page:Int){

        if(NetworkUtils.isInternetAvailable(context = applicationContext)){
            val result = quoteService.getQuotes(page)

            if(result?.body() != null){
                database.quoteDoa().insertQuote(result.body()!!.results)
                quoteLiveData.postValue(result.body())
            }        }
        else{
            val quotes  = database.quoteDoa().getQuote()
            val quoteList = QuoteList(1,1,1,quotes,1,1)
            quoteLiveData.postValue(quoteList)
        }


    }

}