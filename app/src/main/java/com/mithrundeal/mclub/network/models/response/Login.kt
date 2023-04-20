package com.mithrundeal.mclub.network.models.response

import com.google.gson.annotations.SerializedName


data class Login(
    @SerializedName("token") var token: String? = null
)