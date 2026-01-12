package com.bagicode.belajarkmp

import android.app.Application
import com.bagicode.belajarkmp.data.local.initAppContext

class BelajarKmpApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initAppContext(this)
    }
}