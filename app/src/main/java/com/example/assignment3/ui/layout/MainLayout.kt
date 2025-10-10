package com.example.assignment3.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.assignment3.nav.AppNavHost
import com.example.assignment3.ui.components.BottomBar

/**
 * MainLayout
 *
 * The shared top-level layout used across all screens.
 * Provides consistent navigation and structure using [Scaffold].
 *
 * Responsibilities:
 * - Hosts the [BottomBar] navigation component shared across all screens.
 * - Defines a content area padded by [Scaffold]'s innerPadding, ensuring
 *   content isn’t overlapped by the navigation bar.
 * - Displays the navigation host ([AppNavHost]) which manages
 *   screen transitions.
 *
 * This composable keeps the app visually cohesive — every screen
 * inherits this layout, giving users a stable “frame” to navigate from.
 */
@Composable
fun MainLayout(nav: NavHostController) {
    Scaffold(
        // Bottom navigation bar that appears on all screens
        bottomBar = { BottomBar(nav) }
    ) { innerPadding ->
        // The main content area, padded to make room for the bottom bar
        Box(Modifier.padding(innerPadding)) {
            // Handles navigation between all defined app routes
            AppNavHost(nav)
        }
    }
}
