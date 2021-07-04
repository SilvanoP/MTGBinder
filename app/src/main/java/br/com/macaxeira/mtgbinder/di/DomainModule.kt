package br.com.macaxeira.mtgbinder.di

import br.com.macaxeira.mtgbinder.data.repository.CardRepositoryImpl
import br.com.macaxeira.mtgbinder.domain.repository.CardRepository
import br.com.macaxeira.mtgbinder.domain.usecase.GetAllCollectedCards
import br.com.macaxeira.mtgbinder.domain.usecase.GetAllCollectedCardsImpl
import br.com.macaxeira.mtgbinder.domain.usecase.SearchCards
import br.com.macaxeira.mtgbinder.domain.usecase.SearchCardsImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun providesCardRepository(cardRepositoryImpl: CardRepositoryImpl): CardRepository {
        return cardRepositoryImpl
    }

    @Provides
    fun providesGetAllCollectedCards(cardRepository: CardRepository): GetAllCollectedCards {
        return GetAllCollectedCardsImpl(cardRepository)
    }

    @Provides
    fun providesSearchCards(cardRepository: CardRepository): SearchCards {
        return SearchCardsImpl(cardRepository)
    }
}