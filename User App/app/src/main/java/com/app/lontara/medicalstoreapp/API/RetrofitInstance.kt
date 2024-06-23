package com.app.lontara.medicalstoreapp.API

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.MINUTES).build()

    val api: API_Builder = Retrofit.Builder().client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(API_Builder::class.java)
}