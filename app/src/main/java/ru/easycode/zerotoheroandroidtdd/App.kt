package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import android.util.Log

class App : Application() {

    init {
        Log.d("LALALA", "App init")
    }
    lateinit var viewModel : MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base())
    }
}