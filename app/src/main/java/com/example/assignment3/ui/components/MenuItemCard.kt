package com.example.assignment3.ui.components

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.assignment3.model.MenuItem
import coil.compose.AsyncImage



@Composable
fun MenuItemCard(
    item: MenuItem,
    onClick: (()-> Unit)? = null,
    onDelete: (() -> Unit)? = null

){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null){onClick?.invoke()},
        shape= MaterialTheme.shapes.large
    ){
        Row(
            Modifier.padding(12.dp),
            horizontalArrangement =  Arrangement.spacedBy(12.dp)
        ){
            AsyncImage(
                model = item.imageUrl,
                contentDescription= "${item.itemName} image",
                modifier = Modifier.size(72.dp)
            )
            Column(Modifier.weight(1f)){
                Text(item.itemName,style = MaterialTheme.typography.titleMedium,maxLines=1)
                Text(
                    item.restaurant,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if(item.tags.isNotEmpty()){
                    Text(item.tags.joinToString(" • "), style= MaterialTheme.typography.labelMedium)
                }

            }
            if(onDelete!=null){
                TextButton(onClick = onDelete){Text("Delete")}
            }
        }


    }
}