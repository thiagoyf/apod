package com.thiagoyf.core_network.api

import com.thiagoyf.core_network.BuildConfig
import com.thiagoyf.core_network.model.NetworkApod
import retrofit2.http.GET

interface NasaApi {
    @GET("planetary/apod?api_key=${BuildConfig.NASA_API_KEY}")
    suspend fun getApod(): NetworkApod
}