package com.example.hiltpractice.modules

import com.example.hiltpractice.network.Service
import com.example.hiltpractice.network.utility.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by hilma on 13/07/2020.
 */

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    fun providesBaseUrl(): String {
        return Constants.BASE_URL
    }

    @Provides
    fun providesHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun providesRxJavaCallAdapterFactory(): RxJava3CallAdapterFactory {
        return RxJava3CallAdapterFactory.create()
    }

    @Provides
    fun providesNetworkService(
        baseUrl: String,
        rxJava3CallAdapterFactory: RxJava3CallAdapterFactory,
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(rxJava3CallAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): Service {
        return retrofit.create(Service::class.java)
    }

}