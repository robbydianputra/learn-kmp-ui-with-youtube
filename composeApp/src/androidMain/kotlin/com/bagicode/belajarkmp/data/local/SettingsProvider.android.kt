package com.bagicode.belajarkmp.data.local

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

lateinit var appContext: Context

fun initAppContext(context: Context) {
    appContext = context.applicationContext
}

actual fun provideSettings(): Settings {
    val prefs = appContext.getSharedPreferences("auth", Context.MODE_PRIVATE)
    return SharedPreferencesSettings(prefs)
}
