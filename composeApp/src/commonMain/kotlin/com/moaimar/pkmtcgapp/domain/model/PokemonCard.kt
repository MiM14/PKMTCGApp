package com.moaimar.pkmtcgapp.domain.model

data class PokemonCard(
    val id: String,
    val name: String,
    val supertype: String,
    val subtypes: List<String>,
    val hp: String,
    val types: List<String>,
    val evolvesTo: List<String>?,
    val rules: List<String>?,
    val attacks: List<Attack>,
    val weaknesses: List<Weakness>,
    val retreatCost: List<String>,
    val convertedRetreatCost: Int,
    val set: CardSet,
    val number: String,
    val artist: String,
    val rarity: String,
    val nationalPokedexNumbers: List<Int>,
    val legalities: Legalities,
    val images: CardImages,
    val tcgPlayer: TcgPlayer?
)

data class Attack(
    val name: String,
    val cost: List<String>,
    val convertedEnergyCost: Int,
    val damage: String,
    val text: String
)

data class Weakness(
    val type: String,
    val value: String
)

data class CardImages(
    val small: String,
    val large: String
)

data class TcgPlayer(
    val url: String,
    val updatedAt: String,
    val prices: Prices? = null
)

data class Prices(
    val holoFoil: Holofoil? = null
)

data class Holofoil(
    val low: Double,
    val mid: Double,
    val high: Double,
    val market: Double,
    val directLow: Double
)

fun getMockPokemonCardList(): List<PokemonCard> {
    return List(10) { index ->
        PokemonCard(
            id = index.toString(),
            name = "",
            supertype = "",
            subtypes = emptyList(),
            hp = "",
            types = emptyList(),
            evolvesTo = emptyList(),
            rules = emptyList(),
            attacks = emptyList(),
            weaknesses = emptyList(),
            retreatCost = emptyList(),
            convertedRetreatCost = 0,
            set = CardSet(
                id = "",
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
            ),
            number = "",
            artist = "",
            rarity = "",
            nationalPokedexNumbers = emptyList(),
            legalities = Legalities(
                unlimited = "",
                standard = "",
                expanded = ""
            ),
            images = CardImages(
                small = "",
                large = ""
            ),
            tcgPlayer = null
        )
    }
}