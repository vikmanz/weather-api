package com.vikmanz.data.api

import com.google.gson.GsonBuilder
import com.google.gson.Strictness
import com.vikmanz.data.utils.Properties
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val apiKeyInterceptor by lazy {
        Interceptor { chain ->
            val original = chain.request()
            val originalUrl = original.url

            val newUrl = originalUrl.newBuilder()
                .addQueryParameter("key", Properties.apiKey)
                .build()

            val newRequest = original.newBuilder()
                .url(newUrl)
                .build()

            chain.proceed(newRequest)
        }
    }

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .build()
    }

    private val gson by lazy {
        GsonBuilder()
            .setStrictness(Strictness.LENIENT)
            .create()
    }

    val client: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Properties.apiURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

}