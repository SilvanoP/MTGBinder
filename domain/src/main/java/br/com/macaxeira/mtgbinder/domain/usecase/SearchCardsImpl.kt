package br.com.macaxeira.mtgbinder.domain.usecase

import br.com.macaxeira.mtgbinder.domain.model.Card
import br.com.macaxeira.mtgbinder.domain.repository.CardRepository

class SearchCardsImpl(private val repository: CardRepository): SearchCards {

    override suspend fun searchCards(query: String): List<Card> {
        return repository.searchCards(query)
    }
}