package com.moaimar.pkmtcgapp.presentation.composables.pokemonCard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.moaimar.pkmtcgapp.presentation.Screen
import com.moaimar.pkmtcgapp.presentation.composables.common.ClickableImage
import com.moaimar.pkmtcgapp.presentation.composables.common.CustomTopAppBarWithBack
import com.moaimar.pkmtcgapp.presentation.composables.common.LoadingIndicator

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
                CustomTopAppBarWithBack(
                    title = vm.topBarTitle,
                    scrollBehavior = scrollBehavior,
                    onBack = onBack
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
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .border(
                                BorderStroke(1.dp, Color.Gray),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(16.dp)
                    ) {
                        Column {
                            ClickableImage(
                                imageUrl = card.images.large,
                                contentDescription = card.name
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Name: ")
                                    }
                                    append(card.name)
                                },
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("HP: ")
                                    }
                                    append(card.hp)
                                },
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Types: ")
                                    }
                                    append(card.types.joinToString())
                                },
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Rarity: ")
                                    }
                                    append(card.rarity)
                                },
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Artist: ")
                                    }
                                    append(card.artist)

                                },
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Price: ")
                                    }
                                    append(
                                        card.tcgPlayer?.prices?.holoFoil?.market?.let { "\$$it" } ?: "N/A"
                                    )
                                },
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Set: ")
                                    }
                                    append(card.set.name)

                                },
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }
        }
    }
}