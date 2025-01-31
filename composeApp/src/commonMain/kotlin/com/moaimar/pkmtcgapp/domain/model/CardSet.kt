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

fun getMockCardSetList(): List<CardSet> {
    return List(10) { index ->
        CardSet(
            id = index.toString(),
            name = "",
            series = "",
            printedTotal = 0,
            total = 0,
            legalities = Legalities(
                unlimited = "",
                standard = "",
                expanded = ""
            ),
            ptcgoCode = "",
            releaseDate = "",
            updatedAt = "",
            images = Images(
                symbol = "",
                logo = ""
            )
        )
    }
}