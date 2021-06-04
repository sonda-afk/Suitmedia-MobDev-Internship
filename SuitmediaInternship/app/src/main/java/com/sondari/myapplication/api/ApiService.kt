package com.sondari.myapplication.api

import com.sondari.myapplication.data.ModelGuest
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v2/596dec7f0f000023032b8017")
    fun getGuest(): Call<ArrayList<ModelGuest>>
}