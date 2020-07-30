package br.com.macaxeira.mtgbinder.data.repository

import br.com.macaxeira.mtgbinder.domain.model.Card
import br.com.macaxeira.mtgbinder.domain.repository.CardRepository

class CardRepositoryImpl : CardRepository {
    override fun getAllCollectedCards(): List<Card> {
        return emptyList()
    }
}