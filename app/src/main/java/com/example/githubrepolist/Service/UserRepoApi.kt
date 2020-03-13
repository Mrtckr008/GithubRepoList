package com.example.githubrepolist.Service

import com.example.githubrepolist.Model.UserRepo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserRepoApi {
    @GET("users/{user_id}/repos")
    fun getUsersRepo(@Path(value = "user_id", encoded = true) userId:String): Single<List<UserRepo>>
}