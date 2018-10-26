package com.github.hepb.gitsearcher.data.mapper

import com.github.hepb.gitsearcher.data.model.database.UserDbModel
import com.github.hepb.gitsearcher.data.model.response.UserResponseModel
import com.github.hepb.gitsearcher.utils.isoStringToLong

class UserRespToDbMapper : EntityMapper<UserResponseModel, UserDbModel> {
    override fun mapTo(model: UserResponseModel): UserDbModel {
        with(model) {
            val result = UserDbModel()
            result.login = login
            result.avatarUrl = avatarUrl
            result.bio = bio
            result.company = company
            result.location = location
            result.name = name
            result.followers = followers
            result.following = following
            result.publicReposNum = publicReposNum
            result.createdAt = isoStringToLong(createdAt)
            result.updatedAt = isoStringToLong(updatedAt)
            return result
        }
    }
}