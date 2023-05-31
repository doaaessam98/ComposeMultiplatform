package com.example.firstkmm.data.remote

import com.example.firstkmm.data.models.MoviesResponse
import kotlinx.coroutines.withContext

interface RemoteDataSource {

    suspend fun getMovies(): MoviesResponse
}