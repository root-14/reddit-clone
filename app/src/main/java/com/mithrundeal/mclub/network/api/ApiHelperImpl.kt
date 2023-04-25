package com.mithrundeal.mclub.network.api

import com.mithrundeal.mclub.network.models.response.Feed
import com.mithrundeal.mclub.network.models.response.Login
import com.mithrundeal.mclub.network.models.response.Register
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun login(): Response<Login> = apiService.login()
    override suspend fun register(): Response<Register> = apiService.register()
    override suspend fun loadFeed(): Response<Feed> = apiService.loadFeed()
}