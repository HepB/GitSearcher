package com.github.hepb.gitsearcher.data.mapper

import com.github.hepb.gitsearcher.data.model.response.SearchUserResponseModel
import com.github.hepb.gitsearcher.data.model.view.SearchUserViewModel
import org.hamcrest.CoreMatchers.`is`
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class SearchUserRespToViewMapperTest {
    private lateinit var viewModel: SearchUserViewModel
    private lateinit var respModel: SearchUserResponseModel
    private lateinit var mapper: SearchUserRespToViewMapper

    @Before
    fun setUp() {
        viewModel = initSearchUserViewModel()
        respModel = initSearchUserResponseModel()
        mapper = SearchUserRespToViewMapper()
    }

    @Test
    fun mapTo() {
        assertThat(mapper.map(respModel), `is`(viewModel))
    }
}