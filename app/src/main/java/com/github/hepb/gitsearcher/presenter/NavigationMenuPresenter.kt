package com.github.hepb.gitsearcher.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.hepb.gitsearcher.view.MvpBottomNavigationView

@InjectViewState
class NavigationMenuPresenter : MvpPresenter<MvpBottomNavigationView>() {

    fun selectSearchUser() = viewState.selectSearchUser()
    fun selectUser() = viewState.selectUser()
    fun selectRepos() = viewState.selectRepos()
}