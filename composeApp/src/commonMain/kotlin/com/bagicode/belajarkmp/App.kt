package com.bagicode.belajarkmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import belajarkmp.composeapp.generated.resources.Res
import belajarkmp.composeapp.generated.resources.compose_multiplatform
import com.bagicode.belajarkmp.ui.login.LoginScreen
import com.bagicode.belajarkmp.ui.login.LoginUiState

@Composable
@Preview
fun App() {
    MaterialTheme {
//        var state by remember { mutableStateOf(LoginUiState()) }
//        var showContent by remember { mutableStateOf(false) }
//        Column(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primaryContainer)
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Klik Saya")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                ) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//
//        LoginScreen(
//            state = state,
//            onEmailChange = { state = state.copy(email = it) },
//            onPasswordChange = { state = state.copy(password = it) },
//            onLoginClick = {
//                state = state.copy(loading = true)
//            }
//        )

        LoginScreen()
    }
}