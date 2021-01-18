package com.searchdetailiduas.api

import com.searchdetailiduas.Model.DetailUserRespond
import com.searchdetailiduas.Model.RespondUser
import com.searchdetailiduas.Model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    @GET("search/users")
    @Headers("Authorization: token ea382b9bf3b7e5c62a19b8d67d8a9dd95f82396d")
    fun getSearchUser(
        @Query("q") query: String
    ): Call<RespondUser>
    @GET("users/{user}")
    @Headers("Authorization: token ea382b9bf3b7e5c62a19b8d67d8a9dd95f82396d")
    fun getDetail(
        @Path("username") username: String
    ): Call<ArrayList<DetailUserRespond>>

    @GET("users/{user}/followers")
    @Headers("Authorization: token ea382b9bf3b7e5c62a19b8d67d8a9dd95f82396d")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{user}/following")
    @Headers("Authorization: token ea382b9bf3b7e5c62a19b8d67d8a9dd95f82396d")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}