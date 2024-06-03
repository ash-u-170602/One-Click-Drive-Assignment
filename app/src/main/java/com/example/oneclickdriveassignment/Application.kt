package com.example.oneclickdriveassignment

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate


class Application : Application() {

    companion object {
        @JvmStatic
        var instance: Application? = null
    }

    override fun onCreate() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) //Disable dark mode
        instance = this

        super.onCreate()
    }

}