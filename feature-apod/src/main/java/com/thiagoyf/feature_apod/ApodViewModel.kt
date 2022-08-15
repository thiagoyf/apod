package com.thiagoyf.feature_apod

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiagoyf.core_data.repository.PlanetaryRepository
import com.thiagoyf.core_model.data.Apod
import com.thiagoyf.feature_apod.model.ApodUiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.Exception

class ApodViewModel(
    private val planetaryRepository: PlanetaryRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<ApodUiState>(ApodUiState.Loading)
    val uiState: StateFlow<ApodUiState> = _uiState

    init {
        load()
    }

    fun load() {
        _uiState.value = ApodUiState.Loading
        viewModelScope.launch {
            try {
                _uiState.value = ApodUiState.Success(planetaryRepository.getApod())
            } catch (exception: Exception) {
                _uiState.value = ApodUiState.Error(exception)
            }
        }
    }
}