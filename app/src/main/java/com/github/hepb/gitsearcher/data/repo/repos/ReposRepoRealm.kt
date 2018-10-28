package com.github.hepb.gitsearcher.data.repo.repos

import com.github.hepb.gitsearcher.data.mapper.RepoDbToViewMapper
import com.github.hepb.gitsearcher.data.model.database.RepoDbModel
import com.github.hepb.gitsearcher.data.model.view.RepositoryViewModel
import io.reactivex.Maybe
import io.reactivex.MaybeEmitter
import io.realm.Realm
import java.lang.Exception

class ReposRepoRealm(private val toViewMapper: RepoDbToViewMapper) : ReposRepo {
    override fun getReposFromDb(): Maybe<List<RepositoryViewModel>> =
            Maybe.create { maybeEmitter: MaybeEmitter<List<RepositoryViewModel>> ->
                val realm: Realm = Realm.getDefaultInstance()
                realm.beginTransaction()
                try {
                    val repos = realm.where(RepoDbModel::class.java).findAll()
                    if (repos.size > 0) {
                        val result: MutableList<RepositoryViewModel> = mutableListOf()
                        repos.forEach { result.add(toViewMapper.mapTo(it))}
                        maybeEmitter.onSuccess(result)
                    } else {
                        maybeEmitter.onComplete()
                    }
                    realm.commitTransaction()
                } catch (e: Exception) {
                    realm.cancelTransaction()
                    maybeEmitter.onError(e)
                }
            }

}