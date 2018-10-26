package com.github.hepb.gitsearcher.data.repo.user

import com.github.hepb.gitsearcher.data.mapper.UserDbToViewMapper
import com.github.hepb.gitsearcher.data.mapper.UserRespToDbMapper
import com.github.hepb.gitsearcher.data.model.database.UserDbModel
import com.github.hepb.gitsearcher.data.model.view.UserViewModel
import com.github.hepb.gitsearcher.di.DaggerNetworkComponent
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.MaybeEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import java.lang.Exception

class UserRepoRealm(
        private val toDbMapper: UserRespToDbMapper,
        private val toViewMapper: UserDbToViewMapper
) : UserRepo {

    private val githubService = DaggerNetworkComponent.builder().build().provideApiService()

    override fun replaceUser(name: String): Completable = githubService
                    .getUser(name)
                    .flatMapCompletable { result ->
                        val userDbModel = toDbMapper.mapTo(result) //просто маппер привязан к типу БД
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
                    }.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    override fun getUserFromDb(): Maybe<UserViewModel> =
            Maybe.create { maybeEmitter: MaybeEmitter<UserViewModel> ->
                val realm: Realm = Realm.getDefaultInstance()
                realm.beginTransaction()
                try {
                    val dbUsers = realm.where(UserDbModel::class.java).findAll()
                    if (dbUsers.size > 0) {
                        val dbUser = dbUsers[0]
                        val viewUser = toViewMapper.mapTo(dbUser)
                        maybeEmitter.onSuccess(viewUser)
                    } else {
                        maybeEmitter.onComplete()
                    }
                } catch (e: Exception) {
                    realm.cancelTransaction()
                    maybeEmitter.onError(e)
                }
            }.subscribeOn(AndroidSchedulers.mainThread())
}