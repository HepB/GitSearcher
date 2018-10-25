package com.github.hepb.gitsearcher.di

import com.github.hepb.gitsearcher.data.network.GithubService
import com.github.hepb.gitsearcher.data.repo.search.UsersSearchRepoImpl
import dagger.Component

@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun provideUsersSearchRepoImpl(): UsersSearchRepoImpl
    fun provideApiService(): GithubService
}