package com.example.viewpages.network

import com.example.viewpages.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("movie/popular?api_key=bc79104b108ca2dee02339203c934fd1&language=en-US&page=1")
    fun getMovie(): Call<MovieResponse>
}