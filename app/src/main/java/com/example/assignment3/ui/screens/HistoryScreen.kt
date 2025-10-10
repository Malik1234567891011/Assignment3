package com.example.assignment3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.assignment3.data.LocalMenuRepo
import com.example.assignment3.ui.components.MenuItemCard
import com.example.assignment3.ui.theme.SplashBrush

/**
 * Displays all previously saved dishes from the user's collection.
 * Users can tap to view a dish in detail or remove it from their history.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    onView: (itemID: String) -> Unit,
    onDelete: (itemId: String) -> Unit
) {
    val repo = LocalMenuRepo.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        // Header section with gradient background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(SplashBrush),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Your Food Journey 🍽️",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        // Subtitle to make it more inviting
        Text(
            "All your favorite dishes, in one place.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 12.dp),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // Display empty state if no dishes saved
        if (repo.items.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No dishes saved yet.\nStart by adding one from the Scan tab!",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            // Otherwise, show scrollable list of items
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(repo.items, key = { it.id }) { item ->
                    MenuItemCard(
                        item = item,
                        onClick = { onView(item.id) },
                        onDelete = { onDelete(item.id) }
                    )
                }
            }
        }
    }
}
