package com.github.hepb.gitsearcher.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.hepb.gitsearcher.App
import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.data.repo.user.UserRepo
import com.github.hepb.gitsearcher.di.DaggerDbComponent
import com.github.hepb.gitsearcher.view.MvpUserView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

@InjectViewState
class UserPresenter : MvpPresenter<MvpUserView>() {
    private val disposable: CompositeDisposable = CompositeDisposable()
    private lateinit var userRepo: UserRepo

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        userRepo = DaggerDbComponent.builder().build().provideUserRepoRealm()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    fun getUser() {
        viewState.onLoading()
        disposable.add(userRepo.getUserFromDb().subscribeBy(
                onSuccess = {
                    viewState.onLoadingComplete()
                    viewState.initUserView(it)
                },
                onComplete = {
                    viewState.onLoadingComplete()
                    viewState.showMessage(App.component.appContext().getString(R.string.user_not_loaded))
                },
                onError = {
                    viewState.onLoadingComplete()
                    viewState.showMessage(it.localizedMessage)
                }
        ))
    }
}