package com.github.hepb.gitsearcher.data.mapper

import com.github.hepb.gitsearcher.data.model.database.RepoDbModel
import com.github.hepb.gitsearcher.data.model.view.RepositoryViewModel
import org.hamcrest.CoreMatchers.`is`
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class RepoDbToViewMapperTest {
    private lateinit var repoDb: RepoDbModel
    private lateinit var repositoryViewModel: RepositoryViewModel
    private lateinit var mapper: RepoDbToViewMapper

    @Before
    fun setUp() {
        repoDb = initRepoDbModel()
        repositoryViewModel = initRepositoryViewModel()
        mapper = RepoDbToViewMapper()
    }

    @Test
    fun mapTo() {
        assertThat(mapper.map(repoDb), `is`(repositoryViewModel))
    }
}