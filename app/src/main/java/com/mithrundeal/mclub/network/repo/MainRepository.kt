package com.mithrundeal.mclub.network.repo

import com.mithrundeal.mclub.network.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun login() = apiHelper.login()
    suspend fun register() = apiHelper.register()
    suspend fun loadFeed()= apiHelper.loadFeed()
}