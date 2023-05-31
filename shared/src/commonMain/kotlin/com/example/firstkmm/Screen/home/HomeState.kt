package com.example.firstkmm.Screen.home

import com.example.firstkmm.data.models.Movie


data class HomeState(
    var loading: Boolean = false,
    var movies: List<Movie> = listOf(),
    var errorMessage: String? = null,
)