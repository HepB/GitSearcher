package com.github.hepb.gitsearcher.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RepoResponseModel(
        @Expose @SerializedName("name") val name: String,
        @Expose @SerializedName("description") val description: String,
        @Expose @SerializedName("language") val language: String,
        @Expose @SerializedName("watchers") val watchersCount: Int,

        @Expose @SerializedName("created_at") val createdAt: String,
        @Expose @SerializedName("updated_at") val updatedAt: String
)