package com.github.hepb.gitsearcher.data.repo.search

import com.github.hepb.gitsearcher.data.mapper.EntityMapper
import com.github.hepb.gitsearcher.data.mapper.SearchUserMapper
import com.github.hepb.gitsearcher.data.model.response.SearchUserResponseModel
import com.github.hepb.gitsearcher.data.model.response.SearchUsersResponseModel
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel
import com.github.hepb.gitsearcher.data.network.GithubService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UsersSearchRepoImpl(
        private val githubService: GithubService,
        private val mapper: SearchUserMapper
) : UsersSearchRepo {

    override fun searchUsers(name: String): Single<List<SearchUserViewModel>> {
        return githubService.searchUsers(name)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map { response ->
                    val viewModels: MutableList<SearchUserViewModel> = mutableListOf()
                    response.items.forEach { viewModels.add(mapper.mapFromResponse(it)) }
                    return@map viewModels
                }
    }
}