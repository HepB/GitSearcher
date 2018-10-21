package com.github.hepb.gitsearcher.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel
import com.github.hepb.gitsearcher.data.repo.search.UsersSearchRepo
import com.github.hepb.gitsearcher.di.DaggerNetworkComponent
import com.github.hepb.gitsearcher.view.MvpSearchView

import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

@InjectViewState
class SearchPresenter : MvpPresenter<MvpSearchView>() {

    private val disposables: MutableList<Disposable> = mutableListOf()
    private var users: MutableList<SearchUserViewModel> = mutableListOf()
    private lateinit var publishSubject: PublishSubject<String>
    private lateinit var usersSearchRepo: UsersSearchRepo

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Log.i("SearchPresenter", "onFirstAttach")
        usersSearchRepo = DaggerNetworkComponent.builder().build().provideUsersSearchRepoImpl()
    }

    override fun attachView(view: MvpSearchView?) {
        super.attachView(view)
        Log.i("SearchPresenter", "onAttach")
    }

    fun searchUser(userName: String) {
        //тут изо всех сил будем искать юзера
        val disposable = usersSearchRepo.searchUsers(userName).subscribe { result ->
            users.addAll(result)
            viewState.setFoundedUsers(result)
        }
        disposables.add(disposable)
    }

    fun listenSearchText(text: String) {
        val disposable = createSubscribe()
        disposables.add(disposable)
        publishSubject.onNext(text)
    }

    override fun onDestroy() {
        disposables.forEach { it.dispose() }
        Log.i("SearchPresenter", "onDestroy")
        super.onDestroy()
    }

    private fun createSubscribe(): Disposable {
        publishSubject = PublishSubject.create()
        return publishSubject.filter { it.isNotEmpty() }.subscribe { result ->
            Log.i("SearchPresenter", "PublishSubject $result")
        }
    }

}