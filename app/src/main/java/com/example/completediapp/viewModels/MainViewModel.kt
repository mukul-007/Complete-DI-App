package com.example.completediapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.completediapp.models.Quote
import com.example.completediapp.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: QuoteRepository) : ViewModel(){
    val quotesLiveData: LiveData<List<Quote>>
        get() = repository.quotes

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getRandomQuotes(10)
        }
    }
}