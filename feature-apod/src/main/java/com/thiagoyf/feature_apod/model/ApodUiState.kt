package com.thiagoyf.feature_apod.model

import com.thiagoyf.core_model.data.Apod

sealed interface ApodUiState {
    data class Success(val apod: Apod) : ApodUiState
    data class Error(val throwable: Throwable) : ApodUiState
    object Loading : ApodUiState
}