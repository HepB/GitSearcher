package com.github.hepb.gitsearcher.view

import com.arellomobile.mvp.MvpView

interface MvpBaseFragment: MvpView {
    fun onLoading()
    fun onLoadingComplete()
    fun showMessage(message: String)
}