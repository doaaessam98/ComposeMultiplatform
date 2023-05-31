package com.example.firstkmm.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


private const val BASE_URL = "https://api.themoviedb.org/"
const val API_KEY = "f9fc533fed8b8ec1d6bf63de7566c3a9"

open class Api {
    val httpClient = HttpClient {
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
}}}


   fun HttpRequestBuilder.pathUrl(path:String) =
       url {
           takeFrom(BASE_URL)
           path("3",path)
           parameter("api_key", API_KEY)
       }
