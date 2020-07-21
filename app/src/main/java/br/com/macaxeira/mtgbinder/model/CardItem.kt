package br.com.macaxeira.mtgbinder.model

data class CardItem(
    val id: Long,
    val name: String,
    val imageUrl: String,
    var tag: OwnTag?,
    var own: Boolean
)