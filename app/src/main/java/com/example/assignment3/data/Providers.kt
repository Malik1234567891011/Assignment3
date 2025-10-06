package com.example.assignment3.data

import androidx.compose.runtime.staticCompositionLocalOf
import com.example.assignment3.model.MenuItem

val LocalMenuRepo = staticCompositionLocalOf<MenuRepository>{
    error("Menu Repo not provided")
}