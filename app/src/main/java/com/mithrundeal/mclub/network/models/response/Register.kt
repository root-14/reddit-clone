package com.mithrundeal.mclub.network.models.response

import com.google.gson.annotations.SerializedName


data class Register(
    @SerializedName("success") var success: Boolean? = null
)