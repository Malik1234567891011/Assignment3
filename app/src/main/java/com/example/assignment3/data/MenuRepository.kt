package com.example.assignment3.data

import android.view.Menu
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.assignment3.model.MenuItem

class MenuRepository{

    private val _items = mutableStateListOf<MenuItem>()
    val items: SnapshotStateList<MenuItem> = _items

    fun add(item: MenuItem)= _items.add(0,item)
    fun remove(id: String){_items.removeAll{it.id == id}}
    fun find(id: String): MenuItem? = _items.firstOrNull{it.id==id}
}