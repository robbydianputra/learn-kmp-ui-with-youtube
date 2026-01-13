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

    fun savePhotoUrl(photoUrl: String) {
        settings.putString("photo_url", photoUrl)
    }

    fun getPhotoUrl(): String? {
        return settings.getStringOrNull("photo_url")
    }

    fun clear() {
        settings.clear()
    }
}


