package com.shubham.jetpackcomponent.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubham.jetpackcomponent.model.QuoteList
import com.shubham.jetpackcomponent.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
        quoteRepository.getQuote(1)
        }
    }
    val quote : LiveData<QuoteList>
    get() = quoteRepository.quote
}