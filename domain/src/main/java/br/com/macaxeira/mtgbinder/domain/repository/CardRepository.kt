package br.com.macaxeira.mtgbinder.domain.repository

import br.com.macaxeira.mtgbinder.domain.model.Card

interface CardRepository {

    suspend fun getAllCollectedCards(): List<Card>
    suspend fun searchCards(query: String): List<Card>

}