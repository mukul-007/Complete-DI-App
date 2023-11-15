package com.example.completediapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.completediapp.viewModels.MainViewModel
import com.example.completediapp.viewModels.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val textView: TextView
        get() = findViewById(R.id.textView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val applicationComponent = (application as Application).applicationComponent
        applicationComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.quotesLiveData.observe(this, Observer {
            textView.text = it.joinToString{s-> s.content + "\n\n"}
        })

    }
}