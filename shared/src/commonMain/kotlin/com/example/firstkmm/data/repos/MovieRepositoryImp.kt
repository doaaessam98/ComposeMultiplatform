package com.example.firstkmm.data.repos

import com.example.firstkmm.data.models.Movie
import com.example.firstkmm.data.remote.RemoteDataSource
import com.example.firstkmm.domain.repos.MovieRepository
import com.example.firstkmm.data.models.MoviesResponse

class MovieRepositoryImp (
    private val  remoteDataSource: RemoteDataSource
        ) : MovieRepository {

    override suspend fun getMovies(): List<Movie> =remoteDataSource.getMovies().results
}