package com.github.hepb.gitsearcher.view

import com.arellomobile.mvp.MvpView

interface MvpSearchView: MvpView {
    fun setFoundedUsers(userName: String)
    fun setSearchText(string: String)
}