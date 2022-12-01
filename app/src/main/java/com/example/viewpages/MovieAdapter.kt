package com.example.viewpages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.viewpages.model.ResultsItem

class MovieAdapter (private var listMovie:  ArrayList<ResultsItem>):
    RecyclerView.Adapter<MovieAdapter.myviewHolder>() {
    class myviewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val judul : TextView = itemView.findViewById(R.id.tv_judul)
        val rel : TextView = itemView.findViewById(R.id.tv_rel)
        val lag : TextView = itemView.findViewById(R.id.tv_lag)
        val rat : TextView = itemView.findViewById(R.id.tv_rat)
//        val des : TextView = itemView.findViewById(R.id.tv_des)
        val img : ImageView = itemView.findViewById(R.id.tv_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return myviewHolder(view)

    }

    override fun onBindViewHolder(holder: myviewHolder, position: Int) {
        val data = listMovie[position]
        holder.judul.text = data.title
        holder.rel.text = data.releaseDate
        holder.lag.text = data.originalLanguage
        holder.rat.text = data.popularity.toString()
//        holder.des.text = data.overview
        Glide.with(holder.itemView)
            .load("https://www.themoviedb.org/t/p/w220_and_h330_face${data.posterPath}")
            .apply (RequestOptions.overrideOf(150,150)).into(holder.img)
    }

    override fun getItemCount() = listMovie.size

    fun setData(data: List<ResultsItem>){
        listMovie.clear()
        listMovie.addAll(data)
        notifyDataSetChanged()
    }
}