package com.github.hepb.gitsearcher.view

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface MvpSearchView: MvpView {
    fun setFoundedUsers(users: List<SearchUserViewModel>)
}