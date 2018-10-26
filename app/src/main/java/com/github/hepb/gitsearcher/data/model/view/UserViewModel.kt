package com.github.hepb.gitsearcher.data.model.view

data class UserViewModel(
        val login: String,
        val avatarUrl: String,
        val type: String,
        val name: String?,
        val company: String?,
        val location: String?,
        val bio: String?,
        val publicReposNum: Int,
        val followers: Int,
        val following: Int,
        val createdAt: String,
        val updatedAt: String
)