package com.moaimar.pkmtcgapp.data.remote.mapper

import PokemonCardDTO
import PokemonCardListResponse
import PokemonCardResponse
import com.moaimar.pkmtcgapp.data.remote.apimodel.CardSetDTO
import com.moaimar.pkmtcgapp.data.remote.apimodel.CardSetResponse
import com.moaimar.pkmtcgapp.domain.model.Attack
import com.moaimar.pkmtcgapp.domain.model.CardImages
import com.moaimar.pkmtcgapp.domain.model.CardSet
import com.moaimar.pkmtcgapp.domain.model.Holofoil
import com.moaimar.pkmtcgapp.domain.model.Images
import com.moaimar.pkmtcgapp.domain.model.Legalities
import com.moaimar.pkmtcgapp.domain.model.PokemonCard
import com.moaimar.pkmtcgapp.domain.model.Prices
import com.moaimar.pkmtcgapp.domain.model.TcgPlayer
import com.moaimar.pkmtcgapp.domain.model.Weakness

fun CardSetResponse.toDomain(): List<CardSet> {
    return (data?.map { cardSetDTO ->
        cardSetDTO.toDomain()
    } ?: emptyList())
}

fun PokemonCardListResponse.toDomain(): List<PokemonCard> {
    return data.map { cardDTO ->
        cardDTO.toDomain()
    }
}

fun PokemonCardResponse.toDomain(): PokemonCard {
    return data.toDomain()
}

fun PokemonCardDTO.toDomain(): PokemonCard {
    return PokemonCard(
        id = id ?: "",
        name = name ?: "",
        supertype = supertype ?: "",
        subtypes = subtypes ?: emptyList(),
        hp = hp ?: "",
        types = types ?: emptyList(),
        evolvesTo = evolvesTo,
        rules = rules,
        attacks = attacks?.map { attackDTO ->
            Attack(
                name = attackDTO.name,
                cost = attackDTO.cost,
                convertedEnergyCost = attackDTO.convertedEnergyCost,
                damage = attackDTO.damage,
                text = attackDTO.text
            )
        } ?: emptyList(),
        weaknesses = weaknesses?.map { weaknessDTO ->
            Weakness(
                type = weaknessDTO.type ?: "",
                value = weaknessDTO.value ?: ""
            )
        } ?: emptyList(),
        retreatCost = retreatCost ?: emptyList(),
        convertedRetreatCost = convertedRetreatCost ?: 0,
        set = CardSet(
            id = set?.id ?: "",
            name = set?.name ?: "",
            series = set?.series ?: "",
            printedTotal = set?.printedTotal ?: 0,
            total = set?.total ?: 0,
            legalities = Legalities(
                unlimited = set?.legalities?.unlimited ?: "",
                standard = set?.legalities?.standard.toString(),
                expanded = set?.legalities?.expanded.toString()
            ),
            ptcgoCode = set?.ptcgoCode ?: "",
            releaseDate = set?.releaseDate ?: "",
            updatedAt = set?.updatedAt ?: "",
            images = Images(
                symbol = set?.images?.symbol ?: "",
                logo = set?.images?.logo ?: ""
            )
        ),
        number = number ?: "",
        artist = artist ?: "",
        rarity = rarity ?: "",
        nationalPokedexNumbers = nationalPokedexNumbers ?: emptyList(),
        legalities = Legalities(
            unlimited = legalities?.unlimited ?: "",
            standard = legalities?.standard.toString(),
            expanded = legalities?.expanded.toString()
        ),
        images = CardImages(
            small = images?.small ?: "",
            large = images?.large ?: ""
        ),
        tcgPlayer = tcgPlayer?.let { tcgPlayer ->
            TcgPlayer(
                url = tcgPlayer.url,
                updatedAt = tcgPlayer.updatedAt,
                prices = tcgPlayer.prices?.let { prices ->
                    Prices(
                        holoFoil = prices.holofoil?.let { holofoil ->
                            Holofoil(
                                low = holofoil.low ?: 0.0,
                                mid = holofoil.mid ?: 0.0,
                                high = holofoil.high ?: 0.0,
                                market = holofoil.market ?: 0.0,
                                directLow = holofoil.directLow ?: 0.0
                            )
                        }
                    )
                }
            )
        }
    )
}

fun CardSetDTO.toDomain(): CardSet {
    return CardSet(
        id = id ?: "",
        name = name ?: "",
        series = series ?: "",
        printedTotal = printedTotal ?: 0,
        total = total ?: 0,
        legalities = Legalities(
            unlimited = legalities?.unlimited.toString(),
            standard = legalities?.standard.toString(),
            expanded = legalities?.expanded.toString()
        ),
        ptcgoCode = ptcgoCode ?: "",
        releaseDate = releaseDate ?: "",
        updatedAt = updatedAt ?: "",
        images = Images(
            symbol = images.symbol ?: "",
            logo = images.logo ?: ""
        )
    )
}