package m.woong.sun_library.data.repos

import dagger.hilt.android.scopes.ActivityScoped
import m.woong.sun_library.data.source.remote.MovieRemoteDataSource
import m.woong.sun_library.data.source.remote.model.MovieResponse
import java.time.LocalDate
import javax.inject.Inject

@ActivityScoped
class MovieRepositoryImpl @Inject constructor(
    //private val localDataSource: MovieLocalDataSource,
    private val remoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override fun getRecentMovie(
        query: String,
        success: (MovieResponse) -> Unit,
        failure: (Throwable) -> Unit
    ) {
        getMovie(query, success, failure)
        /*   if (isRecentMovie()){
               getCachedMovie()
           } else {
               getMovie(query)
           }
         */
    }

    override fun getMovie(
        query: String,
        success: (MovieResponse) -> Unit,
        failure: (Throwable) -> Unit
    ) {
        remoteDataSource.getMovie(query, success, failure)
        //val movieList: List<MovieResponse.Item> = remoteDataSource.getMovie(query, success, failure)
        //localDataSource.saveMovie(movieList)
    }

    override fun getCachedMovie() {
        //localDataSource.getMovie()
    }

    override fun isRecentMovie(): Boolean {
        TODO("Not yet implemented")
    }
}