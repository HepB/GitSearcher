package com.github.hepb.gitsearcher.di

import com.github.hepb.gitsearcher.data.repo.repos.ReposRepoRealm
import com.github.hepb.gitsearcher.data.repo.user.UserRepoRealm
import dagger.Component

@Component(modules = [DbModule::class])
interface DbComponent {
    fun provideUserRepoRealm(): UserRepoRealm
    fun provideReposRepoRealm(): ReposRepoRealm
}