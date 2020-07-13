package com.example.hiltpractice.network

import com.example.hiltpractice.models.Movie
import com.example.hiltpractice.network.BaseResponse
import com.example.hiltpractice.network.utility.Constants
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by hilma on 17/06/2020.
 */
interface Service {

    @GET(Constants.MOVIE)
    fun getMovieContent(
        @Query("api_key") apiKey: String
    ): Observable<BaseResponse<Movie>>

}