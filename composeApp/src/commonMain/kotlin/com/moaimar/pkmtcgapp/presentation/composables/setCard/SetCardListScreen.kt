package com.moaimar.pkmtcgapp.presentation.composables.setCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.moaimar.pkmtcgapp.domain.model.PokemonCard
import com.moaimar.pkmtcgapp.presentation.Screen
import org.jetbrains.compose.resources.stringResource
import pokemontcgapp.composeapp.generated.resources.Res
import pokemontcgapp.composeapp.generated.resources.back


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetCardListScreen(
    onCardClicked: (String, String) -> Unit,
    onBack: () -> Unit,
    vm: SetCardListViewModel
) {
    vm.onUiReady()
    val state by vm.state.collectAsState()
    Screen {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(vm.topBarTitle) },
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
            LazyVerticalGrid(
                columns = GridCells.Adaptive(128.dp),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(padding)
            ) {
                items(state.cards, key = { it.id }) { cards ->
                    pokemonCardGridItem(cards, onClick = { onCardClicked(cards.id, cards.name) })
                }
            }
        }
    }
}

@Composable
fun pokemonCardGridItem(
    card: PokemonCard,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = card.images.large,
            contentDescription = card.name,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2 / 3f)
                .clip(MaterialTheme.shapes.small)
        )
        Text(
            text = card.name,
            style = typography.bodySmall,
            modifier = Modifier.padding(8.dp)
        )
    }
}