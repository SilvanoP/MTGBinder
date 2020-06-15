package br.com.macaxeira.mtgbinder.features.collection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.macaxeira.mtgbinder.model.CardItem
import br.com.macaxeira.mtgbinder.model.OwnTag
import timber.log.Timber

class CollectionViewModel : ViewModel() {

    private val fullCardList = listOf(
        CardItem(0L, "test", "https://img.scryfall.com/cards/normal/front/2/1/215165e8-16f2-4dbf-932d-06c2a9a174d5.jpg?1573508657", OwnTag.MTGA, true),
        CardItem(1L, "card", "https://img.scryfall.com/cards/normal/front/6/d/6da045f8-6278-4c84-9d39-025adf0789c1.jpg?1562404626", null, false)
    )
    
    val cards = MutableLiveData<MutableList<CardItem>>().apply {
        value = fullCardList.toMutableList()
    }

    fun searchCards(search: String) {
        val cardList = cards.value
        val foundCards = mutableListOf<CardItem>()
        cardList?.forEach {
            if (it.name.contains(search, true))
                foundCards.add(it)
        }

        Timber.d("%d cards found!", foundCards.size)
        cards.postValue(foundCards)
    }

    fun showAll() {
        cards.postValue(fullCardList.toMutableList())
    }
}