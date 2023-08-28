package com.example.phoneui

import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("/api/getData")
    fun getData(): Call<List<GetData>>

    @GET("/register?ap=3&apKey=MQZ9HUZL&user=ZOTAC")
    fun register(): Call<String>

}