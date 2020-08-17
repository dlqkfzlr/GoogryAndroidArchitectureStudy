package m.woong.sun_library.data.source.remote

import dagger.hilt.android.scopes.ActivityScoped
import m.woong.sun_library.data.source.remote.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@ActivityScoped
class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRemoteDataSource {

    override fun getMovie(
        query: String,
        success: (MovieResponse) -> Unit,
        failure: (Throwable) -> Unit
    ) {
        movieApi.movieSearch(query)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    response.body()?.let {
                        success(it)
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    failure(t)
                }
            })
    }
}