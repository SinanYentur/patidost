package com.patidost.app.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.patidost.app.core.ui.theme.Dimens

enum class SocialProvider {
    GOOGLE,
    FACEBOOK
}

@Composable
fun SocialLoginButton(
    provider: SocialProvider,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val (text, backgroundColor, textColor, iconRes) = when (provider) {
        SocialProvider.GOOGLE -> Triple(
            "Google ile Giriş Yap",
            Color.White,
            Color(0xFF757575),
            null // R.drawable.ic_google_logo // Google logo vektörü
        )
        SocialProvider.FACEBOOK -> Triple(
            "Facebook ile Giriş Yap",
            Color(0xFF1877F2),
            Color.White,
            null // R.drawable.ic_facebook_logo // Facebook logo vektörü
        )
    }
    
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(Dimens.ButtonHeight),
        shape = RoundedCornerShape(Dimens.CornerRadiusMedium),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = Dimens.ElevationSmall,
            pressedElevation = Dimens.ElevationSmall
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            iconRes?.let {
//                Icon(
//                    imageVector = ImageVector.vectorResource(it),
//                    contentDescription = null,
//                    modifier = Modifier.size(Dimens.IconSizeMedium),
//                    tint = Color.Unspecified
//                )
//                Spacer(modifier = Modifier.width(Dimens.SpacingSmall))
//            }
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge.copy(
                    color = textColor
                )
            )
        }
    }
}
