package com.github.hepb.gitsearcher.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.hepb.gitsearcher.view.MvpSearchView

import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

@InjectViewState
class SearchPresenter : MvpPresenter<MvpSearchView>() {

    private var disposable: Disposable? = null
    private lateinit var publishSubject: PublishSubject<String>

    fun searchUser(userName: String) {
        //тут изо всех сил будем искать юзера
    }

    fun listenSearchText(text: String) {
        if(disposable == null ) {
            disposable = createSubscribe()
        }
        publishSubject.onNext(text)
    }

    override fun onDestroy() {
        disposable?.dispose()
        super.onDestroy()
    }

    private fun createSubscribe(): Disposable {
        publishSubject = PublishSubject.create()
        return  publishSubject.filter { it.isNotEmpty() }.subscribe { result ->
            Log.i("SearchPresenter", "PublishSubject $result")
        }
    }

}