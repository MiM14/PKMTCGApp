package com.moaimar.pkmtcgapp.presentation.composables.pokemonCard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moaimar.pkmtcgapp.presentation.Screen
import com.moaimar.pkmtcgapp.presentation.composables.common.ClickableImage
import com.moaimar.pkmtcgapp.presentation.composables.common.LoadingIndicator
import org.jetbrains.compose.resources.stringResource
import pokemontcgapp.composeapp.generated.resources.Res
import pokemontcgapp.composeapp.generated.resources.back

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonCardDetailScreen(
    vm: PokemonCardDetailViewModel,
    onBack: () -> Unit
) {
    vm.onUiReady()
    val state by vm.state.collectAsState()

    Screen {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = vm.topBarTitle) },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = stringResource(Res.string.back)
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            ) {
                LoadingIndicator(state.isLoading)

                state.card?.let { card ->
                    ClickableImage(
                        imageUrl = card.images.large,
                        contentDescription = card.name
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Name: ${card.name}", style = MaterialTheme.typography.bodyLarge)
                    Text(text = "HP: ${card.hp}", style = MaterialTheme.typography.bodyLarge)
                    Text(
                        text = "Types: ${card.types.joinToString()}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(text = "Rarity: ${card.rarity}", style = MaterialTheme.typography.bodyLarge)
                    Text(text = "Artist: ${card.artist}", style = MaterialTheme.typography.bodyLarge)
                    Text(text = "Set: ${card.set.name}", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}