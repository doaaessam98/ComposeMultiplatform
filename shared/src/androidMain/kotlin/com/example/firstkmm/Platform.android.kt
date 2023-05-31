package com.example.firstkmm

import androidx.compose.runtime.Composable
import com.example.firstkmm.Screen.home.App
import com.example.firstkmm.Screen.home.HomeState

@Composable
fun AndroidApplication(state:HomeState){
    App(state)
}