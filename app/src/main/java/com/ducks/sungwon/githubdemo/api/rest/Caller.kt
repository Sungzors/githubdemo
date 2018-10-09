package com.ducks.sungwon.githubdemo.api.rest

import com.ducks.sungwon.githubdemo.api.response.RepoResponse
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Header

interface Caller {

    @GET("/repositories")
    fun getRepo(@Header("Authorization") token: String, callback: Callback<ArrayList<RepoResponse>>)
}