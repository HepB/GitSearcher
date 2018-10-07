package com.github.hepb.gitsearcher.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.hepb.gitsearcher.ui.MvpSearchView

@InjectViewState
class SearchPresenter : MvpPresenter<MvpSearchView>() {
    private lateinit var userName: String

    fun searchUser(userName: String) {
        //тут изо всех сил будем искать юзера
        this.userName = userName
        viewState.searchUser(this.userName)
    }
}