package br.com.macaxeira.mtgbinder

import android.app.Application
import timber.log.Timber

class MTGBinderApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}