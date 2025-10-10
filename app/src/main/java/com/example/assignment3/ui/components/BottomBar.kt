package com.example.assignment3.ui.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.assignment3.nav.BottomRoutes

/**
 * BottomBar
 *
 * A persistent navigation bar displayed across all screens.
 *
 * Purpose:
 * - Provides quick access to the main app sections (Scan, History, About).
 * - Keeps the navigation consistent across the app using [NavigationBarItem].
 *
 * Behavior:
 * - Highlights the currently active route using the `selected` property.
 * - Clicking a route item navigates to its screen using [NavHostController].
 *   `launchSingleTop = true` prevents duplicate destinations in the back stack.
 *
 * UI details:
 * - Icons and labels come from the sealed [Route] definitions in `BottomRoutes`.
 * - Uses Material 3’s [NavigationBar] for adaptive styling.
 */
@Composable
fun BottomBar(nav: NavHostController) {
    // Observe navigation state to update selected tab dynamically
    val backStack by nav.currentBackStackEntryAsState()
    val current = backStack?.destination?.route

    NavigationBar {
        BottomRoutes.forEach { r ->
            NavigationBarItem(
                // Mark the item as selected if the current route starts with this one
                selected = current?.startsWith(r.route) == true,
                // Navigate to the corresponding route (singleTop avoids duplicates)
                onClick = { nav.navigate(r.route) { launchSingleTop = true } },
                // Icon and label for each tab
                icon = { r.icon?.let { Icon(it, contentDescription = r.label) } },
                label = { Text(r.label) }
            )
        }
    }
}
