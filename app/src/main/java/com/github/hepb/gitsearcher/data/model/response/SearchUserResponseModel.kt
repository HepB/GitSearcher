package com.github.hepb.gitsearcher.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchUserResponseModel(
        @Expose @SerializedName("login") val login: String,
        @Expose @SerializedName("id") val id: Int,
        @Expose @SerializedName("avatar_url") val avatarUrl: String,
        @Expose @SerializedName("type") val type: String,
        @Expose @SerializedName("site_admin") val siteAdmin: Boolean,
        @Expose @SerializedName("score") val score: Double
)