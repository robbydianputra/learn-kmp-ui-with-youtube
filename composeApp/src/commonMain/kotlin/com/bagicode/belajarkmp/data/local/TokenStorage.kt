package com.bagicode.belajarkmp.data.local

import com.russhwolf.settings.Settings

class TokenStorage(
    private val settings: Settings
) {
    fun saveToken(token: String) {
        settings.putString("token", token)
    }

    fun getToken(): String? {
        return settings.getStringOrNull("token")
    }

    fun clear() {
        settings.clear()
    }
}


