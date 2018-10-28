package com.github.hepb.gitsearcher.view

import com.github.hepb.gitsearcher.data.model.view.RepositoryViewModel

interface MvpReposView: MvpBaseFragment {
    fun initRepos(repositories: List<RepositoryViewModel>)
}