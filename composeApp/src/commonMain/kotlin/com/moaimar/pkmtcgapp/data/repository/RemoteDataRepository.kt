package com.moaimar.pkmtcgapp.data.repository

import com.moaimar.pkmtcgapp.data.remote.ApiClient
import com.moaimar.pkmtcgapp.data.remote.mapper.toDomain

class RemoteDataRepository(private val apiClient: ApiClient) {
    suspend fun fetchTCGCardList(page: Int, pageSize: Int, setId: String) =
        apiClient.fetchTCGCardList(page, pageSize, setId).toDomain()

    suspend fun fetchTCGSetList(page: Int, pageSize: Int) =
        apiClient.fetchTCGSetList(page, pageSize).toDomain()


    suspend fun fetchTCGCardById(cardId: String) =
        apiClient.fetchTCGCardById(cardId = cardId).toDomain()

    suspend fun fetchTCGSetById(setId: String) =
        apiClient.fetchTCGSetById(setId = setId).toDomain()
}