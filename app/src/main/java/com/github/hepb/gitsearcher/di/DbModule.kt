package com.github.hepb.gitsearcher.di

import com.github.hepb.gitsearcher.data.mapper.UserDbToViewMapper
import com.github.hepb.gitsearcher.data.mapper.UserRespToDbMapper
import com.github.hepb.gitsearcher.data.repo.user.UserRepoRealm
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    fun providesUserRepo(mapperToDb: UserRespToDbMapper, mapperToView: UserDbToViewMapper): UserRepoRealm =
            UserRepoRealm(mapperToDb, mapperToView)

    @Provides
    fun providesUserRespToDbMapper(): UserRespToDbMapper = UserRespToDbMapper()

    @Provides
    fun providesUserDbToViewMapper(): UserDbToViewMapper = UserDbToViewMapper()
}