package com.example.viewpages

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterFilm (private var listFilm: ArrayList<ResultsItem>) :
        RecyclerView.Adapter<AdapterFilm.ViewHodler>(){
            class ViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView){
                var judul : TextView = itemView.findViewById(R.id.tv_judul)
                var des: TextView = itemView.findViewById(R.id.tv_des)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film,parent,false)
        return ViewHodler(view)
    }

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {
        val data = listFilm[position]
        holder.judul.text = data.overview
        holder.des.text = data.overview
    }

    override fun getItemCount() = listFilm.size

    fun setdata(data: List<ResultsItem>){
        listFilm.clear()
        listFilm.addAll(data)
        notifyDataSetChanged()

    }

}