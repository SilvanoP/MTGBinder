package br.com.macaxeira.mtgbinder.data.repository

import br.com.macaxeira.mtgbinder.data.remote.ScryfallWebService
import br.com.macaxeira.mtgbinder.data.util.mappers.CardMapper
import br.com.macaxeira.mtgbinder.domain.model.Card
import br.com.macaxeira.mtgbinder.domain.repository.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    val scryfallWebService: ScryfallWebService
) : CardRepository {

    override suspend fun getAllCollectedCards(): List<Card> {
        return emptyList()
    }

    override suspend fun searchCards(query: String): List<Card> {
        return scryfallWebService.getCards(query).let {
            val resultCards = mutableListOf<Card>()
            it.forEach { remoteCard ->
                val card = CardMapper.mapRemoteCardToDomain(remoteCard)
                resultCards.add(card)
            }
            resultCards
        }
    }
}