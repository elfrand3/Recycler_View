package com.example.viewpages

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.viewpages.model.ResultsItem

class MovAdapter (private var listMovie:  ArrayList<ResultsItem>):
    RecyclerView.Adapter<MovAdapter.myviewHolder>() {
    class myviewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val img : ImageView = itemView.findViewById(R.id.tv_im)
        val judul : TextView = itemView.findViewById(R.id.iv_j)
        val rel : TextView = itemView.findViewById(R.id.iv_r)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mov,parent,false)
        return myviewHolder(view)

    }

    override fun onBindViewHolder(holder: myviewHolder, position: Int) {
        val data = listMovie[position]
        holder.judul.text = data.title
        holder.rel.text = data.releaseDate
        Glide.with(holder.itemView)
            .load("https://www.themoviedb.org/t/p/w220_and_h330_face${data.posterPath}")
            .apply (RequestOptions.overrideOf(150,150))
            .into(holder.img)

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "${data.id}", Toast.LENGTH_SHORT).show()

            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("movie_id", data.id.toString())
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listMovie.size

    fun setData(data: List<ResultsItem>){
        listMovie.clear()
        listMovie.addAll(data)
        notifyDataSetChanged()
    }
}