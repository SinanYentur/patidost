package com.patidost.app.feature.onboarding.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.patidost.app.core.ui.R
import com.patidost.app.core.ui.theme.Dimens
import com.patidost.app.core.ui.theme.PatiDostTheme
import com.patidost.app.feature.onboarding.models.OnboardingEvent
import com.patidost.app.feature.onboarding.models.OnboardingState
import com.patidost.app.feature.onboarding.ui.components.PetStatusCard
import com.patidost.app.feature.onboarding.viewmodel.OnboardingViewModel

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = viewModel(),
    onNavigateToHome: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.navigationEvent) {
        if (state.navigationEvent is OnboardingState.NavigationEvent.NavigateToHome) {
            onNavigateToHome()
            viewModel.onEvent(OnboardingEvent.NavigationHandled)
        }
    }

    PatiDostTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            OnboardingContent(
                state = state,
                onEvent = viewModel::onEvent
            )
        }
    }
}

@Composable
private fun OnboardingContent(
    state: OnboardingState,
    onEvent: (OnboardingEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.SpacingLarge),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Bize biraz kendinizden bahseder misiniz?",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(Dimens.SpacingMedium))
        Text(
            text = "Evcil hayvanınız var mı?",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )
        Spacer(modifier = Modifier.height(Dimens.SpacingExtraLarge))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            PetStatusCard(
                isSelected = state.petStatus == true,
                title = "Var",
                iconResId = R.drawable.ic_pet_varlik, // Bu asset'in varolduğu varsayılıyor
                onClick = { onEvent(OnboardingEvent.PetStatusSelected(true)) }
            )
            Spacer(modifier = Modifier.width(Dimens.SpacingMedium))
            PetStatusCard(
                isSelected = state.petStatus == false,
                title = "Yok",
                iconResId = R.drawable.ic_pet_yokluk, // Bu asset'in varolduğu varsayılıyor
                onClick = { onEvent(OnboardingEvent.PetStatusSelected(false)) }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { onEvent(OnboardingEvent.ContinueClicked) },
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimens.ButtonHeight),
            enabled = state.isContinueEnabled
        ) {
            Text(text = "Devam Et")
        }
        Spacer(modifier = Modifier.height(Dimens.SpacingSmall))

        TextButton(onClick = { onEvent(OnboardingEvent.SkipForLaterClicked) }) {
            Text(
                text = "Daha Sonra Yap",
                color = MaterialTheme.colorScheme.secondary
            )
        }
        Spacer(modifier = Modifier.height(Dimens.SpacingXXL))
    }
}
