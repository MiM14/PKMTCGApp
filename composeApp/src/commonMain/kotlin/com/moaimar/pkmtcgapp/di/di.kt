package com.moaimar.pkmtcgapp.di

import com.moaimar.pkmtcgapp.data.remote.ApiClient
import com.moaimar.pkmtcgapp.data.repository.RemoteDataRepository
import com.moaimar.pkmtcgapp.presentation.composables.home.HomeViewModel
import com.moaimar.pkmtcgapp.presentation.composables.pokemonCard.PokemonCardDetailViewModel
import com.moaimar.pkmtcgapp.presentation.composables.setCard.SetCardListViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val appModule = module {
    single { }
}

val dataModule = module {
    single {
        HttpClient {
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
                    host = "api.pokemontcg.io/v2"
                    header("X-Api-Key", "3f3d030d-4794-4a40-9b36-f5c4e34443b9")
                }
            }
        }
    }

    factoryOf(::RemoteDataRepository)
    factoryOf(::ApiClient)
}

val viewModelsModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::SetCardListViewModel)
    viewModelOf(::PokemonCardDetailViewModel)
}

val nativeModule = module {
    single { }
}

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModule, dataModule, viewModelsModule, nativeModule)
    }
}