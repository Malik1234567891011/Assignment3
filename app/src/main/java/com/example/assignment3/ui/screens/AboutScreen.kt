package com.example.assignment3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment3.ui.theme.SplashBrush

@Composable
fun AboutScreen() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(SplashBrush)
        )

        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text("MenuPlus", style = MaterialTheme.typography.headlineMedium)
            Text(
                "MenuPlus helps you remember the dishes you loved most, " +
                        "and where you found them. Save details, notes, and links " +
                        "so you never forget your favorites."
            )
            ElevatedCard(Modifier.fillMaxWidth()) {
                Column(
                    Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Why use image links?", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "Instead of uploading photos, MenuPlus lets you link images " +
                                "directly from restaurant websites or reviews. " +
                                "It keeps the app light and focused on memory, not file size."
                    )

                    HorizontalDivider(
                        Modifier.padding(vertical = 8.dp),
                        DividerDefaults.Thickness,
                        DividerDefaults.color
                    )

                    Text("Highlights", style = MaterialTheme.typography.titleMedium)
                    Text("• Save your favorite dishes with notes")
                    Text("• Tag meals (spicy, vegan, halal, etc.)")
                    Text("• Quickly browse your personal food history")
                }
            }
        }
    }
}
