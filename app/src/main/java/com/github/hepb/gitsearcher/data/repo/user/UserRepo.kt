package com.github.hepb.gitsearcher.data.repo.user

import com.github.hepb.gitsearcher.data.model.response.UserResponseModel
import com.github.hepb.gitsearcher.data.model.view.UserViewModel
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface UserRepo {
    // UserResponseModel по тому, что если передадим в метод DB-шную модель - привяжемся к DB
    // даже не смотря на то, что для инверсии зависимости используем интерфейс
    fun replaceUser(name: String): Completable
    // пользователь в БД будет всего один, так что идентификатора нам не нужно
    fun getUserFromDb(): Maybe<UserViewModel>
}