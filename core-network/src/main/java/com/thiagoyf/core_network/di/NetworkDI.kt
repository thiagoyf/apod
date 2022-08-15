package com.thiagoyf.core_network.di

import com.thiagoyf.core_network.NetworkDatasource
import com.thiagoyf.core_network.api.NasaApi
import com.thiagoyf.core_network.retrofit.RetrofitDatasource
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkDI {
    val module = module {
        factory<Retrofit> {
            Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        factory<NasaApi> {
            get<Retrofit>().create(NasaApi::class.java)
        }

        single<NetworkDatasource> {
            RetrofitDatasource(nasaApi = get())
        }
    }
}