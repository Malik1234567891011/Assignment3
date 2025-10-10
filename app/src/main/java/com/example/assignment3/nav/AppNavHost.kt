package com.example.assignment3.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.assignment3.data.LocalMenuRepo
import com.example.assignment3.ui.screens.AboutScreen
import com.example.assignment3.ui.screens.DetailScreen
import com.example.assignment3.ui.screens.HistoryScreen
import com.example.assignment3.ui.screens.ScanScreen

/**
 * AppNavHost
 *
 * Central place that wires up all app destinations using Navigation-Compose.
 *
 * Why this exists:
 * - Keeps navigation logic in one file (clean separation from UI).
 * - Uses a single [NavHostController] shared by the Scaffold/BottomBar.
 * - Routes are defined via the sealed class `Route` to ensure type-safety.
 *
 * Data flow:
 * - A single in-memory repository (MenuRepository) is exposed via the CompositionLocal
 *   [LocalMenuRepo]. We read it here and pass data to screens as needed.
 *
 * Navigation pattern:
 * - Start at [Route.Scan].
 * - When the user submits a new item, we add it to the repo and navigate to
 *   [Route.Detail] using an **ID parameter** (no JSON payloads). The Detail
 *   screen then looks up the item from the repo by ID. This is simpler and avoids
 *   serialization while still meeting the assignment requirement of “pass as a parameter.”
 */
@Composable
fun AppNavHost(nav: NavHostController) {
    val repo = LocalMenuRepo.current

    NavHost(
        navController = nav,
        startDestination = Route.Scan.route
    ) {
        // 1) Scan/Add screen
        composable(Route.Scan.route) {
            ScanScreen { newItem ->
                // Persist the new item so History/Detail can see it
                repo.add(newItem)
                // Navigate to Detail using an ID in the route (e.g., "detail/123")
                nav.navigate(Route.Detail.withId(newItem.id))
            }
        }

        // 2) Detail screen for a single item
        composable(
            route = Route.Detail.route,                         // "detail/{id}"
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { entry ->
            // Read the "id" parameter from the route and fetch the item from the repo
            val id = entry.arguments?.getString("id") ?: return@composable
            val item = repo.find(id) ?: return@composable
            DetailScreen(item = item) { nav.popBackStack() }
        }

        // 3) History screen (list of all items)
        composable(Route.History.route) {
            HistoryScreen(
                onView = { id -> nav.navigate(Route.Detail.withId(id)) },
                onDelete = { id -> repo.remove(id) }
            )
        }

        // 4) About/Info screen
        composable(Route.About.route) {
            AboutScreen()
        }
    }
}
