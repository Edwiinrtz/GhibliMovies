package com.example.studioghiblifilms.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studioghiblifilms.databinding.ActivityMainBinding
import com.example.studioghiblifilms.model.Film
import com.example.studioghiblifilms.viewmodel.MainActivityViewModel


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var model: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        model = MainActivityViewModel()
        initRecyclerView(model)
    }

    private fun initRecyclerView(model: MainActivityViewModel){
        val recyclerView = binding.rvFilms
        recyclerView.layoutManager = LinearLayoutManager(this)
        model.show(recyclerView) { film -> onFilmSelected(film) }
    }

    private fun onFilmSelected(film: Film){
        val intent = Intent(this,Web_view::class.java)
        intent.putExtra("film",film)
        startActivity(intent,null)
        /*var page: Uri = Uri.parse(film.link)
        val intent = Intent(Intent.ACTION_VIEW,page)
        startActivity(intent,null)*/
    }
}