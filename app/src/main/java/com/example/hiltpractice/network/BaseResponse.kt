package com.example.hiltpractice.network

/**
 * Created by hilma on 17/06/2020.
 */
data class BaseResponse<T>(
    var page: Int? = null,
    var total_results: Int? = null,
    var results: List<T>? = listOf()
)