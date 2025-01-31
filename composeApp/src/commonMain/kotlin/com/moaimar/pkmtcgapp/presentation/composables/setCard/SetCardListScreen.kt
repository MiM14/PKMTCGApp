package com.moaimar.pkmtcgapp.presentation.composables.setCard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.moaimar.pkmtcgapp.domain.model.PokemonCard
import com.moaimar.pkmtcgapp.presentation.Screen
import com.moaimar.pkmtcgapp.presentation.composables.common.CustomTopAppBarWithBack
import com.moaimar.pkmtcgapp.presentation.composables.common.LoadingIndicator
import org.jetbrains.compose.resources.painterResource
import pokemontcgapp.composeapp.generated.resources.Res
import pokemontcgapp.composeapp.generated.resources.placeholder

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
                CustomTopAppBarWithBack(
                    title = vm.topBarTitle,
                    scrollBehavior = scrollBehavior,
                    onBack = onBack
                )
            }
        ) { padding ->
            LoadingIndicator(state.isLoading)

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
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = card.images.large,
            contentDescription = card.name,
            placeholder = painterResource(Res.drawable.placeholder),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2 / 3f)
                .clip(MaterialTheme.shapes.small)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = card.name,
                style = typography.bodySmall,
            )
        }

    }
}