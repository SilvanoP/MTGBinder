package br.com.macaxeira.mtgbinder.data.model.remote

import br.com.macaxeira.mtgbinder.data.model.LegalityType
import com.squareup.moshi.Json

class Legalities(
    @Json(name = "standard")
    standard: LegalityType,
    @Json(name = "future")
    future: LegalityType,
    @Json(name = "historic")
    historic: LegalityType,
    @Json(name = "pioneer")
    pioneer: LegalityType,
    @Json(name = "modern")
    modern: LegalityType,
    @Json(name = "legacy")
    legacy: LegalityType,
    @Json(name = "pauper")
    pauper: LegalityType,
    @Json(name = "vintage")
    vintage: LegalityType,
    @Json(name = "penny")
    penny: LegalityType,
    @Json(name = "commander")
    commander: LegalityType,
    @Json(name = "brawl")
    brawl: LegalityType,
    @Json(name = "duel")
    duel: LegalityType,
    @Json(name = "oldschool")
    oldschool: LegalityType
)