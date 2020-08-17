package m.woong.sun_library.data.source.remote

import m.woong.sun_library.data.source.remote.model.MovieResponse

interface MovieRemoteDataSource {

    fun getMovie(
        query: String,
        success: (MovieResponse) -> Unit,
        failure: (Throwable) -> Unit
    )
}