package com.example.firstkmm.Screen.home

import com.example.firstkmm.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel: KoinComponent {

     val getMoviesUseCase: GetMoviesUseCase by inject()

    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    private  val _uiState :MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
     val uiState = _uiState.asStateFlow()

    init {
        getMovies()
    }

    fun getMovies(){
        _uiState.value=_uiState.value.copy(loading = true)
         viewModelScope.launch {
             try {
                 getMoviesUseCase.invoke().let {
                 _uiState.value=_uiState.value.copy(loading = false, movies = it)
             }
             }catch (error: Throwable){
            _uiState.value = _uiState.value.copy(
                loading = false,
                errorMessage = "Could not load movies: ${error.message}"
            )
        }
         }
     }




}