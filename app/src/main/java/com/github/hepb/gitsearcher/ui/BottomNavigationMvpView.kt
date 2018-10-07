package com.github.hepb.gitsearcher.ui

import com.arellomobile.mvp.MvpView

interface BottomNavigationMvpView : MvpView {
    fun selectUser()
    fun selectRepos()
}