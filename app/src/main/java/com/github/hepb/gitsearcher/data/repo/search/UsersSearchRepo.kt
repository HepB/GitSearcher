package com.github.hepb.gitsearcher.data.repo.search

import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel
import io.reactivex.Completable
import io.reactivex.Single

interface UsersSearchRepo {
    // UserResponseModel по тому, что если передадим в метод DB-шную модель - привяжемся к DB
    // даже не смотря на то, что для инверсии зависимости используем интерфейс
    fun replaceUser(name: String): Completable

    fun searchUsers(name: String, page: Int, perPage: Int): Single<List<SearchUserViewModel>>
}