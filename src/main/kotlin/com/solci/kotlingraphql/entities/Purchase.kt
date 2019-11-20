package com.solci.kotlingraphql.entities

import java.time.Instant
import java.util.UUID

data class Purchase(
    val id: UUID,
    val amount: Long,
    val customerId: UUID,
    val merchantId: UUID,
    val createdAt: Instant = Instant.now()
)