package com.thiagoyf.core_network

import com.thiagoyf.core_network.model.NetworkApod

interface NetworkDatasource {
    suspend fun getApod(): NetworkApod
}