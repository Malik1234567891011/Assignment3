package com.example.assignment3.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.assignment3.model.MenuItem

/**
 * MenuItemCard
 *
 * Displays a single dish entry (restaurant, dish name, tags, and optional image)
 * in a clean card layout for use inside lists like the History screen.
 *
 * Responsibilities:
 * - Shows the image thumbnail for a [MenuItem].
 * - Displays key information: dish name, restaurant, and any dietary tags.
 * - Supports click and delete actions, allowing parent screens to handle navigation
 *   or item removal.
 *
 * Interaction logic:
 * - Clicking anywhere on the card triggers [onClick] if provided.
 * - The "Delete" text button triggers [onDelete] if provided.
 *
 * UI details:
 * - Uses a row layout with image, text info, and optional delete button.
 * - Automatically truncates long restaurant names for clean presentation.
 */
@Composable
fun MenuItemCard(
    item: MenuItem,
    onClick: (() -> Unit)? = null,
    onDelete: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            // Only clickable if a click action is defined
            .clickable(enabled = onClick != null) { onClick?.invoke() },
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Thumbnail image for the dish
            AsyncImage(
                model = item.imageUrl,
                contentDescription = "${item.itemName} image",
                modifier = Modifier.size(72.dp)
            )

            // Text column: dish name, restaurant, and tags
            Column(Modifier.weight(1f)) {
                Text(
                    item.itemName,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1
                )
                Text(
                    item.restaurant,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (item.tags.isNotEmpty()) {
                    Text(
                        item.tags.joinToString(" • "),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

            // Optional delete button if provided by parent composable
            if (onDelete != null) {
                TextButton(onClick = onDelete) {
                    Text("Delete")
                }
            }
        }
    }
}
