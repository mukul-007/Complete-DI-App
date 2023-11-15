package com.example.completediapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.completediapp.repository.QuoteRepository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val mainViewModel: MainViewModel) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return mainViewModel as T
    }
}