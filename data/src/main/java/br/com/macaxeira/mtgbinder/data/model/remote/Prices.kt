package br.com.macaxeira.mtgbinder.data.model.remote

import com.squareup.moshi.Json

class Prices(
    @Json(name = "usd")
    usd: Double,
    @Json(name = "usd_foil")
    usdFoil: Double,
    @Json(name = "eur")
    eur: Double,
    @Json(name = "tix")
    tix: Double
)