package com.moaimar.pkmtcgapp.presentation.composables.setCard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moaimar.pkmtcgapp.data.repository.RemoteDataRepository
import com.moaimar.pkmtcgapp.domain.model.PokemonCard
import com.moaimar.pkmtcgapp.domain.model.getMockPokemonCardList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SetCardListViewModel(private val setId: String, private val setName: String) : ViewModel(),
    KoinComponent {
    private val remoteDataRepository: RemoteDataRepository by inject()

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    var topBarTitle = setName

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = UiState(isLoading = true)
            remoteDataRepository.fetchTCGCardList(
                page = 1,
                pageSize = 250,
                setId = setId
            ).let { cards ->
                _state.value = UiState(cards = cards)
            }
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        var cards: List<PokemonCard> = emptyList()
    )
}
