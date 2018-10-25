package com.github.hepb.gitsearcher.di

import com.github.hepb.gitsearcher.data.mapper.SearchUserRespToViewMaper
import com.github.hepb.gitsearcher.data.network.GithubService
import com.github.hepb.gitsearcher.data.repo.search.UsersSearchRepoImpl
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideApiService(): GithubService {
        return GithubService.create()
    }

    @Provides
    fun providesUsersSearchRepo(mapper: SearchUserRespToViewMaper, githubService: GithubService): UsersSearchRepoImpl =
            UsersSearchRepoImpl(githubService, mapper)

    @Provides
    fun providesSearchUserMapper(): SearchUserRespToViewMaper =
            SearchUserRespToViewMaper()
}