package com.github.hepb.gitsearcher.view

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.github.hepb.gitsearcher.data.model.view.UserViewModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface MvpUserView: MvpBaseFragment {
    fun initUserView(user: UserViewModel)
}