package com.github.hepb.gitsearcher.data.mapper

import com.github.hepb.gitsearcher.data.model.database.RepoDbModel
import com.github.hepb.gitsearcher.data.model.response.RepoResponseModel
import org.hamcrest.CoreMatchers.`is`
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class RepoRespToDbMapperTest {

    private lateinit var repoDbModel: RepoDbModel
    private lateinit var repoRespModel: RepoResponseModel
    private lateinit var mapper: RepoRespToDbMapper

    @Before
    fun setUp(){
        repoDbModel = initRepoDbModel()
        repoRespModel = initRepoResponseModel()
        mapper = RepoRespToDbMapper()

    }

    @Test
    fun mapTo() {
        assertThat(mapper.mapTo(repoRespModel), `is`(repoDbModel))
    }
}