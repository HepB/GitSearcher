package com.github.hepb.gitsearcher.data.mapper

import com.github.hepb.gitsearcher.data.model.database.RepoDbModel
import com.github.hepb.gitsearcher.data.model.database.UserDbModel
import com.github.hepb.gitsearcher.data.model.response.RepoResponseModel
import com.github.hepb.gitsearcher.data.model.response.SearchUserResponseModel
import com.github.hepb.gitsearcher.data.model.response.UserResponseModel
import com.github.hepb.gitsearcher.data.model.view.RepositoryViewModel
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel
import com.github.hepb.gitsearcher.data.model.view.UserViewModel

fun initRepoDbModel(): RepoDbModel {
    val result = RepoDbModel()
    result.name = "HepB"
    result.description = "description"
    result.language = "java"
    result.watchersCount = 0
    result.createdAt = 0
    result.updatedAt = 0
    return result
}

fun initRepositoryViewModel() =
        RepositoryViewModel(
                name = "HepB",
                description = "description",
                language = "java",
                watchersCount = 0,
                createdAt = "01.01.1970",
                updatedAt = "01.01.1970"
        )

fun initRepoResponseModel() =
        RepoResponseModel(
                name = "HepB",
                description = "description",
                language = "java",
                watchersCount = 0,
                createdAt = "1970-01-01T00:00:00Z",
                updatedAt = "1970-01-01T00:00:00Z"
        )

fun initSearchUserResponseModel() =
        SearchUserResponseModel(
                login = "HepB",
                id = 1,
                avatarUrl = "",
                type = "User",
                siteAdmin = false,
                score = 100.0
        )

fun initSearchUserViewModel() =
        SearchUserViewModel(
                login = "HepB",
                id = 1,
                avatarUrl = "",
                type = "User",
                siteAdmin = false,
                score = 100.0
        )

fun initUserDbModel(): UserDbModel {
    val result = UserDbModel()
    result.login = "HepB"
    result.name = "Alexandr"
    result.bio = ""
    result.type = "User"
    result.company = "Mts"
    result.followers = 2
    result.following = 3
    result.location = "Russia"
    result.avatarUrl = ""
    result.publicReposNum = 7
    result.createdAt = 0
    result.updatedAt = 0
    return result
}

fun initUserViewModel() =
        UserViewModel(
                login = "HepB",
                name = "Alexandr",
                bio = "",
                type = "User",
                company = "Mts",
                followers = 2,
                following = 3,
                location = "Russia",
                avatarUrl = "",
                publicReposNum = 7,
                createdAt = "01.01.1970",
                updatedAt = "01.01.1970"
        )

fun initUserRespModel() =
        UserResponseModel(
                login = "HepB",
                name = "Alexandr",
                bio = "",
                type = "User",
                company = "Mts",
                followers = 2,
                following = 3,
                location = "Russia",
                siteAdmin = false,
                avatarUrl = "",
                publicReposNum = 7,
                createdAt = "1970-01-01T00:00:00Z",
                updatedAt = "1970-01-01T00:00:00Z"
        )