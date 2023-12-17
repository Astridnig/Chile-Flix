package com.astridnig.moviesapp.data.mapper

import com.astridnig.moviesapp.data.remote.model.BelongsToCollectionApiModel
import com.astridnig.moviesapp.data.remote.model.GenreApiModel
import com.astridnig.moviesapp.data.remote.model.MovieApiModel
import com.astridnig.moviesapp.data.remote.model.MovieDetailsApi
import com.astridnig.moviesapp.data.remote.model.MoviesApiModel
import com.astridnig.moviesapp.data.remote.model.ProductionCompaniesApiModel
import com.astridnig.moviesapp.data.remote.model.ProductionCountriesApiModel
import com.astridnig.moviesapp.data.remote.model.SpokenLanguagesApiModel
import com.astridnig.moviesapp.presentation.moviedetail.model.BelongsToCollection
import com.astridnig.moviesapp.presentation.moviedetail.model.Genre
import com.astridnig.moviesapp.presentation.moviedetail.model.MovieDetails
import com.astridnig.moviesapp.presentation.moviedetail.model.ProductionCompanies
import com.astridnig.moviesapp.presentation.moviedetail.model.ProductionCountries
import com.astridnig.moviesapp.presentation.moviedetail.model.SpokenLanguages
import com.astridnig.moviesapp.presentation.movies.model.Movie
import com.astridnig.moviesapp.presentation.movies.model.Movies

class MoviesMapper {

    fun MoviesApiModel.toMovies() = Movies(
        page = page ?: 0,
        results = results?.mapNotNull { it?.toMovie() }.orEmpty(),
        totalPages = totalPages ?: 0,
        totalResults = totalResults ?: 0
    )

    private fun MovieApiModel.toMovie() = Movie(
        adult = adult ?: false,
        backdropPath = backdropPath.orEmpty(),
        genreIds = genreIds?.mapNotNull { it }.orEmpty(),
        id = id ?: 0,
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        posterPath = posterPath.orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        title = title.orEmpty(),
        video = video ?: false,
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0,
    )

    fun MovieDetailsApi.toMovieDetails() = MovieDetails(
        adult = adult ?: false,
        backdropPath = backdropPath.orEmpty(),
        belongsToCollection = belongsToCollection.toBelongsToCollection(),
        budget = budget ?: 0,
        genres = genres?.mapNotNull { it?.toGenre() }.orEmpty(),
        homepage = homepage.orEmpty(),
        id = id ?: 0,
        imdbId = imdbId.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        originalTitle = originalTitle.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        posterPath = posterPath.orEmpty(),
        productionCompanies = productionCompanies?.mapNotNull { it?.toProductionCompanies() }
            .orEmpty(),
        productionCountries = productionCountries?.mapNotNull { it?.toProductionCountries() }
            .orEmpty(),
        releaseDate = releaseDate.orEmpty(),
        revenue = revenue ?: 0,
        runtime = runtime ?: 0,
        spokenLanguages = spokenLanguages?.mapNotNull { it?.toSpokenLanguages() }.orEmpty(),
        status = status.orEmpty(),
        tagline = tagline.orEmpty(),
        title = title.orEmpty(),
        video = video ?: false,
        voteAverage = voteAverage ?: 0.0,
        voteCount = voteCount ?: 0,
    )

    private fun BelongsToCollectionApiModel?.toBelongsToCollection() = BelongsToCollection(
        id = this?.id ?: 0,
        name = this?.name.orEmpty(),
        posterPath = this?.posterPath.orEmpty(),
        backdropPath = this?.backdropPath.orEmpty(),
    )

    private fun GenreApiModel?.toGenre() = Genre(
        id = this?.id ?: 0,
        name = this?.name.orEmpty()
    )

    private fun ProductionCompaniesApiModel.toProductionCompanies() = ProductionCompanies(
        id = id ?: 0,
        logoPath = logoPath.orEmpty(),
        name = name.orEmpty(),
        originCountry = originCountry.orEmpty(),
    )

    private fun ProductionCountriesApiModel.toProductionCountries() = ProductionCountries(
        iso = iso.orEmpty(),
        originCountry = originCountry.orEmpty()
    )

    private fun SpokenLanguagesApiModel.toSpokenLanguages() = SpokenLanguages(
        englishName = englishName.orEmpty(),
        iso = iso.orEmpty(),
        name = name.orEmpty(),
    )
}