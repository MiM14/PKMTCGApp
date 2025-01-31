package com.moaimar.pkmtcgapp.presentation.composables.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moaimar.pkmtcgapp.data.repository.RemoteDataRepository
import com.moaimar.pkmtcgapp.domain.model.CardSet
import com.moaimar.pkmtcgapp.domain.model.getMockCardSetList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel() : ViewModel(), KoinComponent {
    private val remoteDataRepository: RemoteDataRepository by inject()

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = UiState(isLoading = true)
            remoteDataRepository.fetchTCGSetList(
                page = 1,
                pageSize = 250
            ).let { sets ->
                println("dev: $sets")
                _state.value = UiState(sets = sets)
            }
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val sets: List<CardSet> = emptyList()
    )
}