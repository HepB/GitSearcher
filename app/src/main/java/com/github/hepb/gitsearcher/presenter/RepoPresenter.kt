package com.github.hepb.gitsearcher.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.hepb.gitsearcher.App
import com.github.hepb.gitsearcher.R
import com.github.hepb.gitsearcher.data.repo.repos.ReposRepoRealm
import com.github.hepb.gitsearcher.di.DaggerDbComponent
import com.github.hepb.gitsearcher.view.MvpReposView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

@InjectViewState
class RepoPresenter : MvpPresenter<MvpReposView>() {
    private lateinit var repository: ReposRepoRealm
    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repository = DaggerDbComponent.builder().build().provideReposRepoRealm()
    }

    fun getRepos() {
        viewState.onLoading()
        disposables.add(repository.getReposFromDb().subscribeBy(
                onSuccess = {
                    viewState.onLoadingComplete()
                    viewState.initRepos(it)
                },
                onComplete = {
                    viewState.onLoadingComplete()
                    viewState.showMessage(App.component.appContext().getString(R.string.repos_not_loaded))
                },
                onError = {
                    viewState.onLoadingComplete()
                    viewState.showMessage(it.localizedMessage)
                }
        ))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}
