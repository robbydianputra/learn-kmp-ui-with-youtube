package com.bagicode.belajarkmp.data.remote.model

import kotlinx.serialization.Serializable


@Serializable
data class SignInResponse(
    val `data`: Data?,
    val message: String?,
    val status: String?
) {
    @Serializable
    data class Data(
        val token: String?,
        val user: User?
    ) {
        @Serializable
        data class User(
            val id: Int?,
            val image: String?,
            val name: String?,
            val username: String?
        )
    }
}