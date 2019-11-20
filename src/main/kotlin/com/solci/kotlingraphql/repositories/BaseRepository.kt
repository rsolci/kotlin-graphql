package com.solci.kotlingraphql.repositories

open class BaseRepository<ID, T> {
    protected val db = mutableMapOf<ID, T>()

    fun insert(id: ID, entity: T) {
        db[id] = entity
    }

    fun get(id: ID): T? {
        return db[id]
    }

    fun all(): List<T> {
        return db.values.toList()
    }
}