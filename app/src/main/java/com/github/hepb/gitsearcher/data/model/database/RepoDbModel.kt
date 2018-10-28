package com.github.hepb.gitsearcher.data.model.database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RepoDbModel: RealmObject() {
    @PrimaryKey open var name: String = ""
    open var description: String? = ""
    open var language: String? = ""
    open var watchersCount: Int = 0

    var createdAt: Long = 0
    var updatedAt: Long = 0
}