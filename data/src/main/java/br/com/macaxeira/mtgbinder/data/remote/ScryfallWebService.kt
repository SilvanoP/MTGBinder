package br.com.macaxeira.mtgbinder.data.remote

import br.com.macaxeira.mtgbinder.data.model.remote.RemoteCard
import retrofit2.http.GET
import retrofit2.http.Query

interface ScryfallWebService {

    @GET("")
    suspend fun getCards(
        @Query("q") query: String
    ): List<RemoteCard>
}