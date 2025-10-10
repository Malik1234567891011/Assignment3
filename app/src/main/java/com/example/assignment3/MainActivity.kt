package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.CompositionLocalProvider
import com.example.assignment3.data.AppViewModel
import com.example.assignment3.data.LocalMenuRepo
import com.example.assignment3.ui.layout.MainLayout
import com.example.assignment3.ui.theme.Assignment3Theme

/**
 * Entry point Activity. In Compose, we set the entire UI with setContent {}.
 *
 * Responsibilities:
 * - Create the single app-wide ViewModel (AppViewModel) that owns our in-memory repository.
 * - Provide the repository to the composable tree via CompositionLocal (LocalMenuRepo).
 * - Create a NavController and hand it to the MainLayout (the app scaffold + nav host).
 * - Wrap the app in the Material 3 theme.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // App-wide Material 3 theme (colors/typography live in ui/theme/*).
            Assignment3Theme {
                // ViewModel scoped to this activity; survives rotation.
                // Holds our MenuRepository instance so the list isn't lost on config changes.
                val appVM: AppViewModel = viewModel()

                // Single NavController for the whole app, passed down to MainLayout.
                val nav = rememberNavController()

                // Provide the repository to all composables below.
                // Any screen can read LocalMenuRepo.current to access items/add/remove.
                CompositionLocalProvider(LocalMenuRepo provides appVM.repo) {
                    // MainLayout places the Scaffold (bottom bar, etc.) and hosts the NavHost.
                    MainLayout(nav)
                }
            }
        }
    }
}
