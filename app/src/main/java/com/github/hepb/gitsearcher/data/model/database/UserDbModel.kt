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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserDbModel) return false

        if (login != other.login) return false
        if (avatarUrl != other.avatarUrl) return false
        if (type != other.type) return false
        if (name != other.name) return false
        if (company != other.company) return false
        if (location != other.location) return false
        if (bio != other.bio) return false
        if (publicReposNum != other.publicReposNum) return false
        if (followers != other.followers) return false
        if (following != other.following) return false
        if (createdAt != other.createdAt) return false
        if (updatedAt != other.updatedAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = login.hashCode()
        result = 31 * result + avatarUrl.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (company?.hashCode() ?: 0)
        result = 31 * result + (location?.hashCode() ?: 0)
        result = 31 * result + (bio?.hashCode() ?: 0)
        result = 31 * result + publicReposNum
        result = 31 * result + followers
        result = 31 * result + following
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + updatedAt.hashCode()
        return result
    }
}