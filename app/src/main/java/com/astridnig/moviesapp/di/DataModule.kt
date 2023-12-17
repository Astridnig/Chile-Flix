package com.astridnig.moviesapp.di


import com.astridnig.moviesapp.data.MoviesRepositoryImpl
import com.astridnig.moviesapp.data.mapper.MoviesMapper
import com.astridnig.moviesapp.data.remote.MoviesDataSourceImpl
import com.astridnig.moviesapp.data.remote.api.MoviesApi
import com.astridnig.moviesapp.data.remote.api.config.UrlProvider.getMoviesUrl
import com.astridnig.moviesapp.data.source.MoviesDataSource
import com.astridnig.moviesapp.presentation.repository.MoviesRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object DataModule {
    private val provideMoviesApi: MoviesApi by lazy {
        val urlBase = getMoviesUrl()
        Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    private val provideDataSourceImpl: MoviesDataSource by lazy {
        MoviesDataSourceImpl(provideMoviesApi)
    }
    private val provideMoviesMapper:MoviesMapper by lazy {
        MoviesMapper()
    }
    val provideRepositoryImpl:MoviesRepository by lazy {
        MoviesRepositoryImpl(provideDataSourceImpl, provideMoviesMapper)
    }

}