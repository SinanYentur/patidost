package com.patidost.app.feature.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillNode
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalAutofill
import androidx.compose.ui.platform.LocalAutofillTree
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AuthScreen(
    onLoginSuccess: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    var isSignUpMode by remember { mutableStateOf(false) }

    LaunchedEffect(uiState.isLoginSuccessful) {
        if (uiState.isLoginSuccessful) {
            onLoginSuccess()
            viewModel.onNavigationDone()
        }
    }

    // TAMAMEN TEMİZLENMİŞ İSKELET
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AuthScreenContent(
            email = uiState.email,
            password = uiState.password,
            onEmailChange = viewModel::onEmailChanged, // ONARIM
            onPasswordChange = viewModel::onPasswordChanged, // ONARIM
            isSignUpMode = isSignUpMode,
            onAuthModeChange = { isSignUpMode = !isSignUpMode },
            onActionButtonClicked = {
                if (isSignUpMode) viewModel.onRegisterWithEmailClicked() // ONARIM
                else viewModel.onLoginWithEmailClicked() // ONARIM
            },
            isLoading = uiState.isLoading,
            error = uiState.error // ONARIM
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AuthScreenContent(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    isSignUpMode: Boolean,
    onAuthModeChange: () -> Unit,
    onActionButtonClicked: () -> Unit,
    isLoading: Boolean,
    error: String?
) {
    val emailFilter = remember { Regex("[a-zA-Z0-9@._-]*") }
    var passwordVisible by remember { mutableStateOf(false) }

    val autofill = LocalAutofill.current
    val autofillTree = LocalAutofillTree.current
    val emailNode = remember { AutofillNode(listOf(AutofillType.EmailAddress), onFill = onEmailChange) }
    val passNode = remember { AutofillNode(listOf(AutofillType.Password), onFill = onPasswordChange) } // ONARIM

    SideEffect {
        autofillTree += emailNode
        autofillTree += passNode
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (isSignUpMode) "Kayıt Ol" else "Hoş Geldiniz!",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { if (it.matches(emailFilter)) onEmailChange(it) },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    emailNode.boundingBox = coordinates.boundsInWindow()
                }
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        autofill?.requestAutofillForNode(emailNode)
                    }
                },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text("Şifre") },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    passNode.boundingBox = coordinates.boundsInWindow() // ONARIM
                }
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        autofill?.requestAutofillForNode(passNode) // ONARIM
                    }
                },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(), // ONARIM
            trailingIcon = {
                val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = icon, contentDescription = if (passwordVisible) "Şifreyi Gizle" else "Şifreyi Göster")
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { onActionButtonClicked() })
        )

        if (error != null) {
            Text(text = error, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(top = 8.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onActionButtonClicked,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            enabled = !isLoading
        ) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.size(24.dp))
            } else {
                Text(if (isSignUpMode) "KAYIT OL" else "GİRİŞ YAP")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = if (isSignUpMode) "Zaten bir hesabın var mı? Giriş Yap" else "Hesabın yok mu? Kayıt Ol",
            modifier = Modifier.clickable { onAuthModeChange() },
            color = MaterialTheme.colorScheme.primary
        )
    }
}
