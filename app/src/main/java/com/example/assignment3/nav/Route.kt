package com.example.assignment3.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List



sealed class    Route(val route: String, val label: String, val icon: ImageVector?){
    data object Scan    : Route("scan", "Scan", Icons.Outlined.CameraAlt)
    data object History : Route(route="history","History", Icons.AutoMirrored.Outlined.List)
    data object About : Route(route="about","About",Icons.Outlined.Info)

    data object Detail : Route("detail/{id}","Detail",null){
        fun withId(id: String)= "detail/$id"
    }

}
val BottomRoutes = listOf(Route.Scan,Route.History,Route.About)