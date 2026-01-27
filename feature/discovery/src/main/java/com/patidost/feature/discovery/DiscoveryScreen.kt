package com.patidost.feature.discovery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.patidost.core.domain.model.Pet

// MOCK DATA (Ücretsiz ve Çevrimdışı)
val mockPets = listOf(
    Pet("1", "Pamuk", "Tekir", "2 Yaş", "İstanbul", "", "Dişi"),
    Pet("2", "Baron", "Golden", "1 Yaş", "Ankara", "", "Erkek")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoveryScreen(
    onPetClick: (String) -> Unit = {},
    viewModel: DiscoveryViewModel = hiltViewModel() // ViewModel bağlandı
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("PatiDost") },
                actions = {
                    IconButton(onClick = {}) { Icon(Icons.Default.Search, null) }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            // İlan Listesi
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(mockPets) { pet ->
                    PetCard(pet, onPetClick)
                }
            }
        }
    }
}

@Composable
fun PetCard(pet: Pet, onClick: (String) -> Unit) {
    Card(
        onClick = { onClick(pet.id) },
        modifier = Modifier.fillMaxWidth().height(280.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.LightGray)
            ) {
                Text(
                    text = "Fotoğraf: ${pet.name}",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Column(modifier = Modifier.padding(12.dp)) {
                Text(pet.name, style = MaterialTheme.typography.titleLarge)
                Text(pet.breed, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
