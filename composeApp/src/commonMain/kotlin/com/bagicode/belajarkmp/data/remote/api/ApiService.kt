package com.bagicode.belajarkmp.data.remote.api

import com.bagicode.belajarkmp.data.remote.model.SignInRequest
import com.bagicode.belajarkmp.data.remote.model.SignInResponse
import com.bagicode.belajarkmp.data.remote.network.httpClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ApiService(
    private val client: HttpClient = httpClient()
) {
    val BASE_URL = "https://project.bagicode.com/pentest/api/endpoints/"

    suspend fun signinWithForm(request: SignInRequest): SignInResponse {
        return client.post(BASE_URL + "auth/login.php") {
            setBody(
                MultiPartFormDataContent(
                    formData {
                        append("username", request.username)
                        append("password", request.password)
                    }
                )
            )
        }.body()
    }


    suspend fun signinWithJson(request: SignInRequest): SignInResponse {
        return client.post(BASE_URL+"auth/login.php") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}
