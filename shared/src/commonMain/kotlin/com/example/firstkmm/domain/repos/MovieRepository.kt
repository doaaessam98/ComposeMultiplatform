package com.example.firstkmm.domain.repos

import com.example.firstkmm.data.models.Movie
import com.example.firstkmm.data.models.MoviesResponse

interface MovieRepository {

    suspend fun getMovies(): List<Movie>

}