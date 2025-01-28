package com.moaimar.pkmtcgapp.di

import com.moaimar.pkmtcgapp.di.appModule
import com.moaimar.pkmtcgapp.di.dataModule
import com.moaimar.pkmtcgapp.di.nativeModule
import com.moaimar.pkmtcgapp.di.viewModelsModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        modules(listOf(
            appModule,
            dataModule,
            viewModelsModule,
            nativeModule
        ))
    }
}