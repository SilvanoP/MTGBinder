package br.com.macaxeira.mtgbinder.di

import br.com.macaxeira.mtgbinder.domain.usecase.GetAllCollectedCards
import br.com.macaxeira.mtgbinder.domain.usecase.GetAllCollectedCardsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindGetAllCollectedCards(
        getAllCollectedCardsImpl: GetAllCollectedCardsImpl
    ): GetAllCollectedCards
}