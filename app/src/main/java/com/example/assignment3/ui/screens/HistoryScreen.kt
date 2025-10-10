package com.example.assignment3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment3.data.LocalMenuRepo
import com.example.assignment3.ui.components.MenuItemCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    onView: (itemID: String) -> Unit,
    onDelete: (itemId: String) -> Unit
){
    val repo = LocalMenuRepo.current
    Column(Modifier.fillMaxSize()){
        TopAppBar(title= { Text("Your History") })
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier= Modifier.fillMaxSize()
        ){
            items(repo.items, key={ it.id}){item ->
                MenuItemCard(
                    item = item,
                    onClick = {onView(item.id)},
                    onDelete={onDelete(item.id)}
                )
            }
        }


    }
}