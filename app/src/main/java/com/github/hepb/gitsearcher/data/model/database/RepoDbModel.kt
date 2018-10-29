package com.github.hepb.gitsearcher.data.model.database

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RepoDbModel: RealmObject() {
    @PrimaryKey open var name: String = ""
    open var description: String? = ""
    open var language: String? = ""
    open var watchersCount: Int = 0

    open var createdAt: Long = 0
    open var updatedAt: Long = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RepoDbModel) return false

        if (name != other.name) return false
        if (description != other.description) return false
        if (language != other.language) return false
        if (watchersCount != other.watchersCount) return false
        if (createdAt != other.createdAt) return false
        if (updatedAt != other.updatedAt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (language?.hashCode() ?: 0)
        result = 31 * result + watchersCount
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + updatedAt.hashCode()
        return result
    }
}