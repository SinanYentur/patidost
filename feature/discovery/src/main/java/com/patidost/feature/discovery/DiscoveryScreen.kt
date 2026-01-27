package com.patidost.feature.discovery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.patidost.feature.discovery.domain.Pet

// MOCK DATA (Ücretsiz ve Çevrimdışı)
val mockPets = listOf(
    Pet("1", "Pamuk", "Tekir", "2 Yaş", "İstanbul", "", "Dişi"),
    Pet("2", "Baron", "Golden", "1 Yaş", "Ankara", "", "Erkek"),
    Pet("3", "Mia", "Scottish Fold", "6 Ay", "İzmir", "", "Dişi"),
    Pet("4", "Duman", "British Shorthair", "1.5 Yaş", "Bursa", "", "Erkek"),
    Pet("5", "Limon", "Muhabbet Kuşu", "1 Yaş", "Antalya", "", "Erkek")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoveryScreen(
    onPetClick: (String) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Column {
                        Text("PatiDost", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
                        Text("Konum: Tüm Türkiye", style = MaterialTheme.typography.bodySmall)
                    }
                },
                actions = {
                    IconButton(onClick = {}) { Icon(Icons.Default.Search, null) }
                    IconButton(onClick = {}) { Icon(Icons.Default.FilterList, null) }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            // Kategori Filtreleri (Chip)
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listOf("Tümü", "Kediler", "Köpekler", "Kuşlar")) { category ->
                    FilterChip(
                        selected = category == "Tümü",
                        onClick = {},
                        label = { Text(category) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primary,
                            selectedLabelColor = Color.White
                        )
                    )
                }
            }

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
        modifier = Modifier.fillMaxWidth().height(280.dp), // Instagram tarzı büyük kart
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            // Fotoğraf Alanı (Placeholder Renk)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.LightGray) // Resim gelene kadar gri
            ) {
                Text(
                    text = "Fotoğraf: ${pet.name}",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.DarkGray
                )
            }
            
            // Bilgi Alanı
            Column(modifier = Modifier.padding(12.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(pet.name, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    
                    // Cinsiyet Badge
                    Surface(
                        color = if(pet.gender == "Dişi") Color(0xFFFFE0E0) else Color(0xFFE0F7FA),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = pet.gender,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelSmall,
                            color = if(pet.gender == "Dişi") Color.Red else Color.Blue
                        )
                    }
                }
                
                Text(pet.breed, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.LocationOn, null, modifier = Modifier.size(16.dp), tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(pet.location, style = MaterialTheme.typography.bodySmall)
                    
                    Spacer(modifier = Modifier.weight(1f))
                    
                    Text(pet.age, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}
