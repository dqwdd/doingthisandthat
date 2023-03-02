package com.example.testee33

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TestApplication: Application() {

    companion object {
        lateinit var Instance: TestApplication
    }

    init {
        Instance = this
    }

}