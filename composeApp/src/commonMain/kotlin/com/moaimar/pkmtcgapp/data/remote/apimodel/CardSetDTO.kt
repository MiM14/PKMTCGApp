package com.moaimar.pkmtcgapp.data.remote.apimodel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardSetResponse(
    @SerialName("data") val data: List<CardSetDTO>? = null,
    @SerialName("page") val page: Int? = null,
    @SerialName("pageSize") val pageSize: Int? = null,
    @SerialName("count") val count: Int? = null,
    @SerialName("totalCount") val totalCount: Int? = null
)

@Serializable
data class CardSetDTO(
    @SerialName("id") val id: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("series") val series: String? = null,
    @SerialName("printedTotal") val printedTotal: Int? = null,
    @SerialName("total") val total: Int? = null,
    @SerialName("legalities") val legalities: LegalitiesDTO? = null,
    @SerialName("ptcgoCode") val ptcgoCode: String? = null,
    @SerialName("releaseDate") val releaseDate: String? = null,
    @SerialName("updatedAt") val updatedAt: String? = null,
    @SerialName("images") val images: ImagesDTO
)

@Serializable
data class LegalitiesDTO(
    @SerialName("unlimited") val unlimited: String = "",
    @SerialName("standard") val standard: String? = null,
    @SerialName("expanded") val expanded: String? = null
)

@Serializable
data class ImagesDTO(
    @SerialName("symbol") val symbol: String? = null,
    @SerialName("logo") val logo: String? = null
)