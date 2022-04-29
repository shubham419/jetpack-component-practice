package com.shubham.jetpackcomponent.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubham.jetpackcomponent.Repository
import com.shubham.jetpackcomponent.database.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    fun insertQuote(quote : Quote) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertQuote(quote)
        }
    }

    fun getQuote(): LiveData<List<Quote>>{
        return repository.getQuote()
    }

}