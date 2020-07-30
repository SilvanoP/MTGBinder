package br.com.macaxeira.mtgbinder.domain.model

data class Card (val id: Long,
                 val name: String,
                 val imageUrl: String,
                 var tag: String?,
                 var own: Boolean)