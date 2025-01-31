package com.moaimar.pkmtcgapp.presentation.composables.pokemonCard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moaimar.pkmtcgapp.data.repository.RemoteDataRepository
import com.moaimar.pkmtcgapp.domain.model.PokemonCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PokemonCardDetailViewModel(
    private val cardId: String,
    private val cardName: String
) : ViewModel(), KoinComponent {
    private val remoteDataRepository: RemoteDataRepository by inject()

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    var topBarTitle = cardName

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = UiState(isLoading = true)
            remoteDataRepository.fetchTCGCardById(cardId)
                .let { card ->
                    println("dev: $card")
                    _state.value = UiState(card = card)
                }
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val card: PokemonCard? = null
    )
}
