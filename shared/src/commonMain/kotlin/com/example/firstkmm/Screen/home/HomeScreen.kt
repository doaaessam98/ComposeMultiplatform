package com.example.firstkmm.Screen.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.firstkmm.data.models.Movie


@Composable
internal fun App(
    state: HomeState
) {
   // val state = HomeViewModel().uiState.collectAsState().value
    LazyColumn {
       items(state.movies){
           PopularMovieItem(movie = it)
           Text(text = it.title)
       }
   }
}



    @Composable
    fun PopularMovieItem(
        modifier : Modifier=Modifier,
        movie: Movie) {
        var isImageLoading by remember { mutableStateOf(false) }

        Row  {
            Text(text = movie.title,modifier.padding(8.dp))

//            AsyncImage(
//                model = movie.imageUrl,
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = modifier
//                    .fillMaxSize()
//                    .clip(RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp))
//            )
        }


    }

