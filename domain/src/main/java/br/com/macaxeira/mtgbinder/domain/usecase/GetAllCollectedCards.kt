package br.com.macaxeira.mtgbinder.domain.usecase

import br.com.macaxeira.mtgbinder.domain.model.Card

interface GetAllCollectedCards {
    suspend fun getAllCollectedCards(): List<Card>
}