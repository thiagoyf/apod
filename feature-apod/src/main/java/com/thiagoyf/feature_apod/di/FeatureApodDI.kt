package com.thiagoyf.feature_apod.di

import com.thiagoyf.feature_apod.ApodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object FeatureApodDI {
    val module = module {
        viewModel {
            ApodViewModel(planetaryRepository = get())
        }
    }
}