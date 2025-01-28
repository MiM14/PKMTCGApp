package com.moaimar.pkmtcgapp.di

import com.moaimar.pkmtcgapp.data.remote.ApiClient
import com.moaimar.pkmtcgapp.data.repository.RemoteDataRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.http.URLProtocol
import io.ktor.http.encodedPath
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.module

val iosDataModule = module {
    single {
        HttpClient(Darwin) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    encodeDefaults = true
                })
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "api.pokemontcg.io"
                    encodedPath = "/v2/"
                }
                header("X-Api-Key", "3f3d030d-4794-4a40-9b36-f5c4e34443b9")
            }
        }
    }

    factory { RemoteDataRepository(get()) }
    factory { ApiClient(get()) }
}

fun initIosKoin() {
    startKoin {
        modules(listOf(
            appModule,
            iosDataModule,
            viewModelsModule,
            nativeModule
        ))
    }
}