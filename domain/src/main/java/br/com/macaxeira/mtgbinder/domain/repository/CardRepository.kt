package br.com.macaxeira.mtgbinder.domain.repository

import br.com.macaxeira.mtgbinder.domain.model.Card

interface CardRepository {

    fun getAllCollectedCards(): List<Card>
}