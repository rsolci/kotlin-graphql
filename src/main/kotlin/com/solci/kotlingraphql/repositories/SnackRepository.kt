package com.solci.kotlingraphql.repositories

import com.solci.kotlingraphql.entities.Snack
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SnackRepository {
    companion object {
        private val DB_MAP = mutableMapOf<UUID, Snack>()
    }

    fun insert(snack: Snack) {
        DB_MAP[snack.id] = snack
    }

    fun all(): List<Snack> {
        return DB_MAP.values.toList()
    }
}