package com.moaimar.pkmtcgapp.domain.model

data class CardSet(
    val id: String,
    val name: String,
    val series: String,
    val printedTotal: Int,
    val total: Int,
    val legalities: Legalities,
    val ptcgoCode: String,
    val releaseDate: String,
    val updatedAt: String,
    val images: Images
)

data class Legalities(
    val unlimited: String,
    val standard: String,
    val expanded: String
)

data class Images(
    val symbol: String,
    val logo: String
)