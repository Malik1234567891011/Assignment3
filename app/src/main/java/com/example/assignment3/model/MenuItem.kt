package com.example.assignment3.model

import java.util.UUID

/**
 * Data model representing a single menu item saved by the user.
 *
 * Each [MenuItem] acts as one “memory” of a dish a user liked at a restaurant.
 * It stores essential details such as:
 * - Restaurant name
 * - Dish name
 * - Image URL (link to the dish’s picture)
 * - Optional notes and dietary tags
 *
 * @property id A unique UUID string automatically generated for each item.
 * @property restaurant The restaurant name where the dish was served.
 * @property itemName The name of the dish.
 * @property imageUrl A valid HTTPS image link showing the dish.
 * @property notes Optional user notes about the dish (taste, presentation, etc.).
 * @property tags List of dietary or preference tags (e.g., "spicy", "vegan").
 * @property liked Optional boolean flag for potential “favorites” feature.
 * @property createdAt Timestamp (in milliseconds) when the item was created.
 *
 * Notes:
 * - `UUID.randomUUID()` ensures every item has a unique identifier.
 * - `createdAt` can be used for sorting or future time-based filtering.
 */
data class MenuItem(
    val id: String = UUID.randomUUID().toString(),
    val restaurant: String,
    val itemName: String,
    val imageUrl: String,
    val notes: String = "",
    val tags: List<String> = emptyList(),
    val liked: Boolean? = null,
    val createdAt: Long = System.currentTimeMillis()
)
