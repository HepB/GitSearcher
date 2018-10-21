package com.github.hepb.gitsearcher.data.network

import com.github.hepb.gitsearcher.data.model.response.RepositoryResponseModel
import com.github.hepb.gitsearcher.data.model.response.SearchUsersResponseModel
import com.github.hepb.gitsearcher.data.model.response.UserResponseModel
import io.reactivex.Single
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("/search/users")
    fun searchUsers(@Query("q") name: String): Single<SearchUsersResponseModel>

    @GET("/users/{user}")
    fun getUser(@Path("user") name: String): Single<UserResponseModel>

    @GET("/users/{user}/repos")
    fun getRepos(@Path("user") name: String): Single<List<RepositoryResponseModel>>

    companion object Factory {
        fun create(): GithubService {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.github.com")
                    .build()

            return retrofit.create(GithubService::class.java)
        }
    }
}