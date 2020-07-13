package com.example.hiltpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltpractice.adapter.MovieAdapter
import com.example.hiltpractice.base.BaseApplication
import com.example.hiltpractice.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var rvMovie: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    @Inject lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMovie = findViewById(R.id.rv_movie)
        rvMovie.layoutManager = LinearLayoutManager(this)

        movieViewModel.getMovieContent()

        observeViewModel()
    }

    private fun observeViewModel() {
        movieViewModel.getResults().observe(this, Observer {
            if(it.isNotEmpty()) {
                movieAdapter = MovieAdapter(it)
                rvMovie.adapter = movieAdapter
            }
        })
    }
}