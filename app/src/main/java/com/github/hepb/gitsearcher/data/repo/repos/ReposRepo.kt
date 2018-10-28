package com.github.hepb.gitsearcher.data.repo.repos

import com.github.hepb.gitsearcher.data.model.view.RepositoryViewModel
import io.reactivex.Maybe

interface ReposRepo {
    fun getReposFromDb(): Maybe<List<RepositoryViewModel>>
}