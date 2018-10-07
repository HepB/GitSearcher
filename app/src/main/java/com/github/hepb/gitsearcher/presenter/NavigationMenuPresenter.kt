package com.github.hepb.gitsearcher.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.hepb.gitsearcher.ui.BottomNavigationMvpView

@InjectViewState
class NavigationMenuPresenter() : MvpPresenter<BottomNavigationMvpView>() {

    fun selectUser() = viewState.selectUser()
    fun selectRepos() = viewState.selectRepos()
}