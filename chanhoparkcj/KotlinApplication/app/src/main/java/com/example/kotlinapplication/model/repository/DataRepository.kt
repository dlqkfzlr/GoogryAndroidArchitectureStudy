package com.example.kotlinapplication.model.repository

import com.example.kotlinapplication.model.*
import io.reactivex.Single

interface DataRepository {
    fun callMovieResources(query: String): Single<ResponseItems<MovieItem>>
    fun callImageResources(query: String): Single<ResponseItems<ImageItem>>
    fun callBlogResources(query: String): Single<ResponseItems<BlogItem>>
    fun callKinResources(query: String): Single<ResponseItems<KinItem>>
}