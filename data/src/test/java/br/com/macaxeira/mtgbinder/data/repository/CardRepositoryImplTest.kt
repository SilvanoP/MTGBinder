package br.com.macaxeira.mtgbinder.data.repository

import br.com.macaxeira.mtgbinder.data.model.remote.RemoteCard
import br.com.macaxeira.mtgbinder.data.remote.ScryfallWebService
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CardRepositoryImplTest {

    @Mock
    private lateinit var webService: ScryfallWebService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getAllCollectedCards() = runBlocking {
        val repository = CardRepositoryImpl(webService)

        val result = repository.getAllCollectedCards()
        Assert.assertEquals("Incorrect list size", 0, result.size)
    }

    @Test
    fun searchCards_success() = runBlocking {
        val query = "testing query"
        Mockito.`when`(webService.getCards(query)).thenReturn(emptyList())
        val repository = CardRepositoryImpl(webService)

        val result = repository.searchCards(query)
        Assert.assertEquals("",0,  result.size)
    }

}