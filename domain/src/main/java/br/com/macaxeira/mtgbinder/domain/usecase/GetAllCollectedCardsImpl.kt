package br.com.macaxeira.mtgbinder.domain.usecase

import br.com.macaxeira.mtgbinder.domain.model.Card
import br.com.macaxeira.mtgbinder.domain.repository.CardRepository
import javax.inject.Inject

class GetAllCollectedCardsImpl @Inject constructor(val repository: CardRepository) : GetAllCollectedCards {

    override fun getAllCollectedCards(): List<Card> = repository.getAllCollectedCards()

}