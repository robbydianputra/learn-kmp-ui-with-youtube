package com.bagicode.belajarkmp

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.bagicode.belajarkmp.data.local.TokenStorage
import com.bagicode.belajarkmp.data.local.provideSettings
import com.bagicode.belajarkmp.ui.login.LoginScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val snackbarHostState = remember { SnackbarHostState() }
    var isLoggedIn by remember { mutableStateOf<Boolean?>(null) }
    val storage = remember { TokenStorage(provideSettings()) }

    LaunchedEffect(Unit) {
        val token = storage.getToken()
        isLoggedIn = token != null
    }

    MaterialTheme {
//        LoginScreen()
        Scaffold(
            snackbarHost = {
                SnackbarHost(snackbarHostState)
            }
        ) {
            when (isLoggedIn) {
                null -> CircularProgressIndicator()
                true -> {
                    LaunchedEffect(Unit) {
                        snackbarHostState.showSnackbar("Login berhasil")
                    }
                }
                false -> LoginScreen(
                    onLoginSuccess = {
                        isLoggedIn = true
                    },
                    tokenStorage = storage
                )
            }
        }

//        Button(onClick = {
//            SecureStorage().clear()
//            isLoggedIn = false
//        }) {
//            Text("Logout")
//        }
    }
}