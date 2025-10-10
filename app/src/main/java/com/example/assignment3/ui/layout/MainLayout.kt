package com.example.assignment3.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.assignment3.nav.AppNavHost
import com.example.assignment3.ui.components.BottomBar

@Composable
fun MainLayout(nav: NavHostController){
    Scaffold(
        bottomBar = { BottomBar(nav) }

    ){
        innerPadding ->
        Box(Modifier.padding(innerPadding)){
            AppNavHost(nav)
        }
    }
}