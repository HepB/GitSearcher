package com.github.hepb.gitsearcher.data.mapper

import com.github.hepb.gitsearcher.data.model.database.RepoDbModel
import com.github.hepb.gitsearcher.data.model.response.RepoResponseModel
import com.github.hepb.gitsearcher.utils.isoStringToLong

class RepoRespToDbMapper: EntityMapper<RepoResponseModel, RepoDbModel> {
    override fun mapTo(model: RepoResponseModel): RepoDbModel {
        with(model) {
            val result = RepoDbModel()
            result.name = name
            result.description = description
            result.language = language
            result.watchersCount = watchersCount
            result.createdAt = isoStringToLong(createdAt)
            result.updatedAt = isoStringToLong(updatedAt)
            return result
        }
    }
}