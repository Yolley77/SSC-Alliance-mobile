package ru.sscalliance.data.common

interface Mapper<T, F> {
    fun map(from: T): F
}