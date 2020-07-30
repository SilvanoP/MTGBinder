package br.com.macaxeira.mtgbinder.data.remote

import br.com.macaxeira.mtgbinder.data.model.Card
import retrofit2.http.GET

interface ScryfallWebService {

    @GET("")
    suspend fun getCards(): List<Card>
}