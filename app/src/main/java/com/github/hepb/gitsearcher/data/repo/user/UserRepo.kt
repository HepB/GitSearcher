package com.github.hepb.gitsearcher.data.repo.user

import com.github.hepb.gitsearcher.data.model.response.UserResponseModel
import com.github.hepb.gitsearcher.data.model.view.UserViewModel
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface UserRepo {
    // пользователь в БД будет всего один, так что идентификатора нам не нужно
    fun getUserFromDb(): Maybe<UserViewModel>
}