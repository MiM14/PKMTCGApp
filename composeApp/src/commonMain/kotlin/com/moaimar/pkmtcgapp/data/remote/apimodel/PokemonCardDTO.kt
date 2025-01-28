import com.moaimar.pkmtcgapp.data.remote.apimodel.ImagesDTO
import com.moaimar.pkmtcgapp.data.remote.apimodel.LegalitiesDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonCardListResponse(
    @SerialName("data") val data: List<PokemonCardDTO>,
    @SerialName("page") val page: Int? = null,
    @SerialName("pageSize") val pageSize: Int? = null,
    @SerialName("count") val count: Int? = null,
    @SerialName("totalCount") val totalCount: Int? = null
)

@Serializable
data class PokemonCardResponse(
    @SerialName("data") val data: PokemonCardDTO
)

@Serializable
data class PokemonCardDTO(
    @SerialName("id") val id: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("supertype") val supertype: String? = null,
    @SerialName("subtypes") val subtypes: List<String>? = null,
    @SerialName("hp") val hp: String? = null,
    @SerialName("types") val types: List<String>? = null,
    @SerialName("evolvesTo") val evolvesTo: List<String>? = null,
    @SerialName("rules") val rules: List<String>? = null,
    @SerialName("attacks") val attacks: List<AttackDTO>? = null,
    @SerialName("weaknesses") val weaknesses: List<WeaknessDTO>? = null,
    @SerialName("retreatCost") val retreatCost: List<String>? = null,
    @SerialName("convertedRetreatCost") val convertedRetreatCost: Int? = null,
    @SerialName("set") val set: CardSetDTO? = null,
    @SerialName("number") val number: String? = null,
    @SerialName("artist") val artist: String? = null,
    @SerialName("rarity") val rarity: String? = null,
    @SerialName("nationalPokedexNumbers") val nationalPokedexNumbers: List<Int>? = null,
    @SerialName("legalities") val legalities: LegalitiesDTO? = null,
    @SerialName("images") val images: CardImagesDTO? = null,
    @SerialName("tcgplayer") val tcgPlayer: TcgPlayerDTO? = null
)

@Serializable
data class AttackDTO(
    @SerialName("name") val name: String,
    @SerialName("cost") val cost: List<String>,
    @SerialName("convertedEnergyCost") val convertedEnergyCost: Int,
    @SerialName("damage") val damage: String,
    @SerialName("text") val text: String
)

@Serializable
data class WeaknessDTO(
    @SerialName("type") val type: String? = null,
    @SerialName("value") val value: String? = null
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
data class CardImagesDTO(
    @SerialName("small") val small: String,
    @SerialName("large") val large: String
)

@Serializable
data class TcgPlayerDTO(
    @SerialName("url") val url: String,
    @SerialName("updatedAt") val updatedAt: String,
    @SerialName("prices") val prices: PricesDTO? = null
)

@Serializable
data class PricesDTO(
    @SerialName("holofoil") val holofoil: HolofoilDTO? = null
)

@Serializable
data class HolofoilDTO(
    @SerialName("low") val low: Double? = null,
    @SerialName("mid") val mid: Double? = null,
    @SerialName("high") val high: Double? = null,
    @SerialName("market") val market: Double? = null,
    @SerialName("directLow") val directLow: Double? = null
)