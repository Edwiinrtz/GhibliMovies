package com.example.studioghiblifilms.viewmodel

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.studioghiblifilms.model.Film
import com.example.studioghiblifilms.model.FilmsProvider
import com.example.studioghiblifilms.model.MainActivityAdapter

class MainActivityViewModel: ViewModel(){
    private val films = FilmsProvider.filmList
    fun show(recyclerView: RecyclerView,onClickListener:(Film)->Unit){
        recyclerView.adapter = MainActivityAdapter(films, onClickListener)
    }

}