package com.github.hepb.gitsearcher.data.mapper

interface EntityMapper<in M, out E> {
    fun map(model: M): E
}