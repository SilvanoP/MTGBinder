package br.com.macaxeira.mtgbinder.data.model.remote

import com.squareup.moshi.Json

class ImageUris(
    @Json(name = "small")
    val small: String,
    @Json(name = "normal")
    val normal: String,
    @Json(name = "large")
    val large: String,
    @Json(name = "png")
    val png: String,
    @Json(name = "art_crop")
    val artCrop: String,
    @Json(name = "border_crop")
    val borderCrop: String
)