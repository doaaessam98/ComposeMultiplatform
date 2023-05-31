package com.example.firstkmm.android.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstkmm.Screen.home.HomeState
import com.example.firstkmm.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
    ):ViewModel() {

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
                 Log.e(TAG, "getMovies: "+error.localizedMessage )
                 Log.e(TAG, "getMovies: "+error.message )

                 Log.e(TAG, "getMovies: "+error.stackTrace )

                 _uiState.value = _uiState.value.copy(
                loading = false,
                errorMessage = "Could not load movies: ${error.localizedMessage}"
            )
        }
         }
     }




}