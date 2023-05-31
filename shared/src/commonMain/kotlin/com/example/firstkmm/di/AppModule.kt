package com.example.firstkmm.di

import com.example.firstkmm.data.remote.MovieService
import com.example.firstkmm.data.remote.RemoteDataSource
import com.example.firstkmm.data.remote.RemoteDataSourceImp
import com.example.firstkmm.domain.repos.MovieRepository
import com.example.firstkmm.data.repos.MovieRepositoryImp
import org.koin.dsl.module



    val remoteDataSourceModule = module {
            factory<RemoteDataSource> { RemoteDataSourceImp(get()) }
            factory { MovieService() }
        }

    val repositoryModule = module {
        factory<MovieRepository> { MovieRepositoryImp(get()) }

    }

    private val sharedModules = listOf(remoteDataSourceModule,repositoryModule)

    fun getSharedModules() = sharedModules


