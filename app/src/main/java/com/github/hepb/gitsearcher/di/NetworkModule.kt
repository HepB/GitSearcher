package com.github.hepb.gitsearcher.di

import com.github.hepb.gitsearcher.data.network.GithubService
import dagger.Module
import dagger.Provides

@Module class NetworkModule{

    @Provides
    fun provideApiService(): GithubService {
        return GithubService.create()
    }
}