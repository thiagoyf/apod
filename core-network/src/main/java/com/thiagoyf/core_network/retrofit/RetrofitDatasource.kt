package com.thiagoyf.core_network.retrofit

import com.thiagoyf.core_network.NetworkDatasource
import com.thiagoyf.core_network.api.NasaApi
import com.thiagoyf.core_network.model.NetworkApod

class RetrofitDatasource(
    private val nasaApi: NasaApi
): NetworkDatasource {
    override suspend fun getApod(): NetworkApod = nasaApi.getApod()
}
