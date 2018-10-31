package com.github.hepb.gitsearcher.data.mapper

import com.github.hepb.gitsearcher.data.model.database.UserDbModel
import com.github.hepb.gitsearcher.data.model.view.UserViewModel
import org.hamcrest.CoreMatchers.`is`
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class UserDbToViewMapperTest {
    private lateinit var dbModel: UserDbModel
    private lateinit var viewModel: UserViewModel
    private lateinit var mapper: UserDbToViewMapper

    @Before
    fun setUp() {
        dbModel = initUserDbModel()
        viewModel = initUserViewModel()
        mapper= UserDbToViewMapper()
    }

    @Test
    fun mapTo() {
        assertThat(mapper.map(dbModel), `is`(viewModel))
    }
}