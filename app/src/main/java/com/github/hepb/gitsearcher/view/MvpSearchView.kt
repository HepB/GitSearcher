package com.github.hepb.gitsearcher.view

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel

interface MvpSearchView: MvpBaseFragment {
    fun setFoundedUsers(foundedUsers: List<SearchUserViewModel>)
    @StateStrategyType(SkipStrategy::class)
    fun userSelected(name: String)
}