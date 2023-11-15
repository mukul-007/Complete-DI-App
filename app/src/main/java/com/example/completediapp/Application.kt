package com.example.completediapp

import android.app.Application
import com.example.completediapp.di.ApplicationComponent
import com.example.completediapp.di.DaggerApplicationComponent
import dagger.internal.DaggerCollections

class Application : Application() {
    lateinit var applicationComponent: ApplicationComponent


    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}