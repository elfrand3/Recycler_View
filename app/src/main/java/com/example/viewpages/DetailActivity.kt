package com.example.viewpages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.viewpages.model.MovieResponse
import com.example.viewpages.model.ResultsItem
import com.example.viewpages.network.ApiService
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val f = intent
        val id = f.getStringExtra("movie_id")
        getDetailMovie(id)
    }

    private fun getDetailMovie(id: String?) {
        ApiService.endpoint.getDetail(id!!).enqueue(object : Callback<ResultsItem> {
            override fun onResponse(call: Call<ResultsItem>, response: Response<ResultsItem>) {
                if (response.isSuccessful){
                    val detail: ResultsItem? = response.body()
                    onResultDetail(detail)
                }else{
                    Toast.makeText(this@DetailActivity, "Gagal", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResultsItem>, t: Throwable) {
                Toast.makeText(this@DetailActivity, "$t", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun onResultDetail(detail: ResultsItem?) {
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/${detail!!.backdropPath}")
            .into(iv_detail_image)
        iv_detail_languange.text = detail.originalLanguage
        iv_detail_overview.text = detail.overview
        iv_j.text = detail.title
        iv_r.text = detail.releaseDate
    }
}