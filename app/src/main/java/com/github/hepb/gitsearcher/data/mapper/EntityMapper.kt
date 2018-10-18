package com.github.hepb.gitsearcher.data.mapper

interface EntityMapper<in M, out E> {
    fun mapFromResponse(model: M): E
}