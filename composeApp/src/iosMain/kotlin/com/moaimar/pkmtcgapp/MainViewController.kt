package com.moaimar.pkmtcgapp

import androidx.compose.ui.window.ComposeUIViewController
import com.moaimar.pkmtcgapp.di.initIosKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initIosKoin() }
) {
    App()
}