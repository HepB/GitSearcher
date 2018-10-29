package com.github.hepb.gitsearcher.data.mapper

import com.github.hepb.gitsearcher.data.model.database.UserDbModel
import com.github.hepb.gitsearcher.data.model.response.UserResponseModel
import org.hamcrest.CoreMatchers.`is`
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class UserRespToDbMapperTest {
    private lateinit var respModel: UserResponseModel
    private lateinit var dbModel: UserDbModel
    private lateinit var mapper: UserRespToDbMapper

    @Before
    fun setUp() {
        respModel = initUserRespModel()
        dbModel = initUserDbModel()
        mapper = UserRespToDbMapper()
    }

    @Test
    fun mapTo() {
        assertThat(mapper.mapTo(respModel), `is`(dbModel))
    }
}