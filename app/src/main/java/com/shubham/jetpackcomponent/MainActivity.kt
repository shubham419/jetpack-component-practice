package com.shubham.jetpackcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import com.shubham.jetpackcomponent.database.Quote
import com.shubham.jetpackcomponent.database.QuoteDatabase
import com.shubham.jetpackcomponent.databinding.ActivityMainBinding
import com.shubham.jetpackcomponent.viewModel.MainViewModel
import com.shubham.jetpackcomponent.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val quoteDatabase = QuoteDatabase.getDatabase(this.applicationContext)
        val repository = Repository(quoteDao = quoteDatabase.quoteDao())

        val viewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        viewModel.getQuote().observe(this,{
            binding.quote = it.toString()
        })

        binding.button.setOnClickListener(View.OnClickListener {
            viewModel.insertQuote(Quote(0,"testing","shubham"))
        })

    }
}