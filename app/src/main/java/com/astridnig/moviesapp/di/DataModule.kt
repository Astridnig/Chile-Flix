package com.astridnig.moviesapp.di


import com.astridnig.moviesapp.data.MoviesRepositoryImpl
import com.astridnig.moviesapp.data.mapper.MoviesMapper
import com.astridnig.moviesapp.data.remote.MoviesDataSourceImpl
import com.astridnig.moviesapp.data.remote.api.MoviesApi
import com.astridnig.moviesapp.data.remote.api.config.AuthInterceptor
import com.astridnig.moviesapp.data.remote.api.config.UrlProvider.getMoviesUrl
import com.astridnig.moviesapp.data.source.MoviesDataSource
import com.astridnig.moviesapp.presentation.repository.MoviesRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object DataModule {
    private val provideMoviesApi: MoviesApi by lazy {
        val urlBase = getMoviesUrl()
        Retrofit.Builder()
            .baseUrl(urlBase)
            .client(okHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    private fun okHttpClient(): OkHttpClient {
        val authToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMGZkYzQ0NzY5MWJlNzQ0ZGZkMGNkZDEyZDdlZDk3YyIsInN1YiI6IjY1N2EzODg3NjcyOGE4MDBlNDcwOGJiMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.wyKDJFFmR4H38ID8bxuLm5TrgztSB8KWcYiPvFb90SE"
        val authInterceptor = AuthInterceptor(authToken)
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
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