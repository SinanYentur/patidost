package com.patidost.app.feature.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.patidost.app.core.ui.theme.PatiDostTheme

@Composable
fun AuthScreen(
    viewModel: AuthViewModel = hiltViewModel(),
    onLoginSuccess: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.isLoginSuccessful) {
        if (uiState.isLoginSuccessful) {
            onLoginSuccess()
            viewModel.onNavigationDone()
        }
    }

    PatiDostTheme {
        AuthScreenContent(
            uiState = uiState,
            onEmailChanged = viewModel::onEmailChanged,
            onPasswordChanged = viewModel::onPasswordChanged,
            onLoginWithEmailClicked = viewModel::onLoginWithEmailClicked,
            onSignInWithGoogleClicked = { /* TODO */ },
            onSignInWithFacebookClicked = { /* TODO */ }
        )
    }
}

@Composable
fun AuthScreenContent(
    uiState: AuthState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginWithEmailClicked: () -> Unit,
    onSignInWithGoogleClicked: () -> Unit,
    onSignInWithFacebookClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Welcome!", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onPrimary)
            Text(
                text = "Hayvan dostlarınız için en eğlenceli uygulamaya giriş yapın!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(48.dp))

            Button(onClick = onSignInWithGoogleClicked, modifier = Modifier.fillMaxWidth()) {
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_search), contentDescription = "Google Sign-In")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Google ile Giriş Yap")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onSignInWithFacebookClicked, modifier = Modifier.fillMaxWidth()) {
                Icon(painter = painterResource(id = android.R.drawable.ic_menu_search), contentDescription = "Facebook Sign-In")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Facebook ile Giriş Yap")
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text("veya", color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f))
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = uiState.email,
                onValueChange = onEmailChanged,
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = uiState.password,
                onValueChange = onPasswordChanged,
                label = { Text("Parola") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = onLoginWithEmailClicked, modifier = Modifier.fillMaxWidth()) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.size(24.dp))
                } else {
                    Text("Giriş Yap")
                }
            }

            Row(modifier = Modifier.padding(top = 16.dp)) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text("Şifremi Unuttum", color = MaterialTheme.colorScheme.onPrimary)
                }
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = { /*TODO*/ }) {
                    Text("Üye Ol", color = MaterialTheme.colorScheme.onPrimary)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    PatiDostTheme {
        AuthScreenContent(
            uiState = AuthState(email = "test@example.com", password = "password"),
            onEmailChanged = {},
            onPasswordChanged = {},
            onLoginWithEmailClicked = {},
            onSignInWithGoogleClicked = {},
            onSignInWithFacebookClicked = {}
        )
    }
}
