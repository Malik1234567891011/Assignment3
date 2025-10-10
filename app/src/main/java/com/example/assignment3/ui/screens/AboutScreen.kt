package com.example.assignment3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment3.ui.theme.SplashBrush

/**
 * About screen — displays general information about MenuPlus.
 *
 * This screen explains the purpose of the app and gives short highlights of key features.
 * It is stateless (purely informational) and visually polished using Material 3 components.
 */
@Composable
fun AboutScreen() {
    Column(Modifier.fillMaxSize()) {
        // Top banner section with gradient background (from SplashBrush)
        Box(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(SplashBrush)
        )

        // Main content section
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // App title and description
            Text("MenuPlus", style = MaterialTheme.typography.headlineMedium)
            Text(
                "MenuPlus helps you remember the dishes you loved most, " +
                        "and where you found them. Save details, notes, and links " +
                        "so you never forget your favorites."
            )

            // Card container for secondary info
            ElevatedCard(Modifier.fillMaxWidth()) {
                Column(
                    Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Section: Explanation about image link design choice
                    Text("Why use image links?", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "Instead of uploading photos, MenuPlus lets you link images " +
                                "directly from restaurant websites or reviews. " +
                                "It keeps the app light and focused on memory, not file size."
                    )

                    // Divider between sections
                    HorizontalDivider(
                        Modifier.padding(vertical = 8.dp),
                        DividerDefaults.Thickness,
                        DividerDefaults.color
                    )

                    // Feature highlights
                    Text("Highlights", style = MaterialTheme.typography.titleMedium)
                    Text("• Save your favorite dishes with notes")
                    Text("• Tag meals (spicy, vegan, halal, etc.)")
                    Text("• Quickly browse your personal food history")
                }
            }
        }
    }
}
