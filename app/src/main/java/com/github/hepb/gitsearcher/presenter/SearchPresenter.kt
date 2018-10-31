package com.github.hepb.gitsearcher.presenter

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.hepb.gitsearcher.data.repo.search.UsersSearchRepo
import com.github.hepb.gitsearcher.data.repo.user.UserRepo
import com.github.hepb.gitsearcher.di.DaggerDbComponent
import com.github.hepb.gitsearcher.di.DaggerNetworkComponent
import com.github.hepb.gitsearcher.view.MvpSearchView

import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject

@InjectViewState
class SearchPresenter : MvpPresenter<MvpSearchView>() {

    private val disposables: MutableList<Disposable> = mutableListOf()
    private lateinit var publishSubject: PublishSubject<String>
    private lateinit var usersSearchRepo: UsersSearchRepo

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        usersSearchRepo = DaggerNetworkComponent.builder().build().provideUsersSearchRepoImpl()
    }

    fun searchUser(userName: String, page: Int, perPage: Int) {
        //тут изо всех сил будем искать юзера
        viewState.onLoading()
        val disposable = usersSearchRepo.searchUsers(userName, page, perPage).subscribe(
                { result ->
                    viewState.setFoundedUsers(result)
                    viewState.onLoadingComplete()
                },
                { error ->
                    viewState.onLoadingComplete()
                    viewState.showMessage(error.localizedMessage)
                })
        disposables.add(disposable)
    }

    fun listenSearchText(text: String) {
        val disposable = createSubscribe()
        disposables.add(disposable)
        publishSubject.onNext(text)
    }

    fun selectUser(name: String) {
        viewState.onLoading()
        disposables.add(usersSearchRepo.replaceUser(name).subscribeBy(
                onComplete = {
                    viewState.userSelected(name)
                    viewState.onLoadingComplete()
                },
                onError = {
                    it.printStackTrace()
                    viewState.onLoadingComplete()
                    viewState.showMessage(it.toString())
                }
        ))
    }

    override fun onDestroy() {
        disposables.forEach { it.dispose() }
        super.onDestroy()
    }

    private fun createSubscribe(): Disposable {
        publishSubject = PublishSubject.create()
        return publishSubject.filter { it.isNotEmpty() }.subscribe { result ->
            Log.i("SearchPresenter", "PublishSubject $result")
        }
    }


}