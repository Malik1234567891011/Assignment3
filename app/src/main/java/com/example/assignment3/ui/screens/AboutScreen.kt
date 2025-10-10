package com.example.assignment3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment3.ui.theme.SplashBrush


@Composable
fun AboutScreen(){
    Column(Modifier.fillMaxSize()){
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
            Text("MenuMate", style = MaterialTheme.typography.headlineMedium)
            Text("Snap a menu (future), highlight diet preferences, and keep a food history. This build focuses on UI and state.")
            ElevatedCard(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Highlights", style = MaterialTheme.typography.titleMedium)
                    Text("• Quick tags (spicy/vegan/etc.)")
                    Text("• Big image detail")
                    Text("• History list with delete")


                }


            }
        }
        }
    }
