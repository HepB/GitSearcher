package com.github.hepb.gitsearcher.di

import com.github.hepb.gitsearcher.data.mapper.RepoRespToDbMapper
import com.github.hepb.gitsearcher.data.mapper.SearchUserRespToViewMaper
import com.github.hepb.gitsearcher.data.mapper.UserRespToDbMapper
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
    fun providesUsersSearchRepo(
            githubService: GithubService,
            searchUserMapper: SearchUserRespToViewMaper,
            userMapper: UserRespToDbMapper,
            repoMapper: RepoRespToDbMapper
    ): UsersSearchRepoImpl =
            UsersSearchRepoImpl(
                    githubService,
                    searchUserMapper,
                    userMapper,
                    repoMapper)

    @Provides
    fun providesSearchUserMapper(): SearchUserRespToViewMaper =
            SearchUserRespToViewMaper()

    @Provides
    fun providesUserMapper(): UserRespToDbMapper = UserRespToDbMapper()

    @Provides
    fun providesRepoMapper(): RepoRespToDbMapper = RepoRespToDbMapper()
}