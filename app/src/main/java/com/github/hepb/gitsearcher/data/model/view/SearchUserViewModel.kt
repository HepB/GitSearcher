package com.github.hepb.gitsearcher.data.model.view

data class SearchUserViewModel(
        val login: String,
        val id: Int,
        val avatarUrl: String,
        val type: String,
        val siteAdmin: Boolean,
        val score: Double
)