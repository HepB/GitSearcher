package com.github.hepb.gitsearcher.data.mapper

import com.github.hepb.gitsearcher.data.model.response.SearchUserResponseModel
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel

class SearchUserRespToViewMapper : EntityMapper<SearchUserResponseModel, SearchUserViewModel> {
    override fun map(model: SearchUserResponseModel): SearchUserViewModel =
            with(model) {
                return SearchUserViewModel(
                        login = login,
                        id = id,
                        avatarUrl = avatarUrl,
                        type = type,
                        siteAdmin = siteAdmin,
                        score = score
                )
            }
}
