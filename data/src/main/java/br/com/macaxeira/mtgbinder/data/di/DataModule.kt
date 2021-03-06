package br.com.macaxeira.mtgbinder.data.di

import br.com.macaxeira.mtgbinder.data.BuildConfig
import br.com.macaxeira.mtgbinder.data.remote.ScryfallWebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideScryfallService(): ScryfallWebService {
        val client = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return client.create(ScryfallWebService::class.java)
    }
}