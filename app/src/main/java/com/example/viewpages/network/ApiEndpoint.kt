package com.example.viewpages.network

import com.example.viewpages.model.MovieResponse
import com.example.viewpages.model.ResultsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndpoint {

    @GET("movie/popular?api_key=bc79104b108ca2dee02339203c934fd1&language=en-US&page=1")
    fun getMovie(): Call<MovieResponse>

    @GET("movie/{movie_id}}?api_key=bc79104b108ca2dee02339203c934fd1&language=en-US")
    fun getDetail(
        @Path("movie_id") movie_id: String
    ): Call<ResultsItem>
}