package com.example.assignment3.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.assignment3.model.MenuItem
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ScanScreen(
    onSubmit: (MenuItem) -> Unit
){
    var restaurant by rememberSaveable { mutableStateOf("") }
    var itemName by rememberSaveable { mutableStateOf("") }
    var imageUrl by rememberSaveable { mutableStateOf("") }
    var notes by rememberSaveable { mutableStateOf("") }

    val allTags = listOf("spicy", "nuts", "shellfish", "vegan", "halal")

    var selected by rememberSaveable { mutableStateOf(setOf<String>()) }

    fun toggle(tag: String){
        selected= if( tag in selected) selected - tag else selected + tag
    }
    Column(
        Modifier
            .fillMaxSize()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Text("Add Food Entry", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value= restaurant, onValueChange = {restaurant = it},
            label = {Text("Restaurant")},
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedTextField(
            value = itemName, onValueChange = { itemName = it },
            label = { Text("Dish name") }, modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = imageUrl, onValueChange = {imageUrl = it},
            label = {Text("Image URL(https)")},
            modifier = Modifier.fillMaxWidth(), singleLine = true

        )
        OutlinedTextField(
            value = notes, onValueChange = { notes = it },
            label = { Text("Notes (optional)") }, modifier = Modifier.fillMaxWidth()
        )
        if(imageUrl.isNotBlank()){
            AsyncImage(
                model=imageUrl,
                contentDescription = "Preview",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
        }

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            allTags.forEach { tag ->
                FilterChip(
                    selected= tag in selected,
                    onClick = {toggle(tag)},
                    label = {Text(tag)}
                )

            }
        }

        Spacer(Modifier.height(8.dp))
        val formValid = restaurant.isNotBlank() && itemName.isNotBlank() && imageUrl.isNotBlank()
        Button(
            enabled=formValid,
            onClick = {
                onSubmit(
                    MenuItem(
                        restaurant= restaurant.trim(),
                        itemName = itemName.trim(),
                        imageUrl = imageUrl.trim(),
                        notes = notes.trim(),
                        tags = selected.toList()
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)


        ){Text("Add & View")}




    }

}