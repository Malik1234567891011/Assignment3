package com.example.assignment3.ui.components

import android.R.attr.contentDescription
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.assignment3.nav.BottomRoutes
import androidx.compose.material3.Icon
import androidx.compose.material3.Text



@Composable
fun BottomBar(nav: NavHostController){
    val backStack by nav.currentBackStackEntryAsState()
    val current= backStack?.destination?.route

    NavigationBar {
        BottomRoutes.forEach { r->
            NavigationBarItem(
                selected= current?.startsWith(r.route)==true,
                onClick = {nav.navigate(r.route){launchSingleTop =true} },
                icon = {
                    r.icon?.let{Icon(it, contentDescription = r.label)}}
                , label= {Text(r.label)}
            )

        }
    }

}