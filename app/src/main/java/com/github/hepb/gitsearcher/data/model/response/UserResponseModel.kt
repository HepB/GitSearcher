package com.github.hepb.gitsearcher.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserResponseModel(
        @Expose @SerializedName("login") val login: String,
        @Expose @SerializedName("avatar_url") val avatarUrl: String,
        @Expose @SerializedName("type") val type: String,
        @Expose @SerializedName("site_admin") val siteAdmin: Boolean,

        @Expose @SerializedName("name") val name: String?,
        @Expose @SerializedName("company") val company: String?,
        @Expose @SerializedName("location") val location: String?,
        @Expose @SerializedName("bio") val bio: String?,

        @Expose @SerializedName("public_repos") val publicReposNum: Int,
        @Expose @SerializedName("followers") val followers: Int,
        @Expose @SerializedName("following") val following: Int,

        @Expose @SerializedName("created_at") val createdAt: String,
        @Expose @SerializedName("updated_at") val updatedAt: String
)