package com.github.hepb.gitsearcher.view

import com.arellomobile.mvp.MvpView
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel

interface MvpSearchView: MvpView {
    fun setFoundedUsers(users: List<SearchUserViewModel>)
}