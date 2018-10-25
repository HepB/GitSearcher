package com.github.hepb.gitsearcher

import android.app.Application
import com.github.ajalt.timberkt.Timber
import com.github.hepb.gitsearcher.di.AppComponent
import com.github.hepb.gitsearcher.di.AppModule
import com.github.hepb.gitsearcher.di.DaggerAppComponent
import io.realm.Realm
import io.realm.RealmConfiguration

class App : Application() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        Realm.init(this)
        val configuration = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(configuration)

        component = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
        component.inject(this)
    }
}