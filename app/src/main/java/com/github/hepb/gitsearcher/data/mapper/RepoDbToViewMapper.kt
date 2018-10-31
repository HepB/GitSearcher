package com.github.hepb.gitsearcher.data.mapper

import com.github.hepb.gitsearcher.data.model.database.RepoDbModel
import com.github.hepb.gitsearcher.data.model.view.RepositoryViewModel
import com.github.hepb.gitsearcher.utils.timeToSting

class RepoDbToViewMapper : EntityMapper<RepoDbModel, RepositoryViewModel> {
    override fun map(model: RepoDbModel): RepositoryViewModel {
        with(model) {
            return RepositoryViewModel(
                    name = name,
                    description = description,
                    language = language,
                    watchersCount = watchersCount,
                    createdAt = timeToSting(createdAt),
                    updatedAt = timeToSting(updatedAt)
            )
        }
    }
}