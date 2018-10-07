package com.github.hepb.gitsearcher.ui

import com.arellomobile.mvp.MvpView

interface MvpSearchView: MvpView {
    fun searchUser(userName: String)
}