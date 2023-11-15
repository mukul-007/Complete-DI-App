package com.example.completediapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completediapp.repository.QuoteRepository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val repository: QuoteRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}