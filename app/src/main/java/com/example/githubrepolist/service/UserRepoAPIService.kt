package com.example.githubrepolist.service

import com.example.githubrepolist.model.UserRepo
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UserRepoAPIService {
    companion object{
        var dynamicUrl="mrtckr008"
    }
    var appApiBaseUrl="https://api.github.com/"
    private val api=Retrofit.Builder()
        .baseUrl(appApiBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(UserRepoApi::class.java)

    fun getData():Single<List<UserRepo>>{
        return api.getUsersRepo(dynamicUrl)
    }
}