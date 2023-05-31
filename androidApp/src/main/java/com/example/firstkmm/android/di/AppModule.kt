package com.example.firstkmm.android.di

import com.example.firstkmm.android.home.HomeViewModel
import com.example.firstkmm.domain.usecase.GetMoviesUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val appModule = module {
    single { GetMoviesUseCase(get() ) }
    viewModel { HomeViewModel(get()) }
}