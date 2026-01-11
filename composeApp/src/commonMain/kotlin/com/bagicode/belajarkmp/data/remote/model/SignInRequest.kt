package com.bagicode.belajarkmp.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequest(
    val username: String,
    val password: String
)