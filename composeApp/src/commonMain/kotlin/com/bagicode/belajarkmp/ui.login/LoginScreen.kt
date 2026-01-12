package com.bagicode.belajarkmp.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bagicode.belajarkmp.data.local.TokenStorage
import com.bagicode.belajarkmp.data.remote.api.ApiService
import com.bagicode.belajarkmp.data.remote.model.SignInRequest
import com.bagicode.belajarkmp.data.remote.model.SignInResponse
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    onLoginSuccess: (Boolean) -> Unit,
    tokenStorage: TokenStorage
) {
    val scope = rememberCoroutineScope()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf<SignInResponse?>(null) }

    val api = remember { ApiService() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") }
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            enabled = !loading,
            onClick = {
                scope.launch {
                    loading = true
                    error = null
                    try {
                        result = api.signinWithForm(
                            SignInRequest(username, password)
                        )
                        println("TOKEN: ${result?.message}")

                        if (result?.status.equals("success")) {
                            result?.data?.token?.let { token ->
                                tokenStorage.saveToken(token)
                            }
                            onLoginSuccess(true)
                        }

                    } catch (e: Exception) {
                        error = e.message
                        println("tamvan: ${error}")
                    }
                    loading = false
                }
            }
        ) {
            Text("Login")
        }

        error?.let {
            Text(it, color = Color.Red)
        }

        result?.message?.let {
            Text(it, color = Color.Black)
        }
    }
}

