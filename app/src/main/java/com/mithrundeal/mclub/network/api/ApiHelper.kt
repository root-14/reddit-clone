package com.mithrundeal.mclub.network.api

import com.mithrundeal.mclub.network.models.response.Feed
import com.mithrundeal.mclub.network.models.response.Login
import com.mithrundeal.mclub.network.models.response.Register
import retrofit2.Response

interface ApiHelper {
    suspend fun login(): Response<Login>
    suspend fun register(): Response<Register>
    suspend fun loadFeed(): Response<Feed>
}