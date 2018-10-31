package com.github.hepb.gitsearcher.data.repo.user

import com.github.hepb.gitsearcher.data.mapper.UserDbToViewMapper
import com.github.hepb.gitsearcher.data.model.database.UserDbModel
import com.github.hepb.gitsearcher.data.model.view.UserViewModel
import io.reactivex.Maybe
import io.reactivex.MaybeEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import java.lang.Exception

class UserRepoRealm(
        private val toViewMapper: UserDbToViewMapper
) : UserRepo {

    override fun getUserFromDb(): Maybe<UserViewModel> =
            Maybe.create { maybeEmitter: MaybeEmitter<UserViewModel> ->
                val realm: Realm = Realm.getDefaultInstance()
                realm.beginTransaction()
                try {
                    val dbUsers = realm.where(UserDbModel::class.java).findAll()
                    if (dbUsers.size > 0) {
                        val dbUser = dbUsers[0]
                        val viewUser = toViewMapper.map(dbUser)
                        maybeEmitter.onSuccess(viewUser)
                    } else {
                        maybeEmitter.onComplete()
                    }
                    realm.commitTransaction()
                } catch (e: Exception) {
                    realm.cancelTransaction()
                    maybeEmitter.onError(e)
                }
            }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}