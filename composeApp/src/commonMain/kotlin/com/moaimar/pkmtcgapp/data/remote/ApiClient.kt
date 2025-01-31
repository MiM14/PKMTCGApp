package com.moaimar.pkmtcgapp.data.remote

import PokemonCardListResponse
import PokemonCardResponse
import com.moaimar.pkmtcgapp.data.remote.apimodel.CardSetDTO
import com.moaimar.pkmtcgapp.data.remote.apimodel.CardSetResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiClient(private val client: HttpClient) {

    suspend fun fetchTCGCardList(page: Int, pageSize: Int, setId: String): PokemonCardListResponse {
        return client.get("cards") {
            parameter("page", page)
            parameter("pageSize", pageSize)
            parameter("q", "set.id:$setId")
        }.body()
    }

    suspend fun fetchTCGSetList(page: Int, pageSize: Int): CardSetResponse {
        println("dev: ${client.engine}")
        return client.get("sets") {
            parameter("page", page)
            parameter("pageSize", pageSize)
        }.body()
    }

    suspend fun fetchTCGCardById(cardId: String): PokemonCardResponse =
        client.get("cards/$cardId") {
            parameter("id", cardId)
        }.body()

    suspend fun fetchTCGSetById(setId: String): CardSetDTO = client.get("sets/$setId").body()
}