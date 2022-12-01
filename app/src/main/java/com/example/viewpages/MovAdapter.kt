package com.example.viewpages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.viewpages.model.ResultsItem

class MovAdapter (private var listMovie:  ArrayList<ResultsItem>):
    RecyclerView.Adapter<MovAdapter.myviewHolder>() {
    class myviewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val img : ImageView = itemView.findViewById(R.id.tv_im)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mov,parent,false)
        return myviewHolder(view)

    }

    override fun onBindViewHolder(holder: myviewHolder, position: Int) {
        val data = listMovie[position]
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