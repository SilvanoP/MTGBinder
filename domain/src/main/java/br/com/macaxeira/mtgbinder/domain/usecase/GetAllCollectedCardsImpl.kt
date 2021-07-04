package br.com.macaxeira.mtgbinder.domain.usecase

import br.com.macaxeira.mtgbinder.domain.model.Card
import br.com.macaxeira.mtgbinder.domain.repository.CardRepository

class GetAllCollectedCardsImpl(private val repository: CardRepository) : GetAllCollectedCards {

    override suspend fun getAllCollectedCards(): List<Card> = repository.getAllCollectedCards()

}