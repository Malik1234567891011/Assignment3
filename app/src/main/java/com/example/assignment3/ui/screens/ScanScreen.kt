package com.example.assignment3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.assignment3.model.MenuItem
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.text.input.KeyboardType

/**
 * ScanScreen
 *
 * Purpose:
 * - Collects a single "food entry" from the user (restaurant, dish name, image link, notes, tags).
 * - Validates required fields and emits a populated [MenuItem] through [onSubmit].
 *
 * Why state is here:
 * - This screen owns the form state (text fields + tag selection). We use rememberSaveable so data
 *   survives simple configuration changes (e.g., rotation).
 *
 * UX notes:
 * - The root Column is scrollable and uses imePadding() so the button doesn't get hidden by the keyboard.
 * - The form is grouped inside a Card with section headers for hierarchy.
 * - The "Add & View" button is enabled only when required fields are filled.
 *
 * Navigation contract:
 * - On success, we call [onSubmit] with a new [MenuItem]. The caller decides what to do next
 *   (e.g., save to repository, then navigate to a detail page).
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ScanScreen(
    onSubmit: (MenuItem) -> Unit
) {
    // --- Form state (saveable across recompositions & simple config changes) ---
    var restaurant by rememberSaveable { mutableStateOf("") }
    var itemName by rememberSaveable { mutableStateOf("") }
    var imageUrl by rememberSaveable { mutableStateOf("") }
    var notes by rememberSaveable { mutableStateOf("") }

    // Predefined dietary/attribute tags for quick selection.
    val allTags = listOf("spicy", "nuts", "shellfish", "vegan", "halal")

    // Selected tags are tracked as a Set for easy add/remove semantics.
    var selected by rememberSaveable { mutableStateOf(setOf<String>()) }

    // Small helper to toggle membership of a tag in the selected set.
    fun toggle(tag: String) {
        selected = if (tag in selected) selected - tag else selected + tag
    }

    // Root container:
    // - verticalScroll allows the whole form to scroll when content grows.
    // - imePadding keeps the bottom button visible above the on-screen keyboard.
    Column(
        Modifier
            .fillMaxSize()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Page title
        Text(
            "Add Food Entry",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        // Visual grouping for the form fields
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {

                // --- Section: Basic info ---
                Text("Basic Info", style = MaterialTheme.typography.titleSmall)

                // Restaurant name field.
                // Leading icon gives a quick visual cue about the field’s purpose.
                OutlinedTextField(
                    value = restaurant,
                    onValueChange = { restaurant = it },
                    label = { Text("Restaurant") },
                    leadingIcon = { Icon(Icons.Outlined.Restaurant, contentDescription = null) },
                    placeholder = { Text("e.g. Talib’s Pumpkin Factory") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Dish name field (required).
                OutlinedTextField(
                    value = itemName,
                    onValueChange = { itemName = it },
                    label = { Text("Dish name") },
                    modifier = Modifier.fillMaxWidth()
                )

                // --- Section: Image link & notes ---
                Text("Add Image", style = MaterialTheme.typography.titleSmall)

                // Image URL (required). We keep it singleLine so long URLs don't push content down.
                OutlinedTextField(
                    value = imageUrl,
                    onValueChange = { imageUrl = it },
                    label = { Text("Image URL(https)") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Optional notes; made multi-line for comfort.
                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text("Notes (optional)") },
                    placeholder = { Text("e.g. Best lasagna I’ve ever had!") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 3,
                    maxLines = 5
                )

                // Live image preview when URL is non-empty. If the link is invalid or blocked,
                // Coil will show nothing by default
                if (imageUrl.isNotBlank()) {
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = "Preview",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    )
                }

                // --- Section: Tags (secondary metadata) ---
                Text("Tags", style = MaterialTheme.typography.titleSmall)
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    allTags.forEach { tag ->
                        FilterChip(
                            selected = tag in selected,
                            onClick = { toggle(tag) },
                            label = { Text(tag) }
                        )
                    }
                }
            }
        }

        // Action button: only enabled when required fields are filled.
        Spacer(Modifier.height(8.dp))
        val formValid = restaurant.isNotBlank() && itemName.isNotBlank() && imageUrl.isNotBlank()

        Button(
            enabled = formValid,
            onClick = {
                // Emit a new MenuItem. The caller (NavHost/Main) will save and navigate.
                onSubmit(
                    MenuItem(
                        restaurant = restaurant.trim(),
                        itemName = itemName.trim(),
                        imageUrl = imageUrl.trim(),
                        notes = notes.trim(),
                        tags = selected.toList()
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp) // gives breathing room above the nav bar
        ) {
            Text("Add & View")
        }
    }
}
