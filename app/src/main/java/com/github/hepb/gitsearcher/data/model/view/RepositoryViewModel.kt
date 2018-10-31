package com.github.hepb.gitsearcher.data.model.view

data class RepositoryViewModel(
        val name: String,
        val description: String?,
        val language: String?,
        val watchersCount: Int,
        val createdAt: String,
        val updatedAt: String
)