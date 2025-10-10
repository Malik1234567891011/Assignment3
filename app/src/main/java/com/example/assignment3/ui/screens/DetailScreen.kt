package com.example.assignment3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.assignment3.model.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    item: MenuItem,
    onBack: () -> Unit
){
    Column(Modifier.fillMaxSize()){
        TopAppBar(
            title= { Text(item.itemName)},
            navigationIcon = { TextButton(onClick = onBack){Text("Back")} }


        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            AsyncImage(
                model = item.imageUrl,
                contentDescription = "Item image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
            Text(item.restaurant, style = MaterialTheme.typography.titleMedium)
            if(item.tags.isNotEmpty()){
                AssistChip(onClick = {}, label = {Text(item.tags.joinToString(" • "))})
            }
            if(item.notes.isNotBlank()){
                Text(item.notes, style = MaterialTheme.typography.bodyLarge)

            }

        }

    }
}