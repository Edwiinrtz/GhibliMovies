package com.example.studioghiblifilms.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studioghiblifilms.R
import com.example.studioghiblifilms.view.MainActivityHolder

class MainActivityAdapter(private val dataset:List<Film>, private val onClickListener:(Film)->Unit): RecyclerView.Adapter<MainActivityHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film, parent, false)
        val webViewLayout = LayoutInflater.from(parent.context).inflate(R.layout.activity_web_view,parent,false)
        return MainActivityHolder(view, webViewLayout)
    }

    override fun onBindViewHolder(holder: MainActivityHolder, position: Int) {
        holder.render(dataset[position],onClickListener)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}