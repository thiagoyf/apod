package com.thiagoyf.core_data.repository

import com.thiagoyf.core_model.data.Apod
import kotlinx.coroutines.flow.Flow

interface PlanetaryRepository {
    suspend fun getApod(): Apod
}