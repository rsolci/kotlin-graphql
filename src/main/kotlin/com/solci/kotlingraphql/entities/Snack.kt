package com.solci.kotlingraphql.entities

import java.util.UUID

data class Snack(
    val id: UUID,
    val name: String,
    val amount: Long
)