package com.github.hepb.gitsearcher.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.hepb.gitsearcher.view.MvpSearchView
import io.reactivex.Single
import io.reactivex.disposables.Disposable

@InjectViewState
class SearchPresenter : MvpPresenter<MvpSearchView>() {
    private val disposables: MutableList<Disposable> = mutableListOf()

    fun searchUser(userName: String) {
        //тут изо всех сил будем искать юзера
    }

    fun listenSearchText(text: String) {
        val single = Single.just(text)
        val disposable = single.subscribe { result ->
            Log.i("SearchPresenter", result)
        }
        disposables.add(disposable)
    }

    override fun onDestroy() {
        disposables.forEach { it.dispose() }
        super.onDestroy()
    }
}