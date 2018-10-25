package com.github.hepb.gitsearcher.data.model.database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserDbModel : RealmObject() {
    @PrimaryKey open var login: String = ""
    open var avatarUrl: String = ""
    open var type: String = ""
    open var name: String? = ""
    open var company: String? = ""
    open var location: String? = ""
    open var bio: String? = ""
    open var publicReposNum: Int = 0
    open var followers: Int = 0
    open var following: Int = 0
    open var createdAt: Long = 0
    open var updatedAt: Long = 0
}