package com.thiagoyf.core_data.di

import com.thiagoyf.core_data.repository.PlanetaryRepository
import com.thiagoyf.core_data.repository.PlanetaryRepositoryImpl
import org.koin.dsl.module

object DataDI {
    val module = module {
        single<PlanetaryRepository> {
            PlanetaryRepositoryImpl(
                networkDatasource = get()
            )
        }
    }
}