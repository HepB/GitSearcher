package com.github.hepb.gitsearcher.di

import com.github.hepb.gitsearcher.data.mapper.RepoRespToDbMapper
import com.github.hepb.gitsearcher.data.mapper.SearchUserRespToViewMapper
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
            searchUserMapper: SearchUserRespToViewMapper,
            userMapper: UserRespToDbMapper,
            repoMapper: RepoRespToDbMapper
    ): UsersSearchRepoImpl =
            UsersSearchRepoImpl(
                    githubService,
                    searchUserMapper,
                    userMapper,
                    repoMapper)

    @Provides
    fun providesSearchUserMapper(): SearchUserRespToViewMapper =
            SearchUserRespToViewMapper()

    @Provides
    fun providesUserMapper(): UserRespToDbMapper = UserRespToDbMapper()

    @Provides
    fun providesRepoMapper(): RepoRespToDbMapper = RepoRespToDbMapper()
}