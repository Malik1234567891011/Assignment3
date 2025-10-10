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

@Composable
fun AppNavHost(nav: NavHostController){
    val repo = LocalMenuRepo.current

    NavHost(navController= nav, startDestination = Route.Scan.route){
        composable(Route.Scan.route){
            ScanScreen { newItem ->
                repo.add(newItem)
                nav.navigate(Route.Detail.withId(newItem.id))
            }

        }
        composable(
            route = Route.Detail.route,
            arguments = listOf(navArgument("id"){type = NavType.StringType})
        ){entry ->
            val id = entry.arguments?.getString("id") ?: return@composable
            val item = repo.find(id) ?: return@composable
            DetailScreen(item=item) { nav.popBackStack()}


        }
        composable(Route.History.route){
            HistoryScreen(
                onView = {id -> nav.navigate(Route.Detail.withId(id))},
                onDelete = { id -> repo.remove(id)}
            )
        }
        composable (Route.About.route){ AboutScreen() }
    }

}