package br.com.doghero.dhproject

import android.app.Application
import br.com.doghero.dhproject.di.myHeroesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyHeroesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyHeroesApplication)
            modules(
                myHeroesModule
            )
        }
    }

}