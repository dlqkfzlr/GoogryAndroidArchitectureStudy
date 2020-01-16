package app.ch.study.data.remote.source

import app.ch.study.data.remote.api.WebApi
import app.ch.study.data.remote.response.MovieResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NaverQueryRemoteDataSourceImpl(private val webApi: WebApi) : NaverQueryRemoteDataSource {

    override fun searchMovie(query: String): Single<MovieResponse> = webApi.searchMovie(query)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}