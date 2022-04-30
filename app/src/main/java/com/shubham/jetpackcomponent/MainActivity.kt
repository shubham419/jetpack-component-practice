package com.shubham.jetpackcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import com.shubham.jetpackcomponent.api.QuoteService
import com.shubham.jetpackcomponent.api.RetrofitHelper
import com.shubham.jetpackcomponent.databinding.ActivityMainBinding
import com.shubham.jetpackcomponent.repository.QuoteRepository
import com.shubham.jetpackcomponent.viewModel.MainViewModel
import com.shubham.jetpackcomponent.viewModel.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        val quoteService  = RetrofitHelper.getRetrofitInstance().create(QuoteService::class.java)
        val quoteRepository = QuoteRepository(quoteService)
        val viewModel = ViewModelProvider(this, MainViewModelFactory(quoteRepository)).get(MainViewModel::class.java)



        viewModel.quote.observe(this,{
          Log.d ("xyz", it.results.toString())
        })


    }
}