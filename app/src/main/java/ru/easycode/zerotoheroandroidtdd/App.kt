package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(LiveDataWrapper.Mutable.Base(),
            Repository.Base(
                SimpleService.Base, URL
            ))
    }

    companion object {
        private const val URL = "https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json"
    }
}