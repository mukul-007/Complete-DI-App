package com.example.completediapp.di

import com.example.completediapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}