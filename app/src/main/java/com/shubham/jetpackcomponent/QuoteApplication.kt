package com.shubham.jetpackcomponent

import android.app.Application
import com.shubham.jetpackcomponent.api.QuoteService
import com.shubham.jetpackcomponent.api.RetrofitHelper
import com.shubham.jetpackcomponent.database.QuoteDatabase
import com.shubham.jetpackcomponent.repository.QuoteRepository

class QuoteApplication : Application() {
    lateinit var quoteRepository : QuoteRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService  = RetrofitHelper.getRetrofitInstance().create(QuoteService::class.java)
        val quoteDatabase = QuoteDatabase.getInstance(applicationContext)
        quoteRepository = QuoteRepository(quoteService, quoteDatabase, applicationContext)
    }
}