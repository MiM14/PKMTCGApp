package com.moaimar.pkmtcgapp

import androidx.compose.runtime.Composable
import com.moaimar.pkmtcgapp.presentation.Navigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        Navigation()
    }
}

