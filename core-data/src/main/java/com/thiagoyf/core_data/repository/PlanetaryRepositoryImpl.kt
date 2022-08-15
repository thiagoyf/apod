package com.thiagoyf.core_data.repository

import com.thiagoyf.core_data.model.asModel
import com.thiagoyf.core_model.data.Apod
import com.thiagoyf.core_network.NetworkDatasource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlanetaryRepositoryImpl(
    private val networkDatasource: NetworkDatasource
): PlanetaryRepository {
    override suspend fun getApod(): Apod {
        return networkDatasource.getApod().asModel()
    }
}