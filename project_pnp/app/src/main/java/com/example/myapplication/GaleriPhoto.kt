package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.GaleriAdapter
import com.example.myapplication.model.ModelGaleri

class GaleriPhoto : AppCompatActivity() {

    private var recycleView: RecyclerView? = null
    private var galeriAdapter: GaleriAdapter? = null
    private var movieList = mutableListOf<ModelGaleri>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_galeri_photo)

        movieList = ArrayList()
        recycleView = findViewById(R.id.rv_galeri)
        galeriAdapter = GaleriAdapter(this, movieList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recycleView!!.layoutManager = layoutManager
        recycleView!!.adapter = galeriAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        prepareMovieList()
    }
    private fun prepareMovieList()
    {
        var movie = ModelGaleri("logo",R.drawable.logo)
        movieList.add(movie)
        movie = ModelGaleri("design pnp",R.drawable.lapangan)
        movieList.add(movie)
        movie = ModelGaleri("gerbang pnp",R.drawable.nama)
        movieList.add(movie)
        movie = ModelGaleri("pkm",R.drawable.pkm)
        movieList.add(movie)
        movie = ModelGaleri("gedung rektorat",R.drawable.rektorat)
        movieList.add(movie)
        movie = ModelGaleri("diklat maba",R.drawable.diklat)
        movieList.add(movie)
        galeriAdapter!!.notifyDataSetChanged()
    }
}