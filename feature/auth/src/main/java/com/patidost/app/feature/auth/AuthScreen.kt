package com.patidost.app.feature.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.patidost.app.core.ui.components.AuthTextField
import com.patidost.app.core.ui.components.DividerWithText
import com.patidost.app.core.ui.components.SocialLoginButton
import com.patidost.app.core.ui.components.SocialProvider
import com.patidost.app.core.ui.theme.Dimens
import com.patidost.app.core.ui.theme.PatiDostTheme

@Composable
fun AuthScreen(
    viewModel: AuthViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()
    val onEvent = viewModel::onEvent

    val scrollState = rememberScrollState()
    
    PatiDostTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = Dimens.SpacingLarge),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(Dimens.SpacingXXXL))
                
                Text(
                    text = if (state.authMode is AuthMode.LOGIN) "Welcome!" else "Hesap Oluştur",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground
                    ),
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(Dimens.SpacingMedium))
                Text(
                    text = if (state.authMode is AuthMode.LOGIN) 
                        "Hayvan dostlarınız için en\neğlenceli uygulamaya giriş yapın!" 
                    else 
                        "Hayvan dostlarınız için en\neğlenceli uygulamaya kaydolun!",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = Dimens.SpacingExtraLarge)
                )
                
                Spacer(modifier = Modifier.height(Dimens.SpacingXXL))
                SocialLoginButton(
                    provider = SocialProvider.GOOGLE,
                    onClick = { onEvent(AuthEvent.LoginWithGoogle) }
                )
                
                Spacer(modifier = Modifier.height(Dimens.SpacingSmall))
                SocialLoginButton(
                    provider = SocialProvider.FACEBOOK,
                    onClick = { onEvent(AuthEvent.LoginWithFacebook) }
                )
                
                Spacer(modifier = Modifier.height(Dimens.SpacingLarge))
                DividerWithText(text = "veya")
                Spacer(modifier = Modifier.height(Dimens.SpacingLarge))
                
                if (state.authMode is AuthMode.REGISTER) {
                    AuthTextField(
                        value = state.name,
                        onValueChange = { onEvent(AuthEvent.NameChanged(it)) },
                        label = "İsim",
                        placeholder = "Adınız ve soyadınız",
                        isError = state.validationErrors.containsKey("name"),
                        errorMessage = state.validationErrors["name"],
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(Dimens.SpacingMedium))
                }
                
                AuthTextField(
                    value = state.email,
                    onValueChange = { onEvent(AuthEvent.EmailChanged(it)) },
                    label = "E-posta",
                    placeholder = "ornek@email.com",
                    isError = state.validationErrors.containsKey("email"),
                    errorMessage = state.validationErrors["email"],
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(Dimens.SpacingMedium))
                AuthTextField(
                    value = state.password,
                    onValueChange = { onEvent(AuthEvent.PasswordChanged(it)) },
                    label = "Parola",
                    placeholder = "••••••",
                    isError = state.validationErrors.containsKey("password"),
                    errorMessage = state.validationErrors["password"],
                    visualTransformation = if (state.isPasswordVisible) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = { onEvent(AuthEvent.TogglePasswordVisibility) }
                        ) {
                            Icon(
                                imageVector = if (state.isPasswordVisible) {
                                    Icons.Default.VisibilityOff
                                } else {
                                    Icons.Default.Visibility
                                },
                                contentDescription = if (state.isPasswordVisible) {
                                    "Parolayı gizle"
                                } else {
                                    "Parolayı göster"
                                }
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = if (state.authMode is AuthMode.REGISTER) {
                            ImeAction.Next
                        } else {
                            ImeAction.Done
                        }
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                
                if (state.authMode is AuthMode.REGISTER) {
                    Spacer(modifier = Modifier.height(Dimens.SpacingMedium))
                    AuthTextField(
                        value = state.confirmPassword,
                        onValueChange = { onEvent(AuthEvent.ConfirmPasswordChanged(it)) },
                        label = "Parola Tekrar",
                        placeholder = "••••••",
                        isError = state.validationErrors.containsKey("confirmPassword"),
                        errorMessage = state.validationErrors["confirmPassword"],
                        visualTransformation = if (state.isConfirmPasswordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        trailingIcon = {
                            IconButton(
                                onClick = { onEvent(AuthEvent.ToggleConfirmPasswordVisibility) }
                            ) {
                                Icon(
                                    imageVector = if (state.isConfirmPasswordVisible) {
                                        Icons.Default.VisibilityOff
                                    } else {
                                        Icons.Default.Visibility
                                    },
                                    contentDescription = if (state.isConfirmPasswordVisible) {
                                        "Parolayı gizle"
                                    } else {
                                        "Parolayı göster"
                                    }
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = Dimens.SpacingMedium),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (state.authMode is AuthMode.LOGIN) {
                        TextButton(
                            onClick = { onEvent(AuthEvent.ForgotPassword) },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Şifremi Unuttum",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    color = MaterialTheme.colorScheme.primary
                                )
                            )
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    
                    Button(
                        onClick = {
                            if (state.authMode is AuthMode.LOGIN) {
                                onEvent(AuthEvent.LoginWithEmail)
                            } else {
                                onEvent(AuthEvent.RegisterWithEmail)
                            }
                        },
                        modifier = Modifier
                            .weight(2f)
                            .height(Dimens.ButtonHeight),
                        enabled = !state.isLoading,
                        shape = MaterialTheme.shapes.medium
                    ) {
                        if (state.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                strokeWidth = 2.dp,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        } else {
                            Text(
                                text = if (state.authMode is AuthMode.LOGIN) "Giriş Yap" else "Kayıt Ol",
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
                
                state.error?.let { error ->
                    Spacer(modifier = Modifier.height(Dimens.SpacingSmall))
                    Text(
                        text = error,
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = MaterialTheme.colorScheme.error
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                
                Spacer(modifier = Modifier.height(Dimens.SpacingXXL))
                TextButton(
                    onClick = { onEvent(AuthEvent.ToggleAuthMode) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val annotatedString = buildAnnotatedString {
                        if (state.authMode is AuthMode.LOGIN) {
                            append("Hesabınız yok mu? ")
                            withStyle(SpanStyle(color = MaterialTheme.colorScheme.secondary)) {
                                append("Kayıt Ol")
                            }
                        } else {
                            append("Zaten hesabınız var mı? ")
                            withStyle(SpanStyle(color = MaterialTheme.colorScheme.secondary)) {
                                append("Giriş Yap")
                            }
                        }
                    }
                    
                    Text(
                        text = annotatedString,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
                
                Spacer(modifier = Modifier.height(Dimens.SpacingXXXL))
            }
            
            if (state.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(Dimens.SpacingXXL),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(48.dp),
                        strokeWidth = 3.dp
                    )
                }
            }
        }
    }
}

@Preview(name = "Login Mode", showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun LoginScreenPreview() {
    val viewModel = remember { AuthViewModel() }
    AuthScreen(viewModel = viewModel)
}

@Preview(name = "Register Mode", showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun RegisterScreenPreview() {
    val viewModel = remember { AuthViewModel() }
    // Set initial state to REGISTER mode for this preview
    LaunchedEffect(Unit) {
        viewModel.onEvent(AuthEvent.ToggleAuthMode)
    }
    AuthScreen(viewModel = viewModel)
}

@Preview(name = "Login Mode - Dark", showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun LoginScreenDarkPreview() {
    PatiDostTheme(darkTheme = true) {
        val viewModel = remember { AuthViewModel() }
        AuthScreen(viewModel = viewModel)
    }
}
