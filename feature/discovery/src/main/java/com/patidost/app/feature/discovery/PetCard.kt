package com.patidost.app.feature.discovery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.patidost.app.domain.model.Pet

@Composable
fun PetCard(
    pet: Pet,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit // YENİ: Tıklama aksiyonu
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick() } // YENİ: Kartı tıklanabilir yapıyoruz
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pet.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.discovery_pet_photo_content_description, pet.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "${pet.name}, ${pet.age}",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = pet.breed,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = pet.location,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PetCardPreview() {
    val samplePet = Pet(
        id = "1",
        name = "Sımon",
        breed = "Golden Retriever",
        age = 2,
        imageUrl = "https://example.com/simon.jpg", // Placeholder URL
        location = "Istanbul, Turkey"
    )
    PetCard(pet = samplePet, onItemClick = {})
}
