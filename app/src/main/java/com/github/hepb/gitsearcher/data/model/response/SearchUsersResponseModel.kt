package com.github.hepb.gitsearcher.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchUsersResponseModel(
        @Expose @SerializedName("total_count") val totalCount: Int,
        @Expose @SerializedName("incomplete_results") val incompleteResults: Boolean,
        @Expose @SerializedName("items") val items: List<SearchUserResponseModel>
)