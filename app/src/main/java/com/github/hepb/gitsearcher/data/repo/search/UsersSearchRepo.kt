package com.github.hepb.gitsearcher.data.repo.search

import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel
import io.reactivex.Single

interface UsersSearchRepo {
    fun searchUsers(name: String): Single<List<SearchUserViewModel>>
}