package com.github.hepb.gitsearcher.di

import com.github.hepb.gitsearcher.data.mapper.RepoDbToViewMapper
import com.github.hepb.gitsearcher.data.mapper.UserDbToViewMapper
import com.github.hepb.gitsearcher.data.repo.repos.ReposRepoRealm
import com.github.hepb.gitsearcher.data.repo.user.UserRepoRealm
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    fun providesUserRepo(mapperToView: UserDbToViewMapper): UserRepoRealm = UserRepoRealm(mapperToView)

    @Provides
    fun providesUserDbToViewMapper(): UserDbToViewMapper = UserDbToViewMapper()

    @Provides
    fun providesReposRepo(mapperToView: RepoDbToViewMapper) = ReposRepoRealm(mapperToView)

    @Provides
    fun providesRepoDbToViewMapper(): RepoDbToViewMapper = RepoDbToViewMapper()
}