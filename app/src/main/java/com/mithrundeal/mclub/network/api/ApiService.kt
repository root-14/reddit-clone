package com.mithrundeal.mclub.network.api

import com.mithrundeal.mclub.network.models.response.Feed
import com.mithrundeal.mclub.network.models.response.Login
import com.mithrundeal.mclub.network.models.response.Register
import retrofit2.Response
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(): Response<Login>

    @POST("register")
    suspend fun register(): Response<Register>

    suspend fun loadFeed(): Response<Feed>
}