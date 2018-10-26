package com.github.hepb.gitsearcher.di

import android.content.Context
import com.github.hepb.gitsearcher.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun appContext(): Context
    fun inject(app: App)
}