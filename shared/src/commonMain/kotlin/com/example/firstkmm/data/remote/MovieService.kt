package com.example.firstkmm.data.remote

import com.example.firstkmm.data.models.MoviesResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

 class MovieService: Api() {

    suspend fun getMovies(page: Int = 1): MoviesResponse = httpClient.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()


}