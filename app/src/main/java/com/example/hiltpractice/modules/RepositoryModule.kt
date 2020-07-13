package com.example.hiltpractice.modules

import com.example.hiltpractice.network.Repository
import com.example.hiltpractice.network.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * Created by hilma on 14/07/2020.
 */
@InstallIn(ActivityComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun providesRepository(service: Service): Repository {
        return Repository(service)
    }

}