package com.example.hiltpractice.network

import com.example.hiltpractice.models.Movie
import com.example.hiltpractice.network.utility.Constants
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * Created by hilma on 17/06/2020.
 */
class Repository @Inject constructor(private val service: Service) {

    fun getMovieContent(): Observable<BaseResponse<Movie>> = service.getMovieContent(Constants.API_KEY)

}