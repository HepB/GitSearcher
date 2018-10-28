package com.github.hepb.gitsearcher.data.repo.search

import com.github.hepb.gitsearcher.data.mapper.RepoRespToDbMapper
import com.github.hepb.gitsearcher.data.mapper.SearchUserRespToViewMaper
import com.github.hepb.gitsearcher.data.mapper.UserRespToDbMapper
import com.github.hepb.gitsearcher.data.model.database.RepoDbModel
import com.github.hepb.gitsearcher.data.model.database.UserDbModel
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel
import com.github.hepb.gitsearcher.data.network.GithubService
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmList
import java.lang.Exception

class UsersSearchRepoImpl(
        private val githubService: GithubService,
        private val searchUserRespToViewMapper: SearchUserRespToViewMaper,
        private val userToDbMapper: UserRespToDbMapper,
        private val repoRespToDbMapper: RepoRespToDbMapper
) : UsersSearchRepo {

    override fun replaceUser(name: String): Completable = githubService
            .getUser(name)
            .doOnSuccess { result ->
                val userDbModel = userToDbMapper.mapTo(result) //просто маппер привязан к типу БД
                val realm: Realm = Realm.getDefaultInstance()
                realm.beginTransaction()
                try {
                    realm.delete(UserDbModel::class.java)
                    realm.insert(userDbModel)
                    realm.commitTransaction()
                    Completable.complete()
                } catch (e: Exception) {
                    realm.cancelTransaction()
                    Completable.error(e)
                }
            }.flatMap { githubService.getRepos(name) }
            .flatMapCompletable { result ->
                val reposDbModel = RealmList<RepoDbModel>()
                result.forEach { reposDbModel.add(repoRespToDbMapper.mapTo(it)) }
                val realm: Realm = Realm.getDefaultInstance()
                realm.beginTransaction()
                try {
                    realm.delete(RepoDbModel::class.java)
                    realm.insert(reposDbModel)
                    realm.commitTransaction()
                    Completable.complete()
                } catch (e: Exception) {
                    realm.cancelTransaction()
                    Completable.error(e)
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    override fun searchUsers(name: String, page: Int, perPage: Int): Single<List<SearchUserViewModel>> {
        return githubService.searchUsers(name, page, perPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map { response ->
                    val viewModels: MutableList<SearchUserViewModel> = mutableListOf()
                    response.items.forEach { viewModels.add(searchUserRespToViewMapper.mapTo(it)) }
                    return@map viewModels
                }
    }
}