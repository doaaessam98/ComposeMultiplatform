package com.example.firstkmm.data.remote

class RemoteDataSourceImp(
   private  val movieService: MovieService
):RemoteDataSource {


    override suspend fun getMovies() = movieService.getMovies(1)



}