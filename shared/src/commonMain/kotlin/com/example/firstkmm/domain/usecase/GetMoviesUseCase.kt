package com.example.firstkmm.domain.usecase

import com.example.firstkmm.domain.repos.MovieRepository
import com.example.firstkmm.data.models.Movie

class GetMoviesUseCase (
    private  val repository: MovieRepository
        ) {


    suspend operator fun invoke(): List<Movie>{
        return repository.getMovies()
    }
}