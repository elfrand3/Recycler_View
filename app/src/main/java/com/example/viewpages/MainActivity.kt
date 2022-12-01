package com.example.viewpages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpages.model.MovieResponse
import com.example.viewpages.model.ResultsItem
import com.example.viewpages.network.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    val runAdapter = MovAdapter(arrayListOf())
    val mainAdapter = MovieAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_movie.layoutManager = LinearLayoutManager(this)
        rv_movie.adapter = mainAdapter

        rv_mov.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rv_mov.adapter = runAdapter

        getMovie()
    }

    private fun getMovie() {
        ApiService.endpoint.getMovie().enqueue(object :Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if(response.isSuccessful){
                    val responseMovie:MovieResponse? = response.body()
                    onResultMovie(responseMovie!!)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }

        })
    }

    private fun onResultMovie(responseMovie: MovieResponse) {
        val hasil = responseMovie.results
        val h = responseMovie.results
        mainAdapter.setData(hasil as List<ResultsItem>)
        runAdapter.setData(h as List<ResultsItem>)
    }
}