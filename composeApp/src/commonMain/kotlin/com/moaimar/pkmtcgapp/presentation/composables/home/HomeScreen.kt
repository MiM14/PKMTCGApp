package com.moaimar.pkmtcgapp.presentation.composables.home

import androidx.compose.foundation.background
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.moaimar.pkmtcgapp.domain.model.CardSet
import com.moaimar.pkmtcgapp.presentation.Screen
import com.moaimar.pkmtcgapp.presentation.composables.common.CustomTopAppBar
import com.moaimar.pkmtcgapp.presentation.composables.common.LoadingIndicator
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import pokemontcgapp.composeapp.generated.resources.Res
import pokemontcgapp.composeapp.generated.resources.app_name

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    vm: HomeViewModel,
    onSetClicked: (String, String) -> Unit
) {
    vm.onUiReady()
    val state by vm.state.collectAsState()

    Screen {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        Scaffold(
            topBar = {
                CustomTopAppBar(
                    title = stringResource(Res.string.app_name),
                    scrollBehavior = scrollBehavior
                )
            },
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
        ) { padding ->
            LoadingIndicator(state.isLoading)

            LazyVerticalGrid(
                columns = GridCells.Adaptive(128.dp),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(padding)
            ) {
                items(state.sets, key = { it.id }) { set ->
                    cardSetGridItem(set, onClick = { onSetClicked(set.id, set.name) })
                }
            }
        }
    }
}

@Composable
@Preview
fun cardSetGridItem(set: CardSet, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3 / 2f)
                .clip(MaterialTheme.shapes.small)
                .background(Color.LightGray)
        ) {
            AsyncImage(
                model = set.images.logo,
                contentDescription = set.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(3 / 2f)
                    .clip(MaterialTheme.shapes.small)
            )
        }
    }
}