package com.github.hepb.gitsearcher.data.mapper

import com.github.hepb.gitsearcher.data.model.database.UserDbModel
import com.github.hepb.gitsearcher.data.model.view.UserViewModel
import com.github.hepb.gitsearcher.utils.timeToSting

class UserDbToViewMapper : EntityMapper<UserDbModel, UserViewModel> {
    override fun map(model: UserDbModel): UserViewModel =
            with(model) {
                UserViewModel(
                        login = login,
                        avatarUrl = avatarUrl,
                        name = name,
                        company = company,
                        bio = bio,
                        location = location,
                        publicReposNum = publicReposNum,
                        followers = followers,
                        following = following,
                        type = type,
                        createdAt = timeToSting(createdAt),
                        updatedAt = timeToSting(updatedAt)
                )
            }
}