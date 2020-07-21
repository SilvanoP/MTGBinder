package br.com.macaxeira.mtgbinder.model

data class DeckItem(
    var id: Long,
    var name: String,
    var colors: MutableList<ColorPie>,
    var format: String
)
