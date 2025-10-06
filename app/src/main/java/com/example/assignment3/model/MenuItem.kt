package com.example.assignment3.model

import java.util.UUID
import kotlin.uuid.Uuid


data class MenuItem(

    val id : String = UUID.randomUUID().toString(),
    val restaurant : String,
    val itemName : String,
    val imageUrl : String,
    val notes: String = "",
    val tags: List<String> = emptyList(),
    val liked: Boolean? = null,
    val createdAt : Long =System.currentTimeMillis()

)