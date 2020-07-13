package com.example.hiltpractice.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hiltpractice.models.Movie
import com.example.hiltpractice.network.Repository
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by hilma on 09/07/2020.
 */
class MovieViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val load: MutableLiveData<Boolean> = MutableLiveData(false)
    private val results: MutableLiveData<List<Movie>> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()

    fun getMovieContent() {
        repository.getMovieContent()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .doOnError {it.printStackTrace()}
            .doOnTerminate {
                load.postValue(false)
            }
            .subscribe({
                results.postValue(it.results)
            }, {
                error.postValue(it.message)
            })
    }

    fun getLoad(): LiveData<Boolean> = load

    fun getResults(): LiveData<List<Movie>> = results

    fun getError(): LiveData<String> = error

}