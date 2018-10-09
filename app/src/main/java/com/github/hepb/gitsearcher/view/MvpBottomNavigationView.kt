package com.github.hepb.gitsearcher.view

import com.arellomobile.mvp.MvpView

interface MvpBottomNavigationView : MvpView {
    fun selectSearchUser()
    fun selectUser()
    fun selectRepos()
}