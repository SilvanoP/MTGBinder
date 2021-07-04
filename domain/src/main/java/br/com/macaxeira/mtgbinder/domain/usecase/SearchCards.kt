package br.com.macaxeira.mtgbinder.domain.usecase

import br.com.macaxeira.mtgbinder.domain.model.Card

interface SearchCards {
    suspend fun searchCards(query: String): List<Card>
}