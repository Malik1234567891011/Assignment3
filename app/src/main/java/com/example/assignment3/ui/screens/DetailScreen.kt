package com.example.assignment3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.assignment3.model.MenuItem

/**
 * Detail screen — shows the full details for a selected menu item.
 *
 * Displays the dish image, restaurant name, dietary tags, and notes.
 * Accessed when the user taps on an entry from the History screen or after adding a new dish.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    item: MenuItem,       // The selected menu entry
    onBack: () -> Unit    // Callback for returning to the previous screen
) {
    Column(Modifier.fillMaxSize()) {

        // Top bar with title (dish name) and a simple back button
        TopAppBar(
            title = { Text(item.itemName) },
            navigationIcon = {
                TextButton(onClick = onBack) { Text("Back") }
            }
        )

        // Main content area showing the dish information
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Dish image preview
            AsyncImage(
                model = item.imageUrl,
                contentDescription = "Item image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )

            // Restaurant name
            Text(
                item.restaurant,
                style = MaterialTheme.typography.titleMedium
            )

            // Tags (if any) displayed in a compact chip
            if (item.tags.isNotEmpty()) {
                AssistChip(
                    onClick = {}, // Decorative only — no action
                    label = { Text(item.tags.joinToString(" • ")) }
                )
            }

            // Optional notes section, shown only when provided
            if (item.notes.isNotBlank()) {
                Text(
                    item.notes,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
