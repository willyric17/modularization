package com.mokapos.modularization.network.service

import com.mokapos.modularization.network.response.UserSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/users")
    fun searchUser(@Query("q") query: String, @Query("page") page: Int): Call<UserSearchResponse>
}

