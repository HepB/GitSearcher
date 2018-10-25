package com.github.hepb.gitsearcher.data.repo.search

import com.github.hepb.gitsearcher.data.mapper.SearchUserRespToViewMaper
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel
import com.github.hepb.gitsearcher.data.network.GithubService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UsersSearchRepoImpl(
        private val githubService: GithubService,
        private val mapper: SearchUserRespToViewMaper
) : UsersSearchRepo {

    override fun searchUsers(name: String, page: Int, perPage: Int): Single<List<SearchUserViewModel>> {
        return githubService.searchUsers(name, page, perPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map { response ->
                    val viewModels: MutableList<SearchUserViewModel> = mutableListOf()
                    response.items.forEach { viewModels.add(mapper.mapTo(it)) }
                    return@map viewModels
                }
    }
}