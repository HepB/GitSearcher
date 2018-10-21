package com.github.hepb.gitsearcher.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface MvpBottomNavigationView : MvpView {
    fun selectSearchUser()
    fun selectUser()
    fun selectRepos()
}