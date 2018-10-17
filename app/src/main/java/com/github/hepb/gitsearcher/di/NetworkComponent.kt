package com.github.hepb.gitsearcher.di

import com.github.hepb.gitsearcher.data.network.GithubService
import dagger.Component

@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun provideApiService(): GithubService
}