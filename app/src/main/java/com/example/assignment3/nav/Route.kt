package com.example.assignment3.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Route
 *
 * A sealed class that defines all the navigable routes in the app.
 *
 * Each route represents a screen in the app with:
 *  - a unique `route` string used by the Navigation component
 *  - a `label` used for bottom navigation labels
 *  - an optional `icon` used in the bottom bar
 *
 * The [Detail] route uses a dynamic `{id}` parameter to display
 * a specific menu item’s details.
 */
sealed class Route(
    val route: String,
    val label: String,
    val icon: ImageVector?
) {
    // Main app routes used in BottomBar
    data object Scan : Route("scan", "Scan", Icons.Outlined.CameraAlt)
    data object History : Route("history", "History", Icons.AutoMirrored.Outlined.List)
    data object About : Route("about", "About", Icons.Outlined.Info)

    // Dynamic route for showing one menu item by ID
    data object Detail : Route("detail/{id}", "Detail", null) {
        fun withId(id: String) = "detail/$id"
    }
}

/**
 * BottomRoutes
 *
 * A list of routes that should appear in the Bottom Navigation Bar.
 * The Detail screen is excluded because it is accessed contextually,
 * not directly from navigation.
 */
val BottomRoutes = listOf(Route.Scan, Route.History, Route.About)
